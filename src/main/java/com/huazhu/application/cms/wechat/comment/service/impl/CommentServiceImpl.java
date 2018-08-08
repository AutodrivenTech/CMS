/**
 * Project Name		:	CMS
 * File Name		:	CommentServiceImpl.java
 * Package Name		:	com.huazhu.application.cms.wechat.comment.service.impl
 * Date				:	2018年8月3日上午11:11:42
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.comment.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.wechat.comment.bo.param.ResConCommentParamBO;
import com.huazhu.application.cms.wechat.comment.dao.ConInfoMapper;
import com.huazhu.application.cms.wechat.comment.dao.ConListDetailMapper;
import com.huazhu.application.cms.wechat.comment.dao.ResConCommentMapper;
import com.huazhu.application.cms.wechat.comment.entity.ConInfo;
import com.huazhu.application.cms.wechat.comment.entity.ConListDetail;
import com.huazhu.application.cms.wechat.comment.entity.ConListDetailExample;
import com.huazhu.application.cms.wechat.comment.entity.ResConComment;
import com.huazhu.application.cms.wechat.comment.entity.ResConCommentExample;
import com.huazhu.application.cms.wechat.comment.service.CommentService;
import com.huazhu.application.cms.wechat.dashboard.dao.PushApplyInfoMapper;
import com.huazhu.application.cms.wechat.dashboard.entity.PushApplyInfo;
import com.huazhu.application.cms.wechat.dashboard.entity.PushApplyInfoExample;
import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.CommentAPI;
import weixin.popular.bean.comment.Comment;
import weixin.popular.bean.comment.CommentList;
import weixin.popular.bean.comment.CommentListResult;
import weixin.popular.bean.comment.Params;

/**
 * ClassName		:	CommentServiceImpl <br/>
 * Function			:	评论业务接口实现. <br/>
 * Date				:	2018年8月3日 上午11:11:42 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PushApplyInfoMapper pushApplyInfoMapper;

	@Autowired
	private WXAccessTokenUtil util;

	@Autowired
	private ResConCommentMapper resConCommentMapper;

	@Autowired
	private ConListDetailMapper conListDetailMapper;

	@Autowired
	private ConInfoMapper conInfoMapper;

	/**
	 * 业务流程：.<br />
	 * step1:按照文章发布的时间倒叙查询所有已经发布的消息列表.<br />
	 * step2:循环消息列表取出每一篇文章或文章列表.<br />
	 * step3:查询当前文章的本地评论数量.<br />
	 * step4:调用微信接口循环查询本地未缓存的评论数据并做本地持久化操作.<br />
	 * step5:返回执行成功.<br />
	 *
	 * @see com.huazhu.application.cms.wechat.comment.service.CommentService#quartzPullAllComment()
	 */
	@Async
	@Override
	public Boolean quartzPullAllComment(Long conOrg) {
		// 按照文章发布的时间倒叙查询所有已经发布的消息列表
		PushApplyInfoExample example = new PushApplyInfoExample();
		example.setOrderByClause("push_time desc");

		// 判断参数的组织酒店是否存在，若存在则作为闸口限制条件
		if (conOrg == null) {
			example.createCriteria().andPushStatusEqualTo((byte) 30).andActiveFlagEqualTo((byte) 10);
		} else {
			example.createCriteria().andPushStatusEqualTo((byte) 30).andConOrgEqualTo(conOrg).andActiveFlagEqualTo((byte) 10);
		}

		// 调用数据查询接口查询数据
		List<PushApplyInfo> list = pushApplyInfoMapper.selectByExample(example);

		// 循环消息列表取出每一篇文章或文章列表
		for (PushApplyInfo o : list) {
			// 判断消息是否是单篇文章还是一个文章列表
			// 如果是文章列表
			if (o.getPushType() == 20) {
				// 查询当前文章列表中的所有文章
				ConListDetailExample exampleConList = new ConListDetailExample();
				exampleConList.createCriteria().andConListIdEqualTo(o.getPushCon()).andActiveFlagEqualTo((byte) 10);
				List<ConListDetail> listCon = conListDetailMapper.selectByExample(exampleConList);
				// 循环每一篇文章
				for (ConListDetail con : listCon) {
					// 查询当前文章的本地评论最后的评论id
					ResConCommentExample commentExample = new ResConCommentExample();
					commentExample.createCriteria().andConIdEqualTo(con.getRowId()).andActiveFlagEqualTo((byte) 10);
					List<ResConComment> commentList = resConCommentMapper.selectByExample(commentExample);

					Integer maxIndex = 0;

					for (ResConComment comment : commentList) {
						if (comment.getUserCommentId() > maxIndex) {
							maxIndex = comment.getUserCommentId().intValue();
						}
					}

					// 调用递归插叙评论接口查询评论信息
					this.pullConComment(con.getRowId(), Long.valueOf(o.getMsgDataId()), con.getOrderNum().intValue(), maxIndex);
				}
			} else {
				// 如果是单篇文章
				// 查询当前文章的本地评论最后的评论id
				ResConCommentExample commentExample = new ResConCommentExample();
				commentExample.createCriteria().andConIdEqualTo(o.getPushCon()).andActiveFlagEqualTo((byte) 10);
				List<ResConComment> commentList = resConCommentMapper.selectByExample(commentExample);

				Integer maxIndex = 0;

				for (ResConComment comment : commentList) {
					if (comment.getUserCommentId() > maxIndex) {
						maxIndex = comment.getUserCommentId().intValue();
					}
				}
				// 调用递归插叙评论接口查询评论信息
				this.pullConComment(o.getPushCon(), Long.valueOf(o.getMsgDataId()), null, maxIndex);
			}
		}
		return true;
	}

	/**
	 * 
	 * pullConComment		:	(调用微信接口，拉取当前文章的留言信息). <br/>
	 * 拉取方式为循环拉取，每次拉取最多50条数据（微信规定），直到拉取完为止，.<br/>
	 * 为避免过多的等待时间，拉取操作采用异步形式进行.<br/>
	 *
	 * @author					:	Alex Hu
	 * @param conId				:	要拉取的文章id
	 * @param msgDataId			:	文章对应的微信的消息id
	 * @param index				:	文章在文章列表中的位置
	 * @param beginIndex		:	当前文章的待拉取的留言的开始位置
	 * @return					:	拉取结果（由于采用了异步处理，因此该结果无任何参考意义，真正的吹结果请详见后期的消息通知机制或操作日志）
	 * @since					:	JDK 1.8
	 */
	private Boolean pullConComment(Long conId, Long msgDataId, Integer index, Integer beginIndex) {
		// 封装查询条件
		CommentList commentList = new CommentList();
		commentList.setMsg_data_id(msgDataId);
		if (index != null) {
			commentList.setIndex(index);
		}

		commentList.setBegin(beginIndex);
		commentList.setCount(50); // 每次最多49条数据
		commentList.setType(0);

		// 调用第三方微信接口查询数据
		CommentListResult list = CommentAPI.list(util.getAccess_token(), commentList);

		// 循环查询的结果做本地的数据缓存
		for (Comment o : list.getComment()) {
			ResConComment p = new ResConComment();
			p.setConId(conId);
			p.setUserCommentId(o.getUser_comment_id());
			p.setOpenid(o.getOpenid());
			p.setContent(o.getContent());
			p.setCommentType(o.getComment_type());
			p.setContentTime(o.getCreate_time());
			if (o.getReply() != null) {
				p.setReplyContent(o.getReply().getContent());
				p.setReplyTime(o.getReply().getCreate_time());
			}
			p.setCreateDate(new Date());
			p.setCreateUser(0L);
			p.setActiveFlag((byte) 10);

			resConCommentMapper.insertSelective(p);
		}

		// 判断当篇文章的微信评论数据是否全部缓存完成，如果没有完成，则递归调用本接口进行再次查询
		if (list.getComment().size() >= 49) {
			pullConComment(conId, msgDataId, index, beginIndex + list.getComment().size());
		}

		return true;
	}

	/**
	 * 查询留言数据. <br/>
	 * step1:封装查询分页条件 .<br />
	 * step1:调用数据接口查询数据 .<br />
	 * step1:封装并返回结果 .<br />
	 *
	 * @see com.huazhu.application.cms.wechat.comment.service.CommentService#selectData(com.huazhu.application.cms.wechat.comment.bo.param.ResConCommentParamBO)
	 */
	@Override
	public PageInfo<ResConComment> selectData(ResConCommentParamBO param) {
		// 封装查询分页条件
		ResConCommentExample example = new ResConCommentExample();

		example.setOrderByClause("content_time desc");
		if (StringUtils.isEmpty(param.getConId())) {
			example.createCriteria().andActiveFlagEqualTo((byte) 10);
		} else {
			example.createCriteria().andConIdEqualTo(param.getConId()).andActiveFlagEqualTo((byte) 10);
		}

		PageHelper.startPage(param.getPageNumber(), param.getPageSize());

		// 调用数据接口查询数据 
		List<ResConComment> list = resConCommentMapper.selectByExample(example);

		// 封装并返回结果
		return new PageInfo<>(list);
	}

	/**
	 * 开启留言功能.<br/>
	 * step1：根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）.<br />
	 * step2：如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步.<br />
	 * step3：修改当前文章的留言功能状态.<br />
	 * step4：返回业务处理成功.<br />
	 * 
	 * @see com.huazhu.application.cms.wechat.comment.service.CommentService#openComment(java.lang.Long)
	 */
	@Override
	public Boolean openComment(Long conId) {
		// 根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）
		// 如果是单篇文章的推送
		PushApplyInfoExample pushApplyInfoExample = new PushApplyInfoExample();
		pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<PushApplyInfo> pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
		for (PushApplyInfo o : pushApplyList) {
			// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
			if (o.getPushStatus() >= 30) {
				CommentAPI.open(util.getAccess_token(), Long.valueOf(o.getMsgDataId()), null);
			}
		}
		// 如果是文章列表的消息推送
		ConListDetailExample conListDetailExample = new ConListDetailExample();
		conListDetailExample.createCriteria().andConIdEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<ConListDetail> conListDetailList = conListDetailMapper.selectByExample(conListDetailExample);
		for (ConListDetail o : conListDetailList) {
			pushApplyInfoExample = new PushApplyInfoExample();
			pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(o.getConListId()).andActiveFlagEqualTo((byte) 10);
			pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
			for (PushApplyInfo p : pushApplyList) {
				// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
				if (p.getPushStatus() >= 30) {
					CommentAPI.open(util.getAccess_token(), Long.valueOf(p.getMsgDataId()), o.getOrderNum().intValue());
				}
			}
		}


		// 修改当前文章的留言功能状态
		ConInfo conInfo = new ConInfo();
		conInfo.setRowId(conId);
		conInfo.setConMessage((byte) 20);
		conInfoMapper.updateByPrimaryKeySelective(conInfo);

		return true;
	}

	/**
	 * 关闭留言功能.<br/>
	 * step1：根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）.<br />
	 * step2：如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步.<br />
	 * step3：修改当前文章的留言功能状态.<br />
	 * step4：返回业务处理成功.<br />
	 *
	 * @see com.huazhu.application.cms.wechat.comment.service.CommentService#closeComment(java.lang.Long)
	 */
	@Override
	public Boolean closeComment(Long conId) {
		// 根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）
		// 如果是单篇文章的推送
		PushApplyInfoExample pushApplyInfoExample = new PushApplyInfoExample();
		pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<PushApplyInfo> pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
		for (PushApplyInfo o : pushApplyList) {
			// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
			if (o.getPushStatus() >= 30) {
				CommentAPI.close(util.getAccess_token(), Long.valueOf(o.getMsgDataId()), null);
			}
		}
		// 如果是文章列表的消息推送
		ConListDetailExample conListDetailExample = new ConListDetailExample();
		conListDetailExample.createCriteria().andConIdEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<ConListDetail> conListDetailList = conListDetailMapper.selectByExample(conListDetailExample);
		for (ConListDetail o : conListDetailList) {
			pushApplyInfoExample = new PushApplyInfoExample();
			pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(o.getConListId()).andActiveFlagEqualTo((byte) 10);
			pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
			for (PushApplyInfo p : pushApplyList) {
				// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
				if (p.getPushStatus() >= 30) {
					CommentAPI.close(util.getAccess_token(), Long.valueOf(p.getMsgDataId()), o.getOrderNum().intValue());
				}
			}
		}


		// 修改当前文章的留言功能状态
		ConInfo conInfo = new ConInfo();
		conInfo.setRowId(conId);
		conInfo.setConMessage((byte) 10);
		conInfoMapper.updateByPrimaryKeySelective(conInfo);

		return true;
	}

	/**
	 * 精选留言功能.<br/>
	 * step1: 根据消息id查询该消息.<br />
	 * step2：根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）.<br />
	 * step3：如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步.<br />
	 * step4：修改当前文章的留言功能状态.<br />
	 * step5：返回业务处理成功.<br />
	 * 
	 *
	 * @see com.huazhu.application.cms.wechat.comment.service.CommentService#markelect(java.lang.Long)
	 */
	@Override
	public Boolean markelect(Long comId) {
		ResConComment conComment = resConCommentMapper.selectByPrimaryKey(comId);

		if (conComment == null) {
			return false;
		}

		Long conId = conComment.getConId();

		// 根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）
		// 如果是单篇文章的推送
		PushApplyInfoExample pushApplyInfoExample = new PushApplyInfoExample();
		pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<PushApplyInfo> pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
		for (PushApplyInfo o : pushApplyList) {
			// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
			if (o.getPushStatus() >= 30) {
				Params params = new Params();
				params.setMsg_data_id(Long.valueOf(o.getMsgDataId()));
				params.setUser_comment_id(conComment.getUserCommentId());
				params.setIndex(null);
				CommentAPI.markelect(util.getAccess_token(), params);
			}
		}
		// 如果是文章列表的消息推送
		ConListDetailExample conListDetailExample = new ConListDetailExample();
		conListDetailExample.createCriteria().andConIdEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<ConListDetail> conListDetailList = conListDetailMapper.selectByExample(conListDetailExample);
		for (ConListDetail o : conListDetailList) {
			pushApplyInfoExample = new PushApplyInfoExample();
			pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(o.getConListId()).andActiveFlagEqualTo((byte) 10);
			pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
			for (PushApplyInfo p : pushApplyList) {
				// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
				if (p.getPushStatus() >= 30) {
					Params params = new Params();
					params.setMsg_data_id(Long.valueOf(p.getMsgDataId()));
					params.setUser_comment_id(conComment.getUserCommentId());
					params.setIndex(o.getOrderNum().intValue());
					CommentAPI.markelect(util.getAccess_token(), params);
				}
			}
		}

		return true;
	}

	@Override
	public Boolean unmarkelect(Long comId) {
		ResConComment conComment = resConCommentMapper.selectByPrimaryKey(comId);

		if (conComment == null) {
			return false;
		}

		Long conId = conComment.getConId();

		// 根据文章查询文章推送的消息id（注意区分消息的类型是文章还是文章列表）
		// 如果是单篇文章的推送
		PushApplyInfoExample pushApplyInfoExample = new PushApplyInfoExample();
		pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<PushApplyInfo> pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
		for (PushApplyInfo o : pushApplyList) {
			// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
			if (o.getPushStatus() >= 30) {
				Params params = new Params();
				params.setMsg_data_id(Long.valueOf(o.getMsgDataId()));
				params.setUser_comment_id(conComment.getUserCommentId());
				params.setIndex(null);
				CommentAPI.unmarkelect(util.getAccess_token(), params);
			}
		}
		// 如果是文章列表的消息推送
		ConListDetailExample conListDetailExample = new ConListDetailExample();
		conListDetailExample.createCriteria().andConIdEqualTo(conId).andActiveFlagEqualTo((byte) 10);
		List<ConListDetail> conListDetailList = conListDetailMapper.selectByExample(conListDetailExample);
		for (ConListDetail o : conListDetailList) {
			pushApplyInfoExample = new PushApplyInfoExample();
			pushApplyInfoExample.createCriteria().andPushTypeEqualTo((byte) 10).andPushConEqualTo(o.getConListId()).andActiveFlagEqualTo((byte) 10);
			pushApplyList = pushApplyInfoMapper.selectByExample(pushApplyInfoExample);
			for (PushApplyInfo p : pushApplyList) {
				// 如果文章已经被推送出去，则调用第三方微信接口处理业务，反之执行下一步
				if (p.getPushStatus() >= 30) {
					Params params = new Params();
					params.setMsg_data_id(Long.valueOf(p.getMsgDataId()));
					params.setUser_comment_id(conComment.getUserCommentId());
					params.setIndex(o.getOrderNum().intValue());
					CommentAPI.unmarkelect(util.getAccess_token(), params);
				}
			}
		}

		return true;
	}
}

package com.huazhu.application.weixin.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.CommentAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.comment.CommentList;
import weixin.popular.bean.comment.CommentListResult;
import weixin.popular.bean.comment.ReplyAdd;

@Service
public class CommentService {
	
	@Autowired
	private WXAccessTokenUtil util;
	
	/**
	 * 指定文章的评论数据
	 * @param commentList
	 * @return
	 */
	public CommentListResult comments(CommentList commentList) {
		return CommentAPI.list(util.getAccess_token(), commentList);
	}
	
	/**
	 * 回复评论
	 * @param replyAdd
	 * @return
	 */
	public BaseResult replyAdd(ReplyAdd replyAdd) {
		return CommentAPI.replyAdd(util.getAccess_token(), replyAdd);
	}

}

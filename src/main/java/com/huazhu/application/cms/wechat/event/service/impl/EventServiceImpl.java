/**
 * Project Name		:	CMS
 * File Name		:	EventServiceImpl.java
 * Package Name		:	com.huazhu.application.cms.wechat.event.service.impl
 * Date				:	2018年7月31日上午10:12:56
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.event.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.huazhu.application.cms.organization.dao.HotelMapper;
import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.wechat.event.dao.CustomerInfoMapper;
import com.huazhu.application.cms.wechat.event.entity.CustomerInfo;
import com.huazhu.application.cms.wechat.event.entity.CustomerInfoExample;
import com.huazhu.application.cms.wechat.event.service.EventService;

/**
 * ClassName		:	EventServiceImpl <br/>
 * Function			:	事件响应接口实现. <br/>
 * Reason			:	处理微信相关的事件响应的业务逻辑. <br/>
 * Date				:	2018年7月31日 上午10:12:56 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class EventServiceImpl implements EventService {

	/**
	 * 默认的场景值 .<br />
	 * 当用户在关注公众号（如公众号搜索的方式），公众号没有任何场景值的情况下使用默认场景值 .<br />
	 */
	private static final String DEFULT_QRSCENE = "qrscene_-1";

	@Autowired
	private CustomerInfoMapper customerInfoMapper;

	@Autowired
	private HotelMapper hotelMapper;

	/**
	 * 当用户通过搜索公众号并进行关注时触发此接口的业务逻辑.<br/>
	 * 业务流程：.<br/>
	 * setp1:校验参数是否合法有效，即openId不为空.如果无效直接返回false.<br/>
	 * step2:根据openid查询本地数据库中是否有对应的有效用户.<br/>
	 * step3:如果没有有效用户，则进行step8.<br/>
	 * step4:如果存在有效用户，判断该用户的酒店标签与当前事件触发时的标签（默认场景值）是否一致.<br/>
	 * step5:如果已有的标签与当前事件触发时的标签（默认场景值）一致，则直接退出并返回操作成功.<br/>
	 * step6:如果已有的标签与当前事件触发时的标签（默认场景值）不一致，则继续往下执行.<br/>
	 * step7:修改当前已有的标签数据，将其状态改为取消关注（即20 无效）.<br/>
	 * step8:对该用户进行添加，并将新的场景值（默认场景值）赋予该用户.<br/>
	 * step9:执行完毕，返回成功.<br/>
	 *
	 * @see com.huazhu.application.cms.wechat.event.service.EventService#subscribe(java.lang.String)
	 */
	@Override
	public Boolean subscribe(String openId) {
		// 校验参数是否合法有效，即openId不为空.如果无效直接返回false.<br/>
		if (StringUtils.isEmpty(openId)) {
			return false;
		}
		// 根据openid查询本地数据库中是否有对应的有效用户.<br/>
		// 查询是否存在客户数据的查询条件  条件为 openid精确查询 且数据状态为有效
		CustomerInfoExample checkHasCustomerParam = new CustomerInfoExample();
		checkHasCustomerParam.createCriteria().andCusOpenIdEqualTo(openId).andActiveFlagEqualTo((byte) 10);
		// 根据条件查询用户列表
		List<CustomerInfo> checkHasCustomerResultList = customerInfoMapper.selectByExample(checkHasCustomerParam);

		// 判断列表是否存在
		if (checkHasCustomerResultList == null || checkHasCustomerResultList.size() == 0) {
			// 如果没有有效用户，则进行step7.<br/>
			// 对该用户进行添加，并将新的场景值（默认场景值）赋予该用户.<br/>
			CustomerInfo addCusParam = new CustomerInfo();
			addCusParam.setHotelId(Long.valueOf(DEFULT_QRSCENE.replace("qrscene_", "")));
			addCusParam.setCusOpenId(openId);
			addCusParam.setCreateDate(new Date());
			addCusParam.setCreateUser(0L);
			addCusParam.setFollowDate(new Date());
			addCusParam.setActiveFlag((byte) 10);
			customerInfoMapper.insertSelective(addCusParam);
			// step9:执行完毕，返回成功.<br/>
			return true;
		}

		// 如果存在有效用户，判断该用户的酒店标签与当前事件触发时的标签（默认场景值）是否一致.<br/>
		if (Integer.valueOf(DEFULT_QRSCENE.replace("qrscene_", "")).equals(checkHasCustomerResultList.get(0).getHotelId())) {
			// 如果已有的标签与当前事件触发时的标签（默认场景值）一致，则直接退出并返回操作成功.<br/>
			return true;
		}

		// 如果已有的标签与当前事件触发时的标签（默认场景值）不一致，则继续往下执行.<br/>
		// 修改当前已有的标签数据，将其状态改为取消关注（即20 无效）.<br/>
		CustomerInfo updateOldCusParam = checkHasCustomerResultList.get(0);
		updateOldCusParam.setActiveFlag((byte) 20);
		updateOldCusParam.setLastUpdateDate(new Date());
		updateOldCusParam.setLastUpdateUser(0L);
		customerInfoMapper.updateByPrimaryKeySelective(updateOldCusParam);

		// 对该用户进行添加，并将新的场景值（默认场景值）赋予该用户.<br/>
		CustomerInfo addNewCusParam = new CustomerInfo();
		BeanUtils.copyProperties(updateOldCusParam, addNewCusParam, "hotelId", "createDate", "createUser", "lastUpdateDate", "lastUpdateUser", "activeFlag");
		addNewCusParam.setHotelId(Long.valueOf(DEFULT_QRSCENE.replace("qrscene_", "")));
		addNewCusParam.setCreateDate(new Date());
		addNewCusParam.setCreateUser(0L);
		addNewCusParam.setActiveFlag((byte) 10);
		customerInfoMapper.insertSelective(addNewCusParam);
		// 执行完毕，返回成功.<br/>
		return true;
	}

	/**
	 * 当用户通过搜索公众号并进行取消关注时触发此接口的业务逻辑.<br/>
	 * 业务流程：.<br/>
	 * setp1:校验参数是否合法有效，即openId不为空.如果无效直接返回false.<br/>
	 * step2:根据openid查询本地数据库中对应的有效用户.<br />
	 * step3:修改当前有效用户的数据，将其状态改为取消关注（即20 无效）.<br />
	 * step4:执行完毕，返回成功.<br />
	 *
	 * @see com.huazhu.application.cms.wechat.event.service.EventService#unsubscribe(java.lang.String)
	 */
	@Override
	public Boolean unsubscribe(String openId) {
		// 根据openid查询本地数据库中是否有对应的有效用户.<br/>
		// 查询是否存在客户数据的查询条件  条件为 openid精确查询 且数据状态为有效
		CustomerInfoExample hasCustomerParam = new CustomerInfoExample();
		hasCustomerParam.createCriteria().andCusOpenIdEqualTo(openId).andActiveFlagEqualTo((byte) 10);
		// 根据条件查询用户列表
		List<CustomerInfo> hasCustomerResultList = customerInfoMapper.selectByExample(hasCustomerParam);

		//  修改当前有效用户的数据，将其状态改为取消关注（即20 无效）.<br/>
		if (hasCustomerResultList != null && hasCustomerResultList.size() > 0) {
			for (CustomerInfo o : hasCustomerResultList) {
				o.setActiveFlag((byte) 20);
				o.setLastUpdateDate(new Date());
				o.setLastUpdateUser(0L);
				customerInfoMapper.updateByPrimaryKeySelective(o);
			}
		}
		return true;
	}

	/**
	 * 当用户通过扫描带场景的时触发此接口的业务逻辑.<br/>
	 * 业务流程：.<br/>
	 * setp1:校验参数是否合法有效，即openId不为空.如果无效直接返回false.<br/>
	 * step2:根据openid查询本地数据库中是否有对应的有效用户.<br/>
	 * step3:如果没有有效用户，则进行step7.<br/>
	 * step4:如果存在有效用户，先执行step7后继续往下执行，判断该用户的酒店标签与当前事件触发时的标签（默认场景值）是否一致.<br/>
	 * step5:如果已有的标签与当前事件触发时的标签（默认场景值）一致，则直接退出并返回操作成功.<br/>
	 * step6:如果已有的标签与当前事件触发时的标签（默认场景值）不一致，则继续往下执行.<br/>
	 * setp7:查询当前场景值对应的酒店id,如果不存在则返回false.<br/>
	 * step8:修改当前已有的标签数据，将其状态改为取消关注（即20 无效）.<br/>
	 * step9:对该用户进行添加，并将新的场景值（默认场景值）赋予该用户.<br/>
	 * step10:执行完毕，返回成功.<br/>
	 *
	 * @see com.huazhu.application.cms.wechat.event.service.EventService#subscribeByQR(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean subscribeByQR(String openId, String qrscene) {
		// 校验参数是否合法有效，即openId不为空,qrscene不为空以及qrscene开头不合法.如果无效直接返回false.<br/>
		if (StringUtils.isEmpty(openId) || StringUtils.isEmpty(qrscene) || qrscene.indexOf("qrscene_") == -1) {
			return false;
		}
		// 根据openid查询本地数据库中是否有对应的有效用户.<br/>
		// 查询是否存在客户数据的查询条件  条件为 openid精确查询 且数据状态为有效
		CustomerInfoExample checkHasCustomerParam = new CustomerInfoExample();
		checkHasCustomerParam.createCriteria().andCusOpenIdEqualTo(openId).andActiveFlagEqualTo((byte) 10);
		// 根据条件查询用户列表
		List<CustomerInfo> checkHasCustomerResultList = customerInfoMapper.selectByExample(checkHasCustomerParam);

		// 判断列表是否存在
		if (checkHasCustomerResultList == null || checkHasCustomerResultList.size() == 0) {
			// 如果没有有效用户，则进行step7.<br/>
			// 查询当前场景值对应的酒店id,如果不存在则返回false.<br/>
			Hotel hotelParam = new Hotel();
			hotelParam.setSceneStr(DEFULT_QRSCENE.replace("qrscene_", ""));
			hotelParam.setActiveFlag(10);
			List<Hotel> hotelResultList = hotelMapper.queryHotel(hotelParam);
			if (hotelResultList == null || hotelResultList.size() == 0) {
				return false;
			}

			// 对该用户进行添加，并将新的场景值（默认场景值）赋予该用户.<br/>
			CustomerInfo addCusParam = new CustomerInfo();
			addCusParam.setHotelId(hotelResultList.get(0).getRowId());
			addCusParam.setCusOpenId(openId);
			addCusParam.setCreateDate(new Date());
			addCusParam.setCreateUser(0L);
			addCusParam.setFollowDate(new Date());
			addCusParam.setActiveFlag((byte) 10);
			customerInfoMapper.insertSelective(addCusParam);
			// step9:执行完毕，返回成功.<br/>
			return true;
		}

		// 如果存在有效用户，先执行step7后继续往下执行，判断该用户的酒店标签与当前事件触发时的标签（默认场景值）是否一致.<br/>
		// 查询当前场景值对应的酒店id,如果不存在则返回false.<br/>
		Hotel hotelParam = new Hotel();
		hotelParam.setSceneStr(DEFULT_QRSCENE.replace("qrscene_", ""));
		hotelParam.setActiveFlag(10);
		List<Hotel> hotelResultList = hotelMapper.queryHotel(hotelParam);
		if (hotelResultList == null || hotelResultList.size() == 0) {
			return false;
		}
		
		// 判断该用户的酒店标签与当前事件触发时的标签（默认场景值）是否一致
		if (hotelResultList.get(0).getRowId().intValue() == checkHasCustomerResultList.get(0).getHotelId()) {
			// 如果已有的标签与当前事件触发时的标签（默认场景值）一致，则直接退出并返回操作成功.<br/>
			return true;
		}

		// 如果已有的标签与当前事件触发时的标签（默认场景值）不一致，则继续往下执行.<br/>
		// 修改当前已有的标签数据，将其状态改为取消关注（即20 无效）.<br/>
		CustomerInfo updateOldCusParam = checkHasCustomerResultList.get(0);
		updateOldCusParam.setActiveFlag((byte) 20);
		updateOldCusParam.setLastUpdateDate(new Date());
		updateOldCusParam.setLastUpdateUser(0L);
		customerInfoMapper.updateByPrimaryKeySelective(updateOldCusParam);

		// 对该用户进行添加，并将新的场景值（默认场景值）赋予该用户.<br/>
		CustomerInfo addNewCusParam = new CustomerInfo();
		BeanUtils.copyProperties(updateOldCusParam, addNewCusParam, "hotelId", "createDate", "createUser", "lastUpdateDate", "lastUpdateUser", "activeFlag");
		addNewCusParam.setHotelId(hotelResultList.get(0).getRowId());
		addNewCusParam.setCreateDate(new Date());
		addNewCusParam.setCreateUser(0L);
		addNewCusParam.setActiveFlag((byte) 10);
		customerInfoMapper.insertSelective(addNewCusParam);
		// 执行完毕，返回成功.<br/>
		return true;
	}

}

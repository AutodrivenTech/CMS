/**
 * Project Name		:	CMS
 * File Name		:	DashboardServiceImpl.java
 * Package Name		:	com.huazhu.application.cms.wechat.dashboard.service.impl
 * Date				:	2018年8月1日上午10:02:32
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.wechat.dashboard.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.customer.dao.CusInfoMapper;
import com.huazhu.application.cms.customer.entity.CusInfoExample;
import com.huazhu.application.cms.organization.dao.HotelMapper;
import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.wechat.dashboard.bo.param.HotelInfoReportParamBO;
import com.huazhu.application.cms.wechat.dashboard.bo.result.HotelInfoReportResultBO;
import com.huazhu.application.cms.wechat.dashboard.dao.PushApplyInfoMapper;
import com.huazhu.application.cms.wechat.dashboard.entity.PushApplyInfoExample;
import com.huazhu.application.cms.wechat.dashboard.service.DashboardService;
import com.huazhu.application.utils.DateUtil;

/**
 * ClassName		:	DashboardServiceImpl <br/>
 * Function			:	仪表盘页面业务处理接口. <br/>
 * Reason			:	实现仪表盘界面的业务处理功能. <br/>
 * Date				:	2018年8月1日 上午10:02:32 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private HotelMapper hotelMapper;

	@Autowired
	private CusInfoMapper cusInfoMapper;

	@Autowired
	private PushApplyInfoMapper pushApplyInfoMapper;

	/**
	 * 业务流程：.<br/>
	 * step1: 封装分页查询条件，查询所有当前页中的所有酒店列表。.<br/>
	 * step2: 循环遍历每一家酒店，分别查出step3 - step5的信息.<br/>
	 * step3: 统计当前酒店所有的关注的有效用户数.<br/>
	 * step4: 统计当前酒店不包含当前周的近四周的每周的关注数/取消关注数较上一周的增减量.<br/>
	 * step5: 统计当前酒店包含本月在内的近三月的剩余消息发送量.<br/>
	 * step6: 封装返回信息并返回结果.<br/>
	 *
	 * @see com.huazhu.application.cms.wechat.dashboard.service.DashboardService#selectHotelInfoReportWithPage(com.huazhu.application.cms.wechat.dashboard.bo.param.HotelInfoReportParamBO)
	 */
	@Override
	public PageInfo<HotelInfoReportResultBO> selectHotelInfoReportWithPage(HotelInfoReportParamBO param) {
		// 存储返回信息对象
		PageInfo<HotelInfoReportResultBO> res = null;
		// 存储返回的结果列表
		List<HotelInfoReportResultBO> resList = new LinkedList<>();

		// 封装分页查询条件，查询所有当前页中的所有酒店列表。
		Hotel hotelParam = new Hotel();
		hotelParam.setBrandId(param.getBrandId());
		hotelParam.setActiveFlag(10);
		PageHelper.startPage(param.getPageNumber(), param.getPageSize());
		List<Hotel> hotelResultList = hotelMapper.queryHotel(hotelParam);

		// 循环遍历每一家酒店
		for (Hotel o : hotelResultList) {
			// 返回结果明细
			HotelInfoReportResultBO p = new HotelInfoReportResultBO();
			
			Map<String, String> countHotelMes = new TreeMap<>();

			// 统计当前酒店所有的关注的有效用户数
			CusInfoExample countCusParam = new CusInfoExample();
			countCusParam.createCriteria().andHotelIdEqualTo(o.getRowId()).andActiveFlagEqualTo((byte) 10);
			int hotelCusCouunt = cusInfoMapper.countByExample(countCusParam);

			p.setCustomerCount(hotelCusCouunt);

			p.setCustomerChange(this.selectHotelCusInfoReport(o.getRowId()));
			p.setHotel(o);

			// 统计当前酒店包含本月在内的近三月的剩余消息发送量
			PushApplyInfoExample example = new PushApplyInfoExample();

			// 统计当月的标准消息发送数
			example.createCriteria().andPushTimeBetween(DateUtil.getMonthStartDate(), DateUtil.addMonth(DateUtil.getMonthStartDate(), 1)).andConOrgEqualTo(o.getRowId()).andOrgTypeEqualTo((byte) 20).andPushStatusLessThan((byte) 40);
			int thisMouthStandard = pushApplyInfoMapper.countByExample(example);
			// 统计当月的交叉消息发送数
			example.createCriteria().andPushTimeBetween(DateUtil.getMonthStartDate(), DateUtil.addMonth(DateUtil.getMonthStartDate(), 1)).andConOrgEqualTo(o.getRowId()).andOrgTypeEqualTo((byte) 30).andPushStatusLessThan((byte) 40);
			int thisMouthCross = pushApplyInfoMapper.countByExample(example);

			// 统计上一月的标准消息发送数
			example.createCriteria().andPushTimeBetween(DateUtil.addMonth(DateUtil.getMonthStartDate(), -1), DateUtil.getMonthStartDate()).andConOrgEqualTo(o.getRowId()).andOrgTypeEqualTo((byte) 20).andPushStatusLessThan((byte) 40);
			int lastMouthStandard = pushApplyInfoMapper.countByExample(example);
			// 统计上一月的交叉消息发送数
			example.createCriteria().andPushTimeBetween(DateUtil.addMonth(DateUtil.getMonthStartDate(), -1), DateUtil.getMonthStartDate()).andConOrgEqualTo(o.getRowId()).andOrgTypeEqualTo((byte) 30).andPushStatusLessThan((byte) 40);
			int lastMouthCross = pushApplyInfoMapper.countByExample(example);

			// 统计上两月的标准消息发送数
			example.createCriteria().andPushTimeBetween(DateUtil.addMonth(DateUtil.getMonthStartDate(), -2), DateUtil.addMonth(DateUtil.getMonthStartDate(), -1)).andConOrgEqualTo(o.getRowId()).andOrgTypeEqualTo((byte) 20).andPushStatusLessThan((byte) 40);
			int lastSecondMouthStandard = pushApplyInfoMapper.countByExample(example);
			// 统计上一月的交叉消息发送数
			example.createCriteria().andPushTimeBetween(DateUtil.addMonth(DateUtil.getMonthStartDate(), -2), DateUtil.addMonth(DateUtil.getMonthStartDate(), -1)).andConOrgEqualTo(o.getRowId()).andOrgTypeEqualTo((byte) 30).andPushStatusLessThan((byte) 40);
			int lastSecondMouthCross = pushApplyInfoMapper.countByExample(example);

			countHotelMes.put(DateUtil.dateToString(DateUtil.getMonthStartDate(), DateUtil.DATE_FORMAT), (2 - thisMouthStandard) + "," + (1 - thisMouthCross));
			countHotelMes.put(DateUtil.dateToString(DateUtil.addMonth(DateUtil.getMonthStartDate(), -1), DateUtil.DATE_FORMAT), (2 - lastMouthStandard) + "," + (1 - lastMouthCross));
			countHotelMes.put(DateUtil.dateToString(DateUtil.addMonth(DateUtil.getMonthStartDate(), -2), DateUtil.DATE_FORMAT), (2 - lastSecondMouthStandard) + "," + (1 - lastSecondMouthCross));
			
			p.setHotelMeg(countHotelMes);
			
			resList.add(p);
		}

		res = new PageInfo<>(resList);

		return res;
	}

	private Map<String, String> selectHotelCusInfoReport(Long hotelId){
		Map<String, String> customerChange = new TreeMap<>();

		CusInfoExample countCusParam = new CusInfoExample();

		// 统计当前酒店不包含当前周的近四周的每周的关注数/取消关注数较上一周的增减量.
		// 统计当前周的前一周的客户关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -1 * 7), DateUtil.getWeekLastDate()).andActiveFlagEqualTo((byte) 10);
		int beforeFristWeekCustomerIncrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前一周的客户取消关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -1 * 7), DateUtil.getWeekLastDate()).andActiveFlagEqualTo((byte) 20);
		int beforeFristWeekCustomerDecrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前两周的客户关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -2 * 7), DateUtil.addDay(DateUtil.getWeekLastDate(), -1 * 7)).andActiveFlagEqualTo((byte) 10);
		int beforeSecondWeekCustomerIncrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前两周的客户取消关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -2 * 7), DateUtil.addDay(DateUtil.getWeekLastDate(), -1 * 7)).andActiveFlagEqualTo((byte) 20);
		int beforeSecondWeekCustomerDecrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前三周的客户关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -3 * 7), DateUtil.addDay(DateUtil.getWeekLastDate(), -2 * 7)).andActiveFlagEqualTo((byte) 10);
		int beforeThirdWeekCustomerIncrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前三周的客户取消关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -3 * 7), DateUtil.addDay(DateUtil.getWeekLastDate(), -2 * 7)).andActiveFlagEqualTo((byte) 20);
		int beforeThirdWeekCustomerDecrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前三周的客户关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -4 * 7), DateUtil.addDay(DateUtil.getWeekLastDate(), -3 * 7)).andActiveFlagEqualTo((byte) 10);
		int beforeFourWeekCustomerIncrement = cusInfoMapper.countByExample(countCusParam);
		// 统计当前周的前三周的客户取消关注数
		countCusParam = new CusInfoExample();
		countCusParam.createCriteria().andHotelIdEqualTo(hotelId).andCreateDateBetween(DateUtil.addDay(DateUtil.getWeekStartDate(), -4 * 7), DateUtil.addDay(DateUtil.getWeekLastDate(), -3 * 7)).andActiveFlagEqualTo((byte) 20);
		int beforeFourWeekCustomerDecrement = cusInfoMapper.countByExample(countCusParam);

		// 封装返回值信息
		customerChange.put(DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekStartDate(), -1 * 7), "MM.dd") + "-" + DateUtil.dateToString(DateUtil.getWeekLastDate(), "MM.dd"), beforeFristWeekCustomerIncrement + "," + beforeFristWeekCustomerDecrement);
		customerChange.put(DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekStartDate(), -2 * 7), "MM.dd") + "-" + DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekLastDate(), -1 * 7), "MM.dd"), beforeSecondWeekCustomerIncrement + "," + beforeSecondWeekCustomerDecrement);
		customerChange.put(DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekStartDate(), -3 * 7), "MM.dd") + "-" + DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekLastDate(), -2 * 7), "MM.dd"), beforeThirdWeekCustomerIncrement + "," + beforeThirdWeekCustomerDecrement);
		customerChange.put(DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekStartDate(), -4 * 7), "MM.dd") + "-" + DateUtil.dateToString(DateUtil.addDay(DateUtil.getWeekLastDate(), -3 * 7), "MM.dd"), beforeFourWeekCustomerIncrement + "," + beforeFourWeekCustomerDecrement);

		return customerChange;
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.addMonth(DateUtil.getMonthStartDate(), -8).getMonth());
		System.out.println(DateUtil.dateToString(DateUtil.getMonthStartDate(), DateUtil.DATE_FORMAT));
	}

}

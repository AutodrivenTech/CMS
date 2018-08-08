package com.huazhu.application.weixin.statistical.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.user.UsercumulateResult;
import weixin.popular.bean.datacube.user.UsersummaryResult;

/**
 * 用户分析数据
 * @author 
 *
 */
@Service
public class UserStatisticalService {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
	@Autowired
	private WXAccessTokenUtil util;
	
	/**
	 * 用户增减数据,7
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UsersummaryResult getusersummary(Date begin_date, Date end_date) {
		return DataCubeAPI.getusersummary(util.getAccess_token(), sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 累计用户数据,7
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UsercumulateResult getusercumulate(Date begin_date, Date end_date) {
		return DataCubeAPI.getusercumulate(util.getAccess_token(), sdf.format(begin_date), sdf.format(end_date));
	}

}

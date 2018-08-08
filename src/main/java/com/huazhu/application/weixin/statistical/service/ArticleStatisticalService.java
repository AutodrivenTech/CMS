package com.huazhu.application.weixin.statistical.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.article.ArticlesummaryResult;
import weixin.popular.bean.datacube.article.ArticletotalResult;
import weixin.popular.bean.datacube.article.UserreadResult;
import weixin.popular.bean.datacube.article.UsershareResult;
/**
 * 图文
 * @author 
 *
 */
@Service
public class ArticleStatisticalService {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private WXAccessTokenUtil util;
	
	/**
	 * 图文群发每日数据,1
	 * @return
	 */
	public ArticlesummaryResult getarticlesummary(Date time ) {
		
		return DataCubeAPI.getarticlesummary(util.getAccess_token(), sdf.format(time), sdf.format(time));
	}
	
	/**
	 * 图文群发总数据,1
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public ArticletotalResult getarticletotal(Date time) {
		
		return DataCubeAPI.getarticletotal(util.getAccess_token(), sdf.format(time), sdf.format(time));
	}
	
	/**
	 * 图文统计数据,3
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UserreadResult getuserread(Date begin_date, Date end_date) {
		return DataCubeAPI.getuserread(util.getAccess_token(), sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 图文统计分时数据,1
	 * @param time
	 * @return
	 */
	public UserreadResult getuserreadhour(Date time) {
		return DataCubeAPI.getuserreadhour(util.getAccess_token(), sdf.format(time), sdf.format(time));
	}
	
	/**
	 * 图文分享转发数据,7
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UsershareResult getusershare(Date begin_date, Date end_date) {
		
		return DataCubeAPI.getusershare(util.getAccess_token(), sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 图文分享转发分时数据,1
	 * @param time
	 * @return
	 */
	public UsershareResult getusersharehour(Date time) {
		
		return DataCubeAPI.getusersharehour(util.getAccess_token(), sdf.format(time), sdf.format(time));
	}
	
	

}

package com.huazhu.application.weixin.statistical.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.datacube.upstreammsg.UpstreammsgResult;
/**
 * 消息分析数据
 * @author 
 *
 */
@Service
public class MessStatisticalService {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
	@Autowired
	private WXAccessTokenUtil util;
	
	/**
	 * 消息发送概况数据,7
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UpstreammsgResult getupstreammsg(Date begin_date,Date end_date) {
		return DataCubeAPI.getupstreammsg(util.getAccess_token(), sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 消息分送分时数据,1
	 * @param time
	 * @return
	 */
	public UpstreammsgResult getupstreammsghour(Date time) {
		return DataCubeAPI.getupstreammsghour(util.getAccess_token(), sdf.format(time), sdf.format(time));
	}
	
	/**
	 * 消息发送周数据,30
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UpstreammsgResult getupstreammsgweek(Date begin_date,Date end_date) {
		return DataCubeAPI.getupstreammsgweek(util.getAccess_token(), sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 消息发送月数据,30
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UpstreammsgResult getupstreammsgmonth(Date begin_date,Date end_date) {
		return DataCubeAPI.getupstreammsgdistmonth(util.getAccess_token(),  sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 消息发送分布数据,15
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UpstreammsgResult getupstreammsgdist(Date begin_date,Date end_date) {
		return DataCubeAPI.getupstreammsgdist(util.getAccess_token(),  sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 消息发送分布周数据,30
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UpstreammsgResult getupstreammsgdistweek(Date begin_date,Date end_date) {
		return DataCubeAPI.getupstreammsgdistweek(util.getAccess_token(),  sdf.format(begin_date), sdf.format(end_date));
	}
	
	/**
	 * 消息发送分布月数据,30
	 * @param begin_date
	 * @param end_date
	 * @return
	 */
	public UpstreammsgResult getupstreammsgdistmonth(Date begin_date,Date end_date) {
		return DataCubeAPI.getupstreammsgdistmonth(util.getAccess_token(),  sdf.format(begin_date), sdf.format(end_date));
	}

}



















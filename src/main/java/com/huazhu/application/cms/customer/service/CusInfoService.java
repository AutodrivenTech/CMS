/**
 * Project Name		:	CMS
 * File Name		:	CusInfoService.java
 * Package Name		:	com.huazhu.application.cms.customer.service
 * Date				:	2018年7月11日下午5:54:45
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
 */

package com.huazhu.application.cms.customer.service;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.base.service.BaseService;
import com.huazhu.application.cms.customer.dto.customer.param.CusInfoParamDTO;
import com.huazhu.application.cms.customer.dto.customer.result.CusInfoResultDTO;
import com.huazhu.application.cms.customer.dto.customer.result.CusTagInfoDTO;
import com.huazhu.application.cms.customer.entity.CusInfo;
import com.huazhu.application.cms.customer.entity.CusTagInfo;
import com.huazhu.application.common.data.format.DataTable;

import java.util.List;

/**
 * ClassName		:	CusInfoService <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午5:54:45 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
public interface CusInfoService extends BaseService<CusInfo> {
	DataTable<CusInfoResultDTO> selectDataTableByParam(CusInfoParamDTO param);

	PageInfo<CusInfo>  getCusInfoList(CusInfo cusInfo,Integer pageNo,Integer pageSize);



	Integer deleteCusInfo(Long rowId,Integer userId);

	 List<String> getCusInfo(Integer filterId);

	void exprotCus(CusInfo cusInfo);

	List<String> getCusOpenId(Integer hotelId);

	List<CusTagInfoDTO>  getCusTagInfoList();

	List<Integer> getCusTagInfoByCus(String openId,Integer tagId);

	Integer addCusTagInfo(CusTagInfo cusTagInfo);

	List<CusInfo> getCusInfoList(CusInfo cusInfo);
}
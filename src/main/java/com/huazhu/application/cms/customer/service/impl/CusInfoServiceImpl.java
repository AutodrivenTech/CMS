/**
 * Project Name		:	CMS
 * File Name		:	CusInfoServiceImpl.java
 * Package Name		:	com.huazhu.application.cms.customer.service.impl
 * Date				:	2018年7月11日下午6:12:50
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved.
 *
*/

package com.huazhu.application.cms.customer.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.customer.dto.customer.result.CusInfoExportDTO;
import com.huazhu.application.cms.customer.dto.customer.result.CusTagInfoDTO;
import com.huazhu.application.cms.customer.entity.CusTagInfo;
import com.huazhu.application.cms.fans.dao.FansFilterMapper;
import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.ExportExcelUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.huazhu.application.cms.customer.dao.CusInfoMapper;
import com.huazhu.application.cms.customer.dto.customer.param.CusInfoParamDTO;
import com.huazhu.application.cms.customer.dto.customer.result.CusInfoResultDTO;
import com.huazhu.application.cms.customer.entity.CusInfo;
import com.huazhu.application.cms.customer.entity.CusInfoExample;
import com.huazhu.application.cms.customer.service.CusInfoService;
import com.huazhu.application.common.data.format.DataTable;
import org.springframework.util.CollectionUtils;

/**
 * ClassName		:	CusInfoServiceImpl <br/>
 * Function			:	TODO ADD FUNCTION. <br/>
 * Reason			:	TODO ADD REASON. <br/>
 * Date				:	2018年7月11日 下午6:12:50 <br/>
 *
 * @author			:	Alex Hu
 * @version			:	1.0.0
 * @since			:	JDK 1.8
 * @see
 */
@Service
@Slf4j
public class CusInfoServiceImpl implements CusInfoService {

	@Autowired
	private FansFilterMapper fansFilterMapper;
	
	@Autowired
	private CusInfoMapper cusInfoMapper;

	@Override
	public CusInfo selectByPrimaryKey(Long entityId) {
		return cusInfoMapper.selectByPrimaryKey(entityId);
	}

	@Override
	public List<CusInfo> select(CusInfo record) {
		return null;
	}

	@Override
	public List<CusInfo> selectAll() {
		return null;
	}

	@Override
	public CusInfo selectOne(CusInfo record) {
		return null;
	}

	@Override
	public List<CusInfo> selectByExample(Object example) {
		return cusInfoMapper.selectByExample((CusInfoExample) example);
	}

	@Override
	public List<CusInfo> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
		PageHelper.offsetPage(rowBounds.getOffset(), rowBounds.getLimit());
		return cusInfoMapper.selectByExample((CusInfoExample) example);
	}

	@Override
	public int selectCount(CusInfo record) {
		return 0;
	}

	@Override
	public int selectCountByExample(Object example) {
		return cusInfoMapper.countByExample((CusInfoExample) example);
	}

	@Override
	public List<CusInfo> selectByRowBounds(CusInfo record, RowBounds rowBounds) {
		return null;
	}

	@Override
	public boolean existsWithPrimaryKey(Long entityId) {
		return false;
	}

	@Override
	public int insert(CusInfo record) {
		return cusInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(CusInfo record) {
		record.setCreateDate(DateUtil.getCurrentTime());
		return cusInfoMapper.insertSelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Long entityId) {
		return cusInfoMapper.deleteByPrimaryKey(entityId);
	}

	@Override
	public int delete(CusInfo record) {
		return 0;
	}

	@Override
	public int deleteByExample(Object example) {
		return 0;
	}

	@Override
	public int updateByExample(CusInfo record, Object example) {
		return cusInfoMapper.updateByExample(record, (CusInfoExample) example);
	}

	@Override
	public int updateByExampleSelective(CusInfo record, Object example) {
		return 0;
	}



	@Override
	public Integer deleteCusInfo(Long rowId, Integer userId) {
		return cusInfoMapper.updateByPrimaryKeySelective(new CusInfo(){{
			setRowId(rowId);
			setLastUpdateDate(DateUtil.getCurrentTime());
			setLastUpdateUser(Long.valueOf(userId));
			setActiveFlag(ActiveFlagEnum.DELETE.getValue());
		}});
	}

	@Override
	public int updateByPrimaryKey(CusInfo record) {
		return cusInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(CusInfo record) {
		record.setLastUpdateDate(DateUtil.getCurrentTime());
		return cusInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public DataTable<CusInfoResultDTO> selectDataTableByParam(CusInfoParamDTO param) {
		DataTable<CusInfoResultDTO> res = new DataTable<CusInfoResultDTO>();
		List<CusInfoResultDTO> resList = new ArrayList<CusInfoResultDTO>();
		
		/**
		 * 查询条件
		 */
		CusInfoExample example = new CusInfoExample();
		
		List<CusInfo> list = this.selectByExample(example);

		res.setRecordsTotal(this.selectCountByExample(example));// TOOD
		res.setRecordsFiltered(list.size());
		res.setDraw(param.getDraw());

		for (CusInfo o : list) {
			CusInfoResultDTO p = new CusInfoResultDTO();
			BeanUtils.copyProperties(o, p);
			resList.add(p);
		}

		res.setData(resList);
		return res;
	}

	@Override
	public PageInfo<CusInfo> getCusInfoList(CusInfo cusInfo, Integer pageNo, Integer pageSize) {
		cusInfo.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		PageInfo<CusInfo> pageInfo=PageHelper.startPage(pageNo,pageSize).doSelectPageInfo(()->cusInfoMapper.queryCusInfoList(cusInfo));
		pageInfo.getList().forEach(cusInfo1 -> {
			List<CusTagInfoDTO> cusTagInfoDTOList=cusInfoMapper.queryCusTagById(cusInfo1.getRowId(),ActiveFlagEnum.VALID.getValue());
			cusInfo1.setTags(cusTagInfoDTOList);
		});
		return pageInfo;
	}


	public  List<String> getCusInfo(Integer filterId){
		FansFilterDTO fansFilterDTO=fansFilterMapper.getFansFilterDetail(filterId);
		List<String> cusInfoList=new ArrayList<>();
		if(fansFilterDTO!=null){
			cusInfoList=cusInfoMapper.getCusInfoByFilter(fansFilterDTO);
		}
		return cusInfoList;
	}

	public void exprotCus(CusInfo cusInfo){
		cusInfo.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		List<CusInfoExportDTO> cusInfoList=cusInfoMapper.queryCusInfo(cusInfo);
		cusInfoList.forEach(cusInfo1 -> {
			List<CusTagInfoDTO> cusTagInfoDTOList=cusInfoMapper.queryCusTagById(cusInfo1.getRowId(),ActiveFlagEnum.VALID.getValue());
			List<String> tagNames = cusTagInfoDTOList.stream().
					map(cusTagInfoDTO ->cusTagInfoDTO.getTagName()).collect(Collectors.toList());
			cusInfo1.setTagNames(String.join(",", tagNames));
		});
		if(CollectionUtils.isEmpty(cusInfoList)){
			return;
		}
		try {
			ExportExcelUtil.exportExcel(cusInfoList,DateUtil.getNowDate()+"cusInfoList");
		} catch (Exception e) {
			log.error("文件导出异常:{}",e.getMessage());
		}



	}

	@Override
	public List<String> getCusOpenId(Integer hotelId) {
		return cusInfoMapper.getCusOpenId(hotelId);
	}

	@Override
	public List<CusTagInfoDTO> getCusTagInfoList() {
		return cusInfoMapper.getCusTagInfo();
	}

	public List<Integer> getCusTagInfoByCus(String openId,Integer tagId){
		return cusInfoMapper.getCusTagInfoByCus(openId, tagId);
	}

	public Integer addCusTagInfo(CusTagInfo cusTagInfo){
		return cusInfoMapper.addCusTagInfo(cusTagInfo);
	}

	public List<CusInfo> getCusInfoList(CusInfo cusInfo){
		return  cusInfoMapper.queryCusInfoList(cusInfo);
	}
}

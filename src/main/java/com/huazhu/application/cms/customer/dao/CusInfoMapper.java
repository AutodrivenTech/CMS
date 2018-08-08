package com.huazhu.application.cms.customer.dao;

import com.huazhu.application.cms.customer.dto.customer.result.CusInfoExportDTO;
import com.huazhu.application.cms.customer.dto.customer.result.CusTagInfoDTO;
import com.huazhu.application.cms.customer.entity.CusInfo;
import com.huazhu.application.cms.customer.entity.CusInfoExample;
import java.util.List;

import com.huazhu.application.cms.customer.entity.CusTagInfo;
import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CusInfoMapper {
    int countByExample(CusInfoExample example);

    int deleteByExample(CusInfoExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(CusInfo record);

    int insertSelective(CusInfo record);

    List<CusInfo> selectByExample(CusInfoExample example);

    CusInfo selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") CusInfo record);

    int updateByExample(@Param("record") CusInfo record, @Param("example") CusInfoExample example);

    int updateByPrimaryKeySelective(CusInfo record);

    int updateByPrimaryKey(CusInfo record);

    Integer getCusInfoCount(FansFilterDTO fansFilterDTO);

    List<CusInfo> queryCusInfoList(CusInfo cusInfo);

    List<CusTagInfoDTO> queryCusTagById(@Param("cusId")Long cusId,@Param("activeFlag")Integer activeFlag);

    List<String> getCusInfoByFilter(FansFilterDTO fansFilterDTO);

    List<CusInfoExportDTO> queryCusInfo(CusInfo cusInfo);

    List<String> getCusOpenId(@Param("hotelId") Integer hotelId);


    Integer addCusTagInfo(CusTagInfo cusTagInfo);


    List<CusTagInfoDTO> getCusTagInfo();

    List<Integer>  getCusTagInfoByCus(@Param("openId")String openId,@Param("tagId")Integer tagId);
}
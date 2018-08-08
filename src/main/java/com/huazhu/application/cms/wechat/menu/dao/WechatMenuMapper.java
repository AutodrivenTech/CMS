package com.huazhu.application.cms.wechat.menu.dao;

import com.huazhu.application.cms.wechat.menu.entity.WechatMenu;
import com.huazhu.application.cms.wechat.menu.entity.WechatMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WechatMenuMapper {
    int countByExample(WechatMenuExample example);

    int deleteByExample(WechatMenuExample example);

    int deleteByPrimaryKey(Long rowId);

    int insert(WechatMenu record);

    int insertSelective(WechatMenu record);

    List<WechatMenu> selectByExample(WechatMenuExample example);

    WechatMenu selectByPrimaryKey(Long rowId);

    int updateByExampleSelective(@Param("record") WechatMenu record, @Param("example") WechatMenuExample example);

    int updateByExample(@Param("record") WechatMenu record, @Param("example") WechatMenuExample example);

    int updateByPrimaryKeySelective(WechatMenu record);

    int updateByPrimaryKey(WechatMenu record);
}
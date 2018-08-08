package com.huazhu.application.cms.analysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.analysis.entity.ArticleReadCount;

import org.apache.ibatis.annotations.Param;
import weixin.popular.bean.datacube.article.Articlesummary;

@Mapper
public interface WXAnalysisMapper {
	
	Integer insertarticlesummary(Articlesummary as);
	
    List<ArticleReadCount> getmontharticlesummary(Long hotelId);
    
    List<String> articleToOrg(String title);

    Integer getReadCount(@Param("title") String title);
   
}

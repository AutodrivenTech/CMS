package com.huazhu.application.cms.analysis.service;

import java.util.List;

import com.huazhu.application.cms.analysis.entity.ArticleReadCount;

import weixin.popular.bean.datacube.article.Articlesummary;

public interface WXAnalysisService {
	
    Integer insertarticlesummary(Articlesummary as);
	
    List<ArticleReadCount> getmontharticlesummary(Long hotelId);
    
    List<String> articleToOrg(String title);

}

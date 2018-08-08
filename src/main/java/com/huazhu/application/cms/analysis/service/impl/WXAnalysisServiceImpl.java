package com.huazhu.application.cms.analysis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.analysis.dao.WXAnalysisMapper;
import com.huazhu.application.cms.analysis.entity.ArticleReadCount;
import com.huazhu.application.cms.analysis.service.WXAnalysisService;
import com.huazhu.application.cms.article.entity.ArticleList;

import weixin.popular.bean.datacube.article.Articlesummary;

@Service
public class WXAnalysisServiceImpl implements WXAnalysisService {
	
	@Autowired
	private WXAnalysisMapper wxAnalysisMapper;

	@Override
	public Integer insertarticlesummary(Articlesummary as) {
		// TODO Auto-generated method stub
		return wxAnalysisMapper.insertarticlesummary(as);
	}

	@Override
	public List<ArticleReadCount> getmontharticlesummary(Long hotelId) {
		// TODO Auto-generated method stub
		return wxAnalysisMapper.getmontharticlesummary(hotelId);
	}

	@Override
	public List<String> articleToOrg(String title) {
		// TODO Auto-generated method stub
		return wxAnalysisMapper.articleToOrg(title);
	}

}

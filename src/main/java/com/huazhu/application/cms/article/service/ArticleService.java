package com.huazhu.application.cms.article.service;



import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.dto.BrandDTO;
import com.huazhu.application.cms.article.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {


	ArticleDTO queryArticleByRowId(Integer rowId);

	List<ArticleDTO> queryArticleByConditions(Article article,SysAccountInfo accountInfo);

	Map<String,Object> insertArticle(Article article);

	Map<String,Object> updateArticleByRowId(Article article);
	
	Integer deleteArticleByRowId(String rowId,Integer userId);

	Integer releaseArticle(Long rowId,Integer userId,Integer status);

	List<ArticleDTO> queryArticleList(SysAccountInfo sysAccountInfo);

	List<ArticleDTO> getArticleByTagId(Article article);

	List<BrandDTO> getBrandAndHotel(SysAccountInfo sysAccountInfo);



}

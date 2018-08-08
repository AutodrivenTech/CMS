package com.huazhu.application.cms.article.service;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dto.ArticleListDTO;
import com.huazhu.application.cms.article.entity.ArticleList;

public interface ArticleListService {

	List<ArticleListDTO> queryArticleList(ArticleList articleList, SysAccountInfo accountInfo);
	
	Integer insertArticleList(ArticleList articleList,String[] articleIds,Integer[] orderNums);
	
	Integer updateArticleListByRowId(ArticleList articleList,String[] articleIds,Integer[] orderNums);
	
	Integer deleteArticleListByRowId(Long rowId,Integer userId);

	ArticleListDTO getArticleListDetail(Integer rowId);


}

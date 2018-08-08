package com.huazhu.application.cms.article.dao;

import java.util.List;

import com.huazhu.application.cms.article.dto.ArticleListDTO;
import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.entity.ArticleList;
import com.huazhu.application.cms.article.entity.ArticleListDetail;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleListMapper {
	
	List<ArticleListDTO> queryArticleList(ArticleList articleList);
	
	Integer insertArticleList(ArticleList articleList);
	
	Integer updateArticleListByRowId(ArticleList articleList);

	Integer deleteConlistDetail(Long conListId);

	
	Integer insertArticleListDetail(ArticleListDetail articleListDetail);

	ArticleListDTO queryArticleListById(@Param("rowId")Integer rowId);
	

}

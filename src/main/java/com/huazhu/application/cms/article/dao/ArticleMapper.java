package com.huazhu.application.cms.article.dao;

import java.util.List;

import com.huazhu.application.cms.article.dto.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.entity.ArticleTags;
import com.huazhu.application.cms.tags.entity.Tags;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {


	ArticleDTO queryArticleByRowId(@Param("rowId") Integer rowId);
	
	List<ArticleDTO> queryArticleByConditions(Article article);
	
	Integer insertArticle(Article article);
	
	Integer updateArticleByRowId(Article article);
	
	Integer deleteArticleByRowId(@Param("rowId") Integer rowId,@Param("activeFlag")Integer activeFlag);
	

	List<ArticleDTO>  getArticleInfoByListId(@Param("articleListId") Long articleListId,@Param("activeFlag")Integer activeFlag,@Param("articleId")String articleId);


	List<ArticleDTO> queryArticleByStatus(@Param("status")Integer status,@Param("activeFlag")Integer activeFlag,@Param("hotelId")Integer hotelId);

	List<ArticleDTO> queryArticleByStatusAndShare(@Param("status")Integer status,@Param("activeFlag")Integer activeFlag,@Param("hotelId")Integer hotelId);

	List<ArticleDTO> queryArticleByShare(Article article);


}

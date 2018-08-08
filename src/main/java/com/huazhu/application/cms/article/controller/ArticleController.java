package com.huazhu.application.cms.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.common.BasicController;
import com.huazhu.application.cms.organization.service.BrandService;
import com.huazhu.application.cms.tags.entity.Tags;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.service.ArticleService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cms/article/")
public class ArticleController  extends BasicController {
	
	@Autowired
	private ArticleService articleService;

	@Autowired
    private BrandService brandService;
	
	@ApiOperation(value = "新增文章" , notes = "新增文章")
	@PostMapping("/addArticle")
	public Map<String,Object> addArticle(Article article){
		Map<String,Object> map = new HashMap<String,Object>();
		if(article == null) {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		//article.setCreateUser(Long.valueOf(getUserId()));
		map = articleService.insertArticle(article);
		return map;
	}
	
	
	@ApiOperation(value = "修改文章" , notes = "修改文章")
	@PostMapping("/eidtArticle")
	public Map<String,Object> eidtArticle(@RequestBody  Article article){
		Map<String,Object> map = new HashMap<String,Object>();
		if(article == null) {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		//	article.setLastUpdateUser(Long.valueOf(getUserId()));
			map = articleService.updateArticleByRowId(article);
		return map;
	}
	
	@ApiOperation(value = "预览文章" , notes = "预览文章")
	@RequestMapping("/previewArticle")
	public Map<String,Object> previewArticle(Integer rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null) {
			ArticleDTO article=articleService.queryArticleByRowId(rowId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, article);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "条件查询文章列表" , notes = "模糊条件查询文章列表")
	@RequestMapping("/getMaterialByConditions")
	public Map<String,Object> getArticleByConditions(Article article,Integer pageNum,Integer limit){
		Map<String,Object> map = new HashMap<String,Object>();
		SysAccountInfo accountInfo=getUserInfo();
		if(pageNum==null ||  limit==null ){
			List<ArticleDTO> articleDTOList=articleService.queryArticleList(accountInfo);
			map.put(Constant.RETURN_DATA, articleDTOList);
		}else{
			PageHelper.startPage(pageNum,limit);
			List<ArticleDTO> articleDTOList = articleService.queryArticleByConditions(article,accountInfo);
			PageInfo<ArticleDTO> pageData = new PageInfo<ArticleDTO>(articleDTOList);
			map.put(Constant.RETURN_DATA, pageData);
		}
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);

		return map;
	}


	@ApiOperation(value = "删除")
	@PostMapping("/deleteArticle")
	public Map<String,Object> deleteArticle(@RequestParam("rowId") String rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtils.isBlank(rowId)){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		if(articleService.deleteArticleByRowId(rowId,null)<=0){
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}else{
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}
		return map;
	}



	@ApiOperation(value = "发布文章")
	@RequestMapping("/releaseArticle")
	public Map<String,Object> releaseArticle(Long rowId,Integer status){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId==null || rowId<=0){
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
			return map;
		}
		if(articleService.releaseArticle(rowId,null,status)<=0){
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}else{
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}
		return map;
	}


    @ApiOperation(value = "获取酒店信息")
    @GetMapping("/getHotelList")
	public Map<String,Object> getHotelList(){
        Map<String,Object> map=new HashMap<>();
        map.put(Constant.RETURN_DATA,articleService.getBrandAndHotel(getUserInfo()));
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        return map;
    }




}

package com.huazhu.application.cms.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.huazhu.application.cms.article.dto.ArticleListDTO;
import com.huazhu.application.cms.common.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.article.entity.ArticleList;
import com.huazhu.application.cms.article.service.ArticleListService;
import com.huazhu.application.common.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "文章列表")
@RestController
@RequestMapping("/cms/articleList/")
public class ArticleListController extends BasicController {

    @Autowired
    private ArticleListService articleListService;

    @ApiOperation(value = "查询文章列表", notes = "查询文章列表")
    @RequestMapping("/getArticleList")
    public Map<String, Object> getArticleList(ArticleList articleList, Integer pageNum, Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (pageNum == null || limit == null) {
            List<ArticleListDTO> articleDTOList = articleListService.queryArticleList(null, getUserInfo());
            map.put(Constant.RETURN_DATA, articleDTOList);
        } else {
            PageHelper.startPage(pageNum, limit);
            List<ArticleListDTO> articleDTOList = articleListService.queryArticleList(articleList, getUserInfo());
            PageInfo<ArticleListDTO> pageData = new PageInfo<ArticleListDTO>(articleDTOList);
            map.put(Constant.RETURN_DATA, pageData);
        }
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        return map;
    }

    @ApiOperation(value = "新增文章列表", notes = "新增文章列表")
    @PostMapping("/addArticleList")
    public Map<String, Object> addArticleList(ArticleList articleList, String[] articleIds,Integer[] orderNums) {
        Map<String, Object> map = new HashMap<String, Object>();
       // articleList.setCreateUser(Long.valueOf(getUserId()));
        Integer result = articleListService.insertArticleList(articleList, articleIds,orderNums);
        if (result != null && result > 0) {
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        } else {
            map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
            map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
        }
        return map;
    }

    @ApiOperation(value = "编辑文章列表", notes = "编辑文章列表")
    @PostMapping("/editArticleList")
    public Map<String, Object> editArticleList(ArticleList articleList, String[] articleIds,Integer[] orderNums) {
        Map<String, Object> map = new HashMap<String, Object>();
      //  articleList.setLastUpdateUser(Long.valueOf(getUserId()));
        Integer result = articleListService.updateArticleListByRowId(articleList, articleIds,orderNums);
        if (result != null && result > 0) {
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        } else {
            map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
            map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
        }
        return map;
    }

    @ApiOperation(value = "删除文章列表", notes = "删除文章列表")
    @PostMapping("/deleteArticleList")
    public Map<String, Object> deleteArticleList(Long rowId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer result = articleListService.deleteArticleListByRowId(rowId,null);
        if (result != null && result > 0) {
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        } else {
            map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
            map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
        }
        return map;
    }


    @ApiOperation(value = "预览文章列表")
    @RequestMapping("/getArticleListDetail")
    public Map<String, Object> getArticleListDetail(Integer rowId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (rowId == null || rowId <= 0) {
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return map;
        }
        ArticleListDTO articleListDTO = articleListService.getArticleListDetail(rowId);
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        map.put(Constant.RETURN_DATA, articleListDTO);
        return map;
    }


}

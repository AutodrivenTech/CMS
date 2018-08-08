package com.huazhu.application.cms.tags.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.service.ArticleService;
import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import com.huazhu.application.cms.fans.dto.FansFilterResultDTO;
import com.huazhu.application.cms.fans.service.FansFilterService;
import com.huazhu.application.cms.material.entity.Material;
import com.huazhu.application.cms.material.service.MaterialService;
import com.huazhu.application.common.Constant;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huazhu.application.cms.tags.dao.TagsMapper;
import com.huazhu.application.cms.tags.entity.Tags;
import com.huazhu.application.cms.tags.service.TagsService;
import org.springframework.util.CollectionUtils;

@Service
public class TagsServiceImpl implements TagsService {
    
	@Autowired
	private TagsMapper tagsMapper;

	@Autowired
	private MaterialService materialService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private FansFilterService fansFilterService;
	

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Map<String,Object> insertTags(Tags tags) {
		Map<String,Object> map=new HashMap<>();
		if(!getTagByName(tags.getTabChineseName(),tags.getTagType())){
			map.put(Constant.RETURN_CODE, Constant.TAG_ERROR_CODE);
			map.put(Constant.RETURN_MSG, Constant.TAG_ERROR_MSG);
			return map;
		}
		tags.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		tags.setLastUpdateDate(DateUtil.getCurrentTime());
		Integer result = tagsMapper.insertTags(tags);
		if(result != null && result >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA,tags.getRowId());
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer deleteTagsByRowId(Long rowId,Integer userId) {
		Integer result=0;
		List<Material> materialList=materialService.getMaterialList(new Material(){{
			setTagId(rowId.intValue());
		}});
		List<ArticleDTO> articleDTOList=articleService.getArticleByTagId(new Article(){{setConTag(rowId.intValue());}});
		if(!CollectionUtils.isEmpty(materialList) || !CollectionUtils.isEmpty(articleDTOList)){
			return result;
		}
		result=tagsMapper.updateTags(new Tags(){{
			setLastUpdateDate(DateUtil.getCurrentTime());
			//setLastUpdateUser(userId.longValue());
			setActiveFlag(ActiveFlagEnum.DELETE.getValue());
			setRowId(rowId);
		}});
		return result;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Map<String,Object> updateTags(Tags tags) {
		Map<String,Object> map=new HashMap<>();
		Tags tagsInfo=queryTagsByRowId(tags.getRowId());
		if(!getTagByName(tags.getTabChineseName(),tags.getTagType())){
			if (Objects.equals(tagsInfo.getTabChineseName(),tags.getTabChineseName())) {
				map.put(Constant.RETURN_CODE, Constant.TAG_ERROR_CODE);
				map.put(Constant.RETURN_MSG, Constant.TAG_ERROR_MSG);
				return map;
			}
			}
		tags.setLastUpdateDate(DateUtil.getCurrentTime());
		if(tagsMapper.updateTags(tags) >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Tags queryTagsByRowId(Long rowId) {
		// TODO Auto-generated method stub
		return tagsMapper.queryTagsByRowId(rowId);
	}

	@Override
	public List<Tags> queryTagsConditions(Tags tags) {
		tags.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		// TODO Auto-generated method stub
		return tagsMapper.queryTagsConditions(tags);
	}

	public boolean getTagByName(String tagName,Integer type){
		Tags tags=tagsMapper.queryTagsByRowName(tagName,type);
		if(tags!=null){
			return false;
		}
		return true;
	}

	@Override
	public PageInfo<Tags> queryTagsList(Tags tags, Integer pageNo, Integer pageSize) {
		tags.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		PageInfo<Tags> pageInfo = PageHelper.startPage(pageNo, pageSize)
				.doSelectPageInfo(() -> tagsMapper.queryTagsConditions(tags));

		return pageInfo;
	}

}

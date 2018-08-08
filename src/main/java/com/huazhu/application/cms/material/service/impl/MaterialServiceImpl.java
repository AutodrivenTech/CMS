package com.huazhu.application.cms.material.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.service.ArticleService;
import com.huazhu.application.common.Constant;
import com.huazhu.application.common.ImageUpload;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import com.huazhu.application.weixin.material.service.WXMaterialService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huazhu.application.cms.material.dao.MaterialMapper;
import com.huazhu.application.cms.material.entity.Material;
import com.huazhu.application.cms.material.service.MaterialService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import weixin.popular.bean.media.Media;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	private ImageUpload imageUpload;
    
	@Autowired
	private MaterialMapper materialMapper;


	@Value("${img.material}")
	private String material;

	@Autowired
	private WXMaterialService wxMaterialService;

	@Autowired
	private ArticleService articleService;
	

	@Override
	public Material queryMaterialByRowId(Integer rowId) {
		return materialMapper.queryMaterialByRowId(rowId);
	}

	@Override
	public PageInfo<Material> queryMaterialByConditions(Material material,Integer pageNo,Integer pageSize) {
		material.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		PageInfo<Material> pageInfo = PageHelper.startPage(pageNo, pageSize)
				.doSelectPageInfo(() -> materialMapper.queryMaterialByConditions(material));
		return pageInfo;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer insertMaterial(Material material,MultipartFile file) {
		material.setCreateDate(DateUtil.getCurrentTime());
		material.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		if(file!=null){
			if(material.getIsUpload()==0){
				material.setImgUrl(upload(file));
			}else{
				//上传至微信媒体库
				Media media= wxMaterialService.add_material_thumb(file);
				if(media!=null){
					if(!StringUtils.isBlank(media.getMedia_id())){
						material.setThumbMediaId(media.getMedia_id());
						material.setImgUrl(media.getUrl());
					}
				}
			}

		}

		return materialMapper.insertMaterial(material);
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer updateMaterialByRowId(Material material,MultipartFile file) {
		material.setLastUpdateDate(DateUtil.getCurrentTime());
		if(file!=null){
			if(material.getIsUpload()==0){
				material.setImgUrl(upload(file));
			}else{
				//上传至微信媒体库
				Media media= wxMaterialService.add_material_thumb(file);
				if(media!=null){
					if(!StringUtils.isBlank(media.getMedia_id())){
						material.setThumbMediaId(media.getMedia_id());
						material.setImgUrl(media.getUrl());
					}
				}
			}
		}
		return materialMapper.updateMaterialByRowId(material);
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Map<String,Object> deleteMaterialByRowId(String rowId, Integer userId) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<ArticleDTO> articleDTOList=articleService.getArticleByTagId(new Article(){{
			setMateId(rowId);
		}});
		if(!CollectionUtils.isEmpty(articleDTOList)){
			map.put(Constant.RETURN_CODE, Constant.MATE_ERROR_CODE);
			map.put(Constant.RETURN_MSG, Constant.MATE_ERROR_MSG);
			return map;
		}
		Integer result=materialMapper.updateMaterialByRowId(new Material(){{
			setRowId(rowId);
			//setLastUpdateUser(Long.valueOf(userId));
			setLastUpdateDate(DateUtil.getCurrentTime());
			setActiveFlag(ActiveFlagEnum.DELETE.getValue());
		}});
		if(result<=0){
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}else{
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}
		return map;
	}

	@Override
	public List<Material> getMaterialList(Material material) {
		material.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		return  materialMapper.queryMaterialByConditions(material);
	}

	private  String upload(MultipartFile file){
		return imageUpload.singlePictureUploaded(file,material);
	}

}

package com.huazhu.application.cms.material.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.material.entity.Material;
import org.springframework.web.multipart.MultipartFile;

public interface MaterialService {
	

	
	Material queryMaterialByRowId(Integer rowId);
	
	PageInfo<Material> queryMaterialByConditions(Material material,Integer pageNo,Integer pageSize);
	
	Integer insertMaterial(Material material,MultipartFile file);
	
	Integer updateMaterialByRowId(Material material,MultipartFile file);
	
	Map<String,Object> deleteMaterialByRowId(String rowId, Integer userId);

	List<Material> getMaterialList(Material material);

}

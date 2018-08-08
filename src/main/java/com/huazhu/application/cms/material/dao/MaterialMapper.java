package com.huazhu.application.cms.material.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.material.entity.Material;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaterialMapper {
	

	
	Material queryMaterialByRowId(@Param("rowId") Integer rowId);
	
	List<Material> queryMaterialByConditions(Material material);
	
	Integer insertMaterial(Material material);
	
	Integer updateMaterialByRowId(Material material);


	

}

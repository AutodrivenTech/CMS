package com.huazhu.application.cms.organization.dao;

import java.util.List;

import com.huazhu.application.cms.article.dto.BrandDTO;
import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.organization.entity.Brand;

@Mapper
public interface BrandMapper {
	
	List<Brand> queryBrand(Brand brand);
	
	Brand queryBrandByRowId(Long rowId);
	
	List<Brand> queryBrandByConditions(Brand brand);
	
	Integer insertBrand(Brand brand);
	
	Integer updateBrandByRowId(Brand brand);
	
	Integer deleteBrandByRowId(Long rowId);
	
	List<Brand> queryBrandByGroupId(Long groupId);

	List<BrandDTO> getBrandList();

}

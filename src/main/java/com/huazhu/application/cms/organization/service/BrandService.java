package com.huazhu.application.cms.organization.service;

import java.util.List;
import java.util.Map;

import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dto.BrandDTO;
import com.huazhu.application.cms.organization.entity.Brand;

public interface BrandService {
	
	List<Brand> queryBrand(Brand brand);
	
	Brand queryBrandByRowId(Long rowId);
	
	List<Brand> queryBrandByConditions(Brand brand);
	
	Integer insertBrand(Brand brand);
	
	Integer updateBrandByRowId(Brand brand);
	
	Map<String,Object> deleteBrandByRowId(Long rowId);
	
	List<Brand> queryBrandByGroupId(Long groupId);

	List<BrandDTO>  getBrandList();

}

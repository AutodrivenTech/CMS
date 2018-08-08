package com.huazhu.application.cms.organization.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dto.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.organization.dao.BrandMapper;
import com.huazhu.application.cms.organization.dao.HotelMapper;
import com.huazhu.application.cms.organization.entity.Brand;
import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.organization.service.BrandService;
import com.huazhu.application.common.Constant;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private HotelMapper hotelMapper;

	@Override
	public List<Brand> queryBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.queryBrand(brand);
	}

	@Override
	public Brand queryBrandByRowId(Long rowId) {
		// TODO Auto-generated method stub
		return brandMapper.queryBrandByRowId(rowId);
	}

	@Override
	public List<Brand> queryBrandByConditions(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.queryBrandByConditions(brand);
	}

	@Override
	public Integer insertBrand(Brand brand) {
		// TODO Auto-generated method stub
		brand.setCreateDate(new Date());
		//brand.setCreateUser(createUser);
		return brandMapper.insertBrand(brand);
	}

	@Override
	public Integer updateBrandByRowId(Brand brand) {
		// TODO Auto-generated method stub
		brand.setLastUpdateDate(new Date());
		//brand.setLastUpdateUser(lastUpdateUser);
		return brandMapper.updateBrandByRowId(brand);
	}

	@Override
	public Map<String, Object> deleteBrandByRowId(Long rowId) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Hotel> hotels = hotelMapper.queryHotelByBrandId(rowId);
		if(hotels != null && hotels.size() > 0) {
			map.put(Constant.RETURN_CODE, Constant.EXIST_CHILDREN_CODE); 
			map.put(Constant.RETURN_MSG, Constant.EXIST_CHILDREN_MSG);
		}else {
			Integer result = brandMapper.deleteBrandByRowId(rowId);
			if(result > 0) {
				map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE); 
				map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE); 
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}
		return map;
	}

	@Override
	public List<Brand> queryBrandByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		return brandMapper.queryBrandByGroupId(groupId);
	}


	public List<BrandDTO>  getBrandList(){
		List<BrandDTO> brandDTOList=brandMapper.getBrandList();

		return brandDTOList;
	}


}

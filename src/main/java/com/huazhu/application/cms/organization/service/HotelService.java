package com.huazhu.application.cms.organization.service;

import java.util.List;

import com.huazhu.application.cms.organization.entity.Hotel;

public interface HotelService {
	
    List<Hotel> queryHotel(Hotel hotel);
	
	Hotel queryHotelByRowId(Long rowId);
	
	List<Hotel> queryBrandByConditions(Hotel hotel);
	
	Integer insertHotel(Hotel hotel);
	
	Integer updateHotelByRowId(Hotel hotel);
	
	Integer deleteHotelByRowId(Long rowId);
	
	List<Hotel> queryHotelByBrandId(Long brandId);
	

}

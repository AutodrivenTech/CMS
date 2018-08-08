package com.huazhu.application.cms.organization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.huazhu.application.cms.organization.entity.Hotel;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HotelMapper {
	
	List<Hotel> queryHotel(Hotel hotel);
	
	Hotel queryHotelByRowId(Long rowId);
	
	List<Hotel> queryBrandByConditions(Hotel hotel);
	
	Integer insertHotel(Hotel hotel);
	
	Integer updateHotelByRowId(Hotel hotel);
	
	Integer deleteHotelByRowId(Long rowId);
	
	List<Hotel> queryHotelByBrandId(Long brandId);

	List<Hotel> queryHotelById(@Param("hotelId")String hotelId, @Param("activeFlag")Integer activeFlag);


	List<Hotel> getHotelByShare(@Param("brandId")Long brandId);

}

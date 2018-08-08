package com.huazhu.application.cms.organization.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.organization.service.HotelService;
import com.huazhu.application.common.Constant;
import com.huazhu.application.weixin.qr.service.WeChatQRCodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "酒店组织管理")
@RestController
@RequestMapping("/cms/organization/controller")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private WeChatQRCodeService qr;
	
	
	@ApiOperation(value = "新增酒店" , notes = "新增组织机构酒店")
	@RequestMapping("/addHotel")
	public Map<String,Object> addHotel(Hotel hotel){
		Map<String,Object> map = new HashMap<String,Object>();
		Integer result = hotelService.insertHotel(hotel);
		if(result >0) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else {
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "编辑酒店" , notes = "编辑组织机构酒店")
	@RequestMapping("/editHotel")
	public Map<String,Object> editHotel(Hotel hotel){
		Map<String,Object> map = new HashMap<String,Object>();
		if(hotel != null && hotel.getRowId() != null) {
			Integer result = hotelService.updateHotelByRowId(hotel);
			if(result >0) {
				map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
				map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			}else {
				map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
				map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
			}
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		
		return map;
	}
	
	@ApiOperation(value = "预览酒店" , notes = "预览组织机构酒店")
	@RequestMapping("/previewHotel")
	public Map<String,Object> previewHotel(Long rowId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(rowId != null) {
			Hotel data = hotelService.queryHotelByRowId(rowId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "查询酒店" , notes = "查询组织机构酒店")
	@RequestMapping("/queryHotel")
	public Map<String,Object> queryHotel(Hotel hotel){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Hotel> data = hotelService.queryHotel(hotel);
		if(data != null) {
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.NO_DATA_CODE);
			map.put(Constant.RETURN_MSG, Constant.NO_DATA_MSG);
		}
		return map;
	}
	
	@ApiOperation(value = "品牌下酒店" , notes = "品牌下酒店查询")
	@RequestMapping("/queryHotelByBrand")
	public Map<String,Object> queryHotelByBrand(Long brandId){
		Map<String,Object> map = new HashMap<String,Object>();
		if(brandId != null) {
			List<Hotel> data = hotelService.queryHotelByBrandId(brandId);
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA, data);
		}else {
			map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
			map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
		}
		return map;
	}
	
	@ApiOperation(value = "酒店二维码" , notes = "酒店微信服务号二维码")
	@RequestMapping("/showqrcode")
	public void showqrcode(Long hotelId, HttpServletResponse response) {
		if(hotelId != null) {
			Hotel hotel = hotelService.queryHotelByRowId(hotelId);
			if(hotel != null && hotel.getQrTictek() != null) {
				BufferedImage bi = qr.showqrcode(hotel.getQrTictek());
				response.setContentType("image/jpeg");
				//告诉浏览器不要缓存

				response.setHeader("Pragma", "no-cache");

				response.setHeader("Cache-Control", "no-cache");

				response.setIntHeader("Expires",-1);
				try {
					ImageIO.write(bi, "jpeg", response.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}

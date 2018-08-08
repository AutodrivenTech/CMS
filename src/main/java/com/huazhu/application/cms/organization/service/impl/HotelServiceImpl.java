package com.huazhu.application.cms.organization.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.cms.organization.dao.HotelMapper;
import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.organization.service.HotelService;
import com.huazhu.application.weixin.qr.service.WeChatQRCodeService;

import weixin.popular.bean.qrcode.QrcodeTicket;

@Service
public class HotelServiceImpl implements HotelService {
	
	private static final String TICKET_SUCC = "0";
	
	@Autowired
	private HotelMapper hotelMapper;
	
	@Autowired
	private WeChatQRCodeService qrCodeSevice;

	@Override
	public List<Hotel> queryHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelMapper.queryHotel(hotel);
	}

	@Override
	public Hotel queryHotelByRowId(Long rowId) {
		// TODO Auto-generated method stub
		return hotelMapper.queryHotelByRowId(rowId);
	}

	@Override
	public List<Hotel> queryBrandByConditions(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelMapper.queryBrandByConditions(hotel);
	}

	@Override
	public Integer insertHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String sceneStr = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
		QrcodeTicket ticket = qrCodeSevice.qrcodeCreateTemp(sceneStr);
		if(ticket != null && ticket.getTicket() != null) {
			hotel.setQrTictek(ticket.getTicket());
			hotel.setSceneStr(sceneStr);
			hotel.setCreateDate(new Date());
			//hotel.setCreateUser(createUser);
		}else {
			return 0;
		}
		return hotelMapper.insertHotel(hotel);
	}

	@Override
	public Integer updateHotelByRowId(Hotel hotel) {
		// TODO Auto-generated method stub
		hotel.setLastUpdateDate(new Date());
		//hotel.setLastUpdateUser(lastUpdateUser);
		return hotelMapper.updateHotelByRowId(hotel);
	}

	@Override
	public Integer deleteHotelByRowId(Long rowId) {
		// TODO Auto-generated method stub
		return hotelMapper.deleteHotelByRowId(rowId);
	}

	@Override
	public List<Hotel> queryHotelByBrandId(Long brandId) {
		// TODO Auto-generated method stub
		return hotelMapper.queryHotelByBrandId(brandId);
	}
	
}

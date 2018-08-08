package com.huazhu.application.weixin.qr.service;

import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.QrcodeAPI;
import weixin.popular.bean.qrcode.QrcodeTicket;

@Service
public class WeChatQRCodeService {
	
	//临时二维码有效期
	private static int EXPIRE_SECONDS = 30*24*60*60;
	
	@Autowired
	private WXAccessTokenUtil util;
	
	/**
	 * 临时二维码
	 * @param str
	 * @return
	 */
	public QrcodeTicket qrcodeCreateTemp(String str) {
		
		return QrcodeAPI.qrcodeCreateTemp(util.getAccess_token(), EXPIRE_SECONDS, str);
	}
	
	/**
	 * 下载临时二维码
	 * @param scene_str
	 * @return
	 */
	public BufferedImage showqrcodeTemp(String scene_str) {
		
		return QrcodeAPI.showqrcode(qrcodeCreateTemp(scene_str).getTicket());
	}
	/**
	 * 持久二维码
	 * @param scene_str
	 * @return
	 */
	public QrcodeTicket qrcodeCreateFinal(String scene_str){
		return QrcodeAPI.qrcodeCreateFinal(util.getAccess_token(), scene_str);
	}
	
	/**
	 * 下载持久二维码
	 * @param scene_str
	 * @return
	 */
	public BufferedImage showqrcodeFinal(String scene_str) {
			
		return QrcodeAPI.showqrcode(qrcodeCreateFinal(scene_str).getTicket());
	}
	
	/**
	 * 下载二维码
	 * @param ticket
	 * @return
	 */
	public BufferedImage showqrcode(String ticket) {
		return QrcodeAPI.showqrcode(ticket);
	}
}

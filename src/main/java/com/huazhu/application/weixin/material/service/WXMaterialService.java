package com.huazhu.application.weixin.material.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;

import weixin.popular.api.MaterialAPI;
import weixin.popular.api.MediaAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.material.Description;
import weixin.popular.bean.material.MaterialBatchgetResult;
import weixin.popular.bean.material.MaterialGetResult;
import weixin.popular.bean.media.Media;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.media.UploadimgResult;
import weixin.popular.bean.message.Article;

@Service
public class WXMaterialService {
	
	@Autowired
	private WXAccessTokenUtil token;
	
	/**
	 * 新增其他类型永久素材
	 * 
	 * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param inputStream
	 * @param descriptionwen
	 * @return
	 */
	public Media add_material(MediaType mediaType,InputStream inputStream,Description description){
		return MaterialAPI.add_material(token.getAccess_token(), mediaType, inputStream, description);
	}
	
	/**
	 * 上传微信素材库缩略图（封面）
	 * @param file
	 * @return
	 */
	public Media add_material_thumb(MultipartFile file){
		InputStream is = null;
		try {
			is = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return MaterialAPI.add_material(token.getAccess_token(), MediaType.thumb, is, null);
	}
	
	/**
	 * 删除永久素材
	 * @param media_id
	 * @return
	 */
	public BaseResult del_material(String media_id){ 
		return MaterialAPI.del_material(token.getAccess_token(), media_id);
	}
	
	/**
	 * 获取素材列表
	 * @param type
	 * @param offset
	 * @param count
	 * @return
	 */
	public MaterialBatchgetResult batchget_material(String type,int offset,int count){
		return MaterialAPI.batchget_material(token.getAccess_token(), type, offset, count);
	}
	
	/**
	 * 获取永久素材
	 * @param media_id
	 * @return
	 */
	public MaterialGetResult get_material(String media_id){
		return MaterialAPI.get_material(token.getAccess_token(), media_id);
	}
	
	/**
	 * 新增永久图文素材
	 * @param articles
	 * @return
	 */
	public Media add_news(List<Article> articles) {
		return MaterialAPI.add_news(token.getAccess_token(), articles);
	}
	
	/**
	 * 上传图文消息内的图片获取URL
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public UploadimgResult mediaUploadimg(MultipartFile file){
		InputStream is = null;
		try {
			is = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return MediaAPI.mediaUploadimg(token.getAccess_token(), is);
	}
	
	/**
	 * 上传图文消息内的图片获取URL
	 * 请注意，本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @param base64Str
	 * @return
	 */
	public UploadimgResult mediaUploadimg(String base64Str){
		return MediaAPI.mediaUploadimg(token.getAccess_token(), Base64ToInputStream(base64Str));
	}
	
	
	/**
	 * base64数据转化输入流
	 * @param base64Str
	 * @return
	 */
	private InputStream Base64ToInputStream(String base64Str) {
		base64Str = base64Str.replaceAll("data:image/jpeg;base64,", "");
		ByteArrayInputStream inputStream = null;
		byte[] bytes = Base64.decodeBase64(base64Str);
		inputStream = new ByteArrayInputStream(bytes);
		return inputStream;
	}
	
	/**
	 * 新增临时素材，缩略图（thumb）：64KB，支持JPG格式
	 * @param url
	 * @return
	 */
	public Media mediaUpload(String url){
		return MediaAPI.mediaUpload(token.getAccess_token(), MediaType.thumb, urlToInputStream(url));
	}
	
	/**
	 * 图片url地址转换输出流
	 * @param urlstr
	 * @return
	 */
	private InputStream urlToInputStream(String urlstr) {
		InputStream is = null;
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(urlstr);
			con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5 * 1000);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept-Charset", "UTF-8");
			con.setRequestProperty("contentType", "UTF-8");
			con.setRequestMethod("GET");
			is = con.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}
	
	/**
	 * 新增临时素材，缩略图（thumb）：64KB，支持JPG格式
	 * @param media
	 * @return
	 */
	public Media mediaUpload(InputStream inputStream){
		System.out.println("***********");
		return MediaAPI.mediaUpload(token.getAccess_token(), MediaType.thumb, inputStream);
	}
}

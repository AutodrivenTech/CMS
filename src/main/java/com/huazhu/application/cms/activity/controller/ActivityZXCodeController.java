package com.huazhu.application.cms.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huazhu.application.cms.activity.service.ActivityDetailInfoService;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.dto.ArticleListDTO;
import com.huazhu.application.cms.article.service.ArticleListService;
import com.huazhu.application.cms.article.service.ArticleService;
import com.huazhu.application.cms.common.zxing.QRCodeUtil;
import com.huazhu.application.cms.customer.entity.CusInfo;
import com.huazhu.application.cms.customer.entity.CusTagInfo;
import com.huazhu.application.cms.customer.service.CusInfoService;
import com.huazhu.application.common.Constant;
import com.huazhu.application.weixin.auth.service.WebPageAuthService;

import lombok.extern.slf4j.Slf4j;
import weixin.popular.bean.sns.SnsToken;
@Slf4j
@RestController
public class ActivityZXCodeController {
	
	
	private static final int width = 200;
	private static final int height = 200;
	private static final String format = "png";
	
	private static final int ACT_TYPE = 10; 
	private static final int ACT_LIST_TYPE = 20;
	
	@Value(value = "${auth.base.http}")
	private String auth_base_http;
	
	@Value(value = "${service.prefix}")
	private String service_prefix;
	
	@Value(value = "${article.preview.template}")
	private String art_template;
	
	@Autowired
	private WebPageAuthService webPageAuthService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleListService articleListService;
	
	@Autowired
	private CusInfoService cusInfoService;
	
	@Autowired
	private ActivityDetailInfoService actDetailInfoService;
	
	@RequestMapping("/activityCode")
	public void activityCode(HttpServletResponse response,int detailType,Long detailId,Long actDetailId) {
		String QR_CODE_HTTP = auth_base_http + "/" + service_prefix + "/webpageauth";
		String content = QR_CODE_HTTP +"?detailType=" + detailType + "&detailId=" + detailId + "&actDetailId=" + actDetailId;
		try {
			QRCodeUtil.get(width, height, format, content, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/webpageauth")
	public void webpageauth(HttpServletResponse response,int detailType,Long detailId,Long actDetailId) {
		log.info("webpageauth");
		actDetailInfoService.updateActDetailCount(actDetailId.intValue());
		String redirect_uri = auth_base_http + "/" + service_prefix + "/qrcontentView" + "?detailType=" + detailType +"&detailId=" + detailId;
		log.info("redirect_uri:" + redirect_uri);
		String wx_url = webPageAuthService.connectOauth2Authorize(redirect_uri, null, null);
		log.info("webpageauth**wx_url：" + wx_url);
		try {
			response.sendRedirect(wx_url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/qrcontentView")
	public void qrcontentView(HttpServletResponse response,int detailType,Long detailId,String code) {
		String web_url = auth_base_http + art_template + "?detailType=" + detailType +"&detailId=" + detailId + "&code" + code;
		try {
			response.sendRedirect(web_url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/qrcontentViewData")
	public Map<String, Object> qrcontentView1(int detailType,Long detailId,String code) {
		log.info("qrcontentView**code:" + code);
		Map<String,Object> map = new HashMap<String,Object>();
		if(detailType == ACT_TYPE) {
			ArticleDTO data = articleService.queryArticleByRowId(detailId.intValue());
			if(code != null) {
				SnsToken token = webPageAuthService.oauth2AccessToken(code);
				 log.info("qrcontentView**token:" + token.getOpenid());
				 if(data != null && data.getTagId() != null) {
					 List<Integer> tagids = cusInfoService.getCusTagInfoByCus(token.getOpenid(), data.getTagId());
					 if(tagids == null) {
						 CusInfo cusInfo = new CusInfo();
						 cusInfo.setCusOpenId(token.getOpenid());
						 cusInfo.setActiveFlag(Constant.ACTIVE_FLAG);
						 List<CusInfo> cusInfos = cusInfoService.getCusInfoList(cusInfo);
						 if(cusInfos != null && cusInfos.size() >0) {
							 CusTagInfo cusTagInfo = new CusTagInfo();
							 //cusTagInfo.setCreateUser(createUser);
							 cusTagInfo.setCusId(cusInfos.get(0).getRowId().intValue());
							 cusTagInfo.setTagId(data.getTagId());
							 cusInfoService.addCusTagInfo(cusTagInfo);
						 }
					 }
				 }
			}
			map.put(Constant.RETURN_DATA, data);
			map.put("type", ACT_TYPE);
		}else if(detailType == ACT_LIST_TYPE) {
			ArticleListDTO data = articleListService.getArticleListDetail(detailId.intValue());
			map.put(Constant.RETURN_DATA, data);
			map.put("type", ACT_LIST_TYPE);
		}
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		return map;
	}

}

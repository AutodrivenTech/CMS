package com.huazhu.application.weixin.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huazhu.application.cms.dictionary.entity.Dictionary;
import com.huazhu.application.cms.dictionary.service.DictionaryService;

import io.swagger.annotations.ApiOperation;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

@Component
public class WXAccessTokenUtil {
	
	//logback日志
    private final static Logger logger = LoggerFactory.getLogger(WXAccessTokenUtil.class);
	
    private final static String CMS_TOKEN = "CMS-TOKEN";
	
	@Value(value = "${weixin.appid}")
	private String wxappid;
	
	@Value(value = "${weixin.appsecret}")
	private String wxappsecret;
	
	@Autowired
	private DictionaryService dictionaryService;
	
	@ApiOperation(value = "获取access_token", notes = "获取access_token")
	public String getAccess_token() {
		/*Token t = TokenAPI.token(wxappid, wxappsecret);*/
		Dictionary dictionary = new Dictionary();
		dictionary.setCode(CMS_TOKEN);
		List<Dictionary> dics = dictionaryService.queryDictionary(dictionary);
		if(dics != null) {
			dictionary = dics.get(0);
		}
		logger.info("WXCommonUtil**getAccess_token(access_token) : " + dictionary.getValue());
		return dictionary.getValue();
	}
	
	@Scheduled(fixedRate = 1*60*60*1000,initialDelay = 2000)
	public void updateTask() {
		Token t = TokenAPI.token(wxappid, wxappsecret);
		logger.info("wxappid:" + wxappid + "****" +"wxappsecret:" + wxappsecret);
		logger.info("WXCommonUtil**getAccess_token(access_token) : " + t.getAccess_token());
		if(t.getAccess_token() != null) {
			Integer result = dictionaryService.updateDictionarycmsToken(t.getAccess_token());
			if(!(result >0)) {
				updateTask();
			}
		}else {
			updateTask();
		}
	}
	
	public static void main(String[] args) {
		String s = "12_5Qe3QxZPR6h2Pyg5UJMF9f1IlCTGNPw8EM5Dj_u1l4IIl5x_BnUcj5BxweBnHGYJuTwl2IESOMQWqxuaDDeb-zgG751JntRJzKtBRH2uYO-0-bknipSV9FfVZr9sjeA9TkIGVD9HkGnC6pQKGKQbACATXD";
		System.out.println(s.length());
	}

}

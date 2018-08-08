package com.huazhu.application.weixin;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huazhu.application.weixin.event.service.ReceiveEventPushService;

@Controller
@RequestMapping("/weChatToken")
public class WeChatToken {
	
	private static final String TOKEN = "tokencms";
	
	private static final String ENCODING = "UTF-8";
    @Autowired
    private ReceiveEventPushService receiveEventPushService;
	
    /**
     * 微信Token验证
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @RequestMapping(value = "get",method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
    public void getToken(String signature, String timestamp, String nonce, String echostr , HttpServletRequest request ,HttpServletResponse response) throws NoSuchAlgorithmException, IOException{
        // 将token、timestamp、nonce三个参数进行字典序排序
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("TOKEN:"+TOKEN);
        String[] params = new String[] { TOKEN, timestamp, nonce };
        Arrays.sort(params);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String clearText = params[0] + params[1] + params[2];
        String algorithm = "SHA-1";
        String sign = new String(
                org.apache.commons.codec.binary.Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));
        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (signature.equals(sign)) {
            response.getWriter().write(echostr);
        }
        
    }
    
    @RequestMapping(value = "get",method = RequestMethod.POST ,produces = "text/plain;charset=UTF-8")
    public void getToken(HttpServletRequest request, HttpServletResponse response) {
    	
    	try {
    		request.setCharacterEncoding(ENCODING);
        	response.setCharacterEncoding(ENCODING);
			response.getWriter().println(receiveEventPushService.processRequest(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}

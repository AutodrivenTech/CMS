package com.huazhu.application.cms.common;

import com.huazhu.application.cms.account.entity.SysAccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class BasicController {
    // 用户的session名称
    protected static final String USER_INFO = "userInfo";

    // 用户的session名称
    protected static final String HOTEL_INFO = "hotelInfo";


    @Autowired
    protected HttpSession session;

    /**
     * 获取userId
     * @return
     */
    protected Integer getUserId() {
        return Integer.valueOf(session.getAttribute(USER_INFO).toString());
    }

    /**
     * 获取hotelId
     * @return
     */
    protected SysAccountInfo getUserInfo() {
        return (SysAccountInfo)session.getAttribute(HOTEL_INFO);
    }
}

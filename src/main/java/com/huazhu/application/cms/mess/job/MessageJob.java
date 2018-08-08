package com.huazhu.application.cms.mess.job;

import com.huazhu.application.cms.mess.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageJob {

    @Autowired
    private MessageService messageService;

    /**
     * 设置消息过期
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    public void   setMessageExpire(){
        messageService.setMessageExpire();
    }
}

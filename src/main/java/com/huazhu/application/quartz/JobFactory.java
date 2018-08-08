package com.huazhu.application.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class JobFactory extends AdaptableJobFactory {
	
	@Autowired
	private AutowireCapableBeanFactory capableBeanFactory;
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		//调用父类的方法  
        Object jobInstance = super.createJobInstance(bundle);
        //spring注入
        capableBeanFactory.autowireBean(jobInstance);
		return jobInstance;
	}
	
	

}

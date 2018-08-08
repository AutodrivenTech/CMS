package com.huazhu.application.quartz;

import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
	
	@Autowired
	private JobFactory jobFactory;
	
	/**
	 * 注册调度器
	 * @return
	 */
	@Bean
	public SchedulerFactoryBean createSchedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setJobFactory(jobFactory);
		return schedulerFactoryBean;
	}
	
	/**
	 * 任务
	 * @return
	 */
	@Bean
	public JobDetailImpl createJobDetailImpl() {
		return new JobDetailImpl();
	}

}

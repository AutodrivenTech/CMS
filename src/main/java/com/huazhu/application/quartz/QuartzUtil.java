package com.huazhu.application.quartz;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.huazhu.application.cms.article.dto.ArticleDTO;

@Component
public class QuartzUtil {
	
	@Autowired
	private JobDetailImpl jobDetail;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	/**
	 * 
	 * @param job             任务类
     * @param date            任务时间
     * @param jobDetailName   任务消息名字
     * @param triggerIdentity 触发器的唯一名
     * @param description     触发器的描述
	 * @param url
	 * @param bodyParameter
	 */
	public synchronized void addJob(Job job, Date date, String jobDetailName, String triggerIdentity, String description, String url, String bodyParameter) {
        //job类的参数
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("url", url);
        jobDataMap.put("bodyParameter", bodyParameter);
        jobDataMap.put("jobDetailName", jobDetailName);
        //这是job类的任务
        jobDetail.setName(jobDetailName);
        jobDetail.setJobClass(job.getClass());
        jobDetail.setJobDataMap(jobDataMap);
        //作业触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerIdentity).withDescription(description)
                // .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))//循环间隔多久
                .startAt(date)//执行时间
                .build();
        //作业调度器
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            
        }
	}
	
	/**
	 * 
	 * @param job             任务类
     * @param date            任务时间
     * @param jobDetailName   任务消息名字
     * @param triggerIdentity 触发器的唯一名
     * @param description     触发器的描述
	 * @param touser 推送文章openid列表
	 * @param messId 推送消息id
	 * @param articles 推送文章列表
	 */
	public synchronized void addJob(Job job, Date date, String jobDetailName, String triggerIdentity, String description, Set<String> touser, List<ArticleDTO> articles,Long messId) {
        //job类的参数
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("touser", touser);
        jobDataMap.put("articles", articles);
        jobDataMap.put("messId", messId);
        jobDataMap.put("jobDetailName", jobDetailName);
        //这是job类的任务
        jobDetail.setName(jobDetailName);
        jobDetail.setJobClass(job.getClass());
        jobDetail.setJobDataMap(jobDataMap);
        //作业触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerIdentity).withDescription(description)
                // .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))//循环间隔多久
                .startAt(date)//执行时间
                .build();
        //作业调度器
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            //Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            
        }
	}
}

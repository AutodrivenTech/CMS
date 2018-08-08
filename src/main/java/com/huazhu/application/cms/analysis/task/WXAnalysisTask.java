package com.huazhu.application.cms.analysis.task;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huazhu.application.cms.analysis.service.WXAnalysisService;
import com.huazhu.application.weixin.statistical.service.ArticleStatisticalService;

import weixin.popular.bean.datacube.article.Articlesummary;
import weixin.popular.bean.datacube.article.ArticlesummaryResult;

@Component
public class WXAnalysisTask {
	private static final Logger logger = LoggerFactory.getLogger(WXAnalysisTask.class);

	@Autowired
	private WXAnalysisService wxAnalysisService;
	
	@Autowired
	private ArticleStatisticalService artStatService;
	
	//"0 15 08 ? * *" 每天上午8:15触发
	@Scheduled(cron = "0 15 08 ? * *")
	public void getarticlesummaryTask() {
		ArticlesummaryResult result = artStatService.getarticlesummary(new Date());
		logger.info("WXAnalysisTask**result:" + result);
		if(result != null) {
			List<Articlesummary> list = result.getList();
			for (Articlesummary as : list) {
				wxAnalysisService.insertarticlesummary(as);
			}
		}
		
		
	}

}

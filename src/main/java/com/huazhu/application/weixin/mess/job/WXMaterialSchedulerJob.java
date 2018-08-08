package com.huazhu.application.weixin.mess.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huazhu.application.weixin.common.WXAccessTokenUtil;
import com.huazhu.application.weixin.material.service.WXMaterialService;

import weixin.popular.api.MaterialAPI;
import weixin.popular.bean.material.MaterialBatchgetResult;
import weixin.popular.bean.material.MaterialBatchgetResultItem;
import weixin.popular.bean.material.MaterialcountResult;

@Component
public class WXMaterialSchedulerJob {
	private static final Logger logger = LoggerFactory.getLogger(WXMaterialSchedulerJob.class);
	
	private static final int MATER_COUNT = 3000;
	
	private static final int DEL_MATER_COUNT = 1000;
	
	private static final int MATER_LIMIT = 20;
	
	@Autowired
	private WXAccessTokenUtil token;
	
	@Autowired
	private WXMaterialService wxMaterialService;
	
	/**
	 * 定时删除微信永久图文素材
	 */
	@Scheduled(cron = "0 0 8 * * ?")
	public void deletempnewsMaterial() {
		logger.info("*****************定时删除微信永久图文素材********************");
		MaterialcountResult count = MaterialAPI.get_materialcount(token.getAccess_token());
		logger.info("微信永久图文素材总数:" + count);
		if(count.getNews_count() > MATER_COUNT) {
			for (int i = 0; i < DEL_MATER_COUNT/MATER_LIMIT; i++) {
				
				MaterialBatchgetResult result = wxMaterialService.batchget_material("news", i*MATER_LIMIT + (MATER_COUNT-DEL_MATER_COUNT -1), MATER_LIMIT);
				List<MaterialBatchgetResultItem> items = result.getItem();
				for (MaterialBatchgetResultItem item : items) {
					wxMaterialService.del_material(item.getMedia_id());
				}
				
			}
			logger.info("*****************定时删除微信永久图文素材********************");
			deletempnewsMaterial();
		}
		
	}

}

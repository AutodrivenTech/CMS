package com.huazhu.application.cms.analysis.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.analysis.entity.ArticleReadCount;
import com.huazhu.application.cms.analysis.service.WXAnalysisService;
import com.huazhu.application.common.Constant;

@RestController
@RequestMapping("/cms/analysis/controller")
public class ArtAnalysisController {
	
    	
	@Autowired
	private WXAnalysisService wxAnalysisService;
	@RequestMapping("/montharticlesummary")
	public Map<String, Object> montharticlesummary(@RequestParam(defaultValue = "1",value = "pageNo")int pageNum ,
			@RequestParam(defaultValue = Constant.PAGE_SIZE,value = "pageSize")int limit,
			Long hotelId){
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(pageNum, limit);
		List<ArticleReadCount> list = wxAnalysisService.getmontharticlesummary(hotelId);
		if(list != null) {
			for (ArticleReadCount a : list) {
				List<String> orgNames = wxAnalysisService.articleToOrg(a.getTitle());
				a.setOrgName(new HashSet<String>(orgNames));
			}
		}
		PageInfo<ArticleReadCount> data = new PageInfo<ArticleReadCount>(list);
		map.put("data", data);
		map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
		map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		return map;
	}

}

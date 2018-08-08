package com.huazhu.application.cms.article.service.impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.analysis.dao.WXAnalysisMapper;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.dto.BrandDTO;
import com.huazhu.application.cms.article.service.ArticleListService;
import com.huazhu.application.cms.organization.dao.BrandMapper;
import com.huazhu.application.cms.organization.dao.HotelMapper;
import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.organization.service.BrandService;
import com.huazhu.application.common.Constant;
import com.huazhu.application.common.ImageUpload;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import com.huazhu.application.utils.enums.ArticleStatus;
import com.huazhu.application.utils.enums.PushStatus;
import com.huazhu.application.utils.enums.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huazhu.application.cms.article.dao.ArticleMapper;
import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.service.ArticleService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private BrandService brandService;

	@Autowired
	private HotelMapper hotelMapper;

	@Autowired
	private WXAnalysisMapper wxAnalysisMapper;



	@Override
	public ArticleDTO queryArticleByRowId(Integer rowId) {
		ArticleDTO articleDTO=articleMapper.queryArticleByRowId(rowId);
		Integer readCount=wxAnalysisMapper.getReadCount(articleDTO.getConTitle());
		if(readCount!=null){
			articleDTO.setReadCount(readCount);
		}
		return articleDTO;
	}

	@Override
	public List<ArticleDTO> queryArticleByConditions(Article article,SysAccountInfo accountInfo) {
		article.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		List<ArticleDTO> articleDTOList=new ArrayList<>();
		/*if(article.getIsAccount()==10){
			article.setCreateUser(accountInfo.getRowId().longValue());
		}*/
		/*if(accountInfo.getUserType()==UserTypeEnum.SUBSIDIARY.getValue()){
			 article.setHotelId(accountInfo.getUserOrg());
			 articleDTOList= articleMapper.queryArticleByConditions(article);
			 List<ArticleDTO> shareArticle=articleMapper.queryArticleByShare(article);
			 articleDTOList.addAll(shareArticle);
		}else{*/
			articleDTOList= articleMapper.queryArticleByConditions(article);
		//}
		return articleDTOList;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Map<String,Object> insertArticle(Article article) {
		Map<String,Object> map=new HashMap<>();
		if(!CollectionUtils.isEmpty(getArticleDetail(article.getConTitle()))){
			map.put(Constant.RETURN_CODE,Constant.ARTICLE_ERROR_CODE);
			map.put(Constant.RETURN_MSG,Constant.ARTICLE_ERROR_MSG);
			return map;
		}
	    article.setKeyword(article.getConTitle());
		article.setCreateDate(DateUtil.getCurrentTime());
		article.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		article.setStatus(String.valueOf(ArticleStatus.UN_RELEASED.getValue()));
		Integer result=articleMapper.insertArticle(article);
		if(result>0){
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
			map.put(Constant.RETURN_DATA,article.getRowId());
		}else{
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Map<String,Object> updateArticleByRowId(Article article) {
		Map<String,Object> map=new HashMap<>();
		if(!CollectionUtils.isEmpty(getArticleDetail(article.getConTitle()))){
			map.put(Constant.RETURN_CODE,Constant.ARTICLE_ERROR_CODE);
			map.put(Constant.RETURN_MSG,Constant.ARTICLE_ERROR_MSG);
			return map;
		}
		article.setLastUpdateDate(DateUtil.getCurrentTime());
		Integer result=articleMapper.updateArticleByRowId(article);
		if(result>0){
			map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
			map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
		}else{
			map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
			map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
		}
		return map;
	}
    
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer deleteArticleByRowId(String rowId,Integer userId) {
		List<ArticleDTO> articles = articleMapper.getArticleInfoByListId(null, ActiveFlagEnum.VALID.getValue(),rowId);
		if(! CollectionUtils.isEmpty(articles)){
			return 0;
		}
		return articleMapper.updateArticleByRowId(new Article(){{
			setRowId(rowId);
			setActiveFlag(ActiveFlagEnum.DELETE.getValue());
			setLastUpdateDate(DateUtil.getCurrentTime());
			//setLastUpdateUser(Long.valueOf(userId));
		}});
	}

	@Override
	public Integer releaseArticle(Long rowId, Integer userId,Integer status) {
		return articleMapper.updateArticleByRowId(new Article(){{
			setRowId(rowId.toString());
			setLastUpdateDate(DateUtil.getCurrentTime());
			//setLastUpdateUser(Long.valueOf(userId));
			setReleaseTime(DateUtil.getCurrentTime());
			setStatus(status.toString());
		}});
	}

	@Override
	public List<ArticleDTO> queryArticleList(SysAccountInfo sysAccountInfo) {
		List<ArticleDTO> articleDTOList=new ArrayList<>();
	/*	if(sysAccountInfo.getUserType()==UserTypeEnum.SUBSIDIARY.getValue()){
			articleDTOList= articleMapper.queryArticleByStatus(ArticleStatus.UN_RELEASED.getValue(),ActiveFlagEnum.VALID.getValue(),sysAccountInfo.getUserOrg());
			List<ArticleDTO> shareArticle=articleMapper.queryArticleByStatusAndShare(ArticleStatus.UN_RELEASED.getValue(),ActiveFlagEnum.VALID.getValue(),sysAccountInfo.getUserOrg());
			articleDTOList.addAll(shareArticle);
		}else{*/
			articleDTOList= articleMapper.queryArticleByStatus(ArticleStatus.UN_RELEASED.getValue(),ActiveFlagEnum.VALID.getValue(),null);
		//}
		return articleDTOList;

	}

	public  List<ArticleDTO> getArticleByTagId(Article article){
		article.setActiveFlag(ActiveFlagEnum.VALID.getValue());
		return articleMapper.queryArticleByConditions(article );
	}

	public List<BrandDTO> getBrandAndHotel(SysAccountInfo sysAccountInfo){
		List<BrandDTO> brandDTOList=brandService.getBrandList();
			brandDTOList.forEach(brandDTO -> {
				List<Hotel> hotels=new ArrayList<>();
				//if(sysAccountInfo.getUserType()==UserTypeEnum.GROUP.getValue()){
					hotels= hotelMapper.queryHotelByBrandId(brandDTO.getRowId());

				/*}else{*//*
					hotels=hotelMapper.getHotelByShare(brandDTO.getRowId());
				//}*/
				brandDTO.setHotels(hotels);
			});

		return  brandDTOList;
	}



	private List<ArticleDTO> getArticleDetail(String  contitle){
		return articleMapper.queryArticleByConditions(new Article(){{
			setConTitle(contitle);
			setActiveFlag(ActiveFlagEnum.VALID.getValue());
		}});
	}

}

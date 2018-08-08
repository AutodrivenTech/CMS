package com.huazhu.application.cms.article.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.account.entity.SysAccountInfo;
import com.huazhu.application.cms.article.dao.ArticleMapper;
import com.huazhu.application.cms.article.dto.ArticleDTO;
import com.huazhu.application.cms.article.dto.ArticleListDTO;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import com.huazhu.application.utils.enums.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huazhu.application.cms.article.dao.ArticleListMapper;
import com.huazhu.application.cms.article.entity.Article;
import com.huazhu.application.cms.article.entity.ArticleList;
import com.huazhu.application.cms.article.entity.ArticleListDetail;
import com.huazhu.application.cms.article.service.ArticleListService;

@Service
public class ArticleListServiceImpl implements ArticleListService {

    @Autowired
    private ArticleListMapper articleListMapper;

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public List<ArticleListDTO> queryArticleList(ArticleList articleList, SysAccountInfo accountInfo) {
        articleList.setActiveFlag(ActiveFlagEnum.VALID.getValue());
       /* if (accountInfo.getUserType() == UserTypeEnum.SUBSIDIARY.getValue()) {
            articleList.setConOrg(accountInfo.getUserOrg());
        }*/
        List<ArticleListDTO> articleListDTOS = articleListMapper.queryArticleList(articleList);
        articleListDTOS.forEach(articleListDTO -> {
            List<ArticleDTO> articles = articleMapper.getArticleInfoByListId(articleListDTO.getRowId(), ActiveFlagEnum.VALID.getValue(),null);
            articleListDTO.setArticleList(articles);
        });
        return articleListDTOS;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer insertArticleList(ArticleList articleList, String[] articleIds,Integer[] orderNums) {
        Integer result = articleListMapper.insertArticleList(articleList);
        if (result > 0) {
            for ( int i = 0; i < articleIds.length; i++ )
            {
                ArticleListDetail articleListDetail = new ArticleListDetail();
                articleListDetail.setConId(Long.valueOf(articleIds[i]));
                articleListDetail.setConListId(articleList.getRowId());
                articleListDetail.setCreateDate(DateUtil.getCurrentTime());
                articleListDetail.setOrderNum(orderNums[i]);
                articleListMapper.insertArticleListDetail(articleListDetail);
            }

        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer updateArticleListByRowId(ArticleList articleList, String[] articleIds,Integer[] orderNums) {
        articleList.setLastUpdateDate(DateUtil.getCurrentTime());
        Integer result = articleListMapper.updateArticleListByRowId(articleList);
        if (result > 0) {
            articleListMapper.deleteConlistDetail(articleList.getRowId());
            for ( int i = 0; i < articleIds.length; i++ )
            {
                ArticleListDetail articleListDetail = new ArticleListDetail();
                articleListDetail.setConId(Long.valueOf(articleIds[i]));
                articleListDetail.setConListId(articleList.getRowId());
                articleListDetail.setCreateDate(DateUtil.getCurrentTime());
                articleListDetail.setOrderNum(orderNums[i]);
                articleListMapper.insertArticleListDetail(articleListDetail);
            }


        }
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteArticleListByRowId(Long rowId, Integer userId) {
        Integer result = articleListMapper.updateArticleListByRowId(new ArticleList() {{
            setRowId(rowId);
            setActiveFlag(ActiveFlagEnum.DELETE.getValue());
            setLastUpdateDate(DateUtil.getCurrentTime());
          //  setLastUpdateUser(Long.valueOf(userId));
        }});
        if (result > 0) {
            articleListMapper.deleteConlistDetail(rowId);
        }
        return result;
    }

    @Override
    public ArticleListDTO getArticleListDetail(Integer rowId) {
        ArticleListDTO articleListDTO = articleListMapper.queryArticleListById(rowId);
        if (articleListDTO != null) {
            List<ArticleDTO> articles = articleMapper.getArticleInfoByListId(articleListDTO.getRowId(), ActiveFlagEnum.VALID.getValue(),null);
            articleListDTO.setArticleList(articles);
        }
        return articleListDTO;
    }



}

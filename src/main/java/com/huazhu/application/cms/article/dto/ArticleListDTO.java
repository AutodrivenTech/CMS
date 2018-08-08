package com.huazhu.application.cms.article.dto;

import com.huazhu.application.cms.article.entity.Article;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ArticleListDTO {

    @ApiModelProperty("Id")
    private Long rowId;

    @ApiModelProperty("标题")
    private String conTitle;

    @ApiModelProperty("文章集合")
   private List<ArticleDTO> articleList;

}

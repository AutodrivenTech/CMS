package com.huazhu.application.cms.fans.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("粉丝过滤器DTO")
@Data
public class FansFilterResultDTO {

    @ApiModelProperty("编号")
    private Integer rowId;

    @ApiModelProperty("名称")
    private  String name;

    @ApiModelProperty("粉丝人数")
    private Integer fansCount;

    @ApiModelProperty("群发限制")
    private String restrict;



}

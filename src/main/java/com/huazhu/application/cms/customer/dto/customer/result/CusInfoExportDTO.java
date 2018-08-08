package com.huazhu.application.cms.customer.dto.customer.result;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel("导出格式")
public class CusInfoExportDTO {

    @ExcelProperty(value = "编号" ,index = 0)
    private Long rowId;

    @ExcelProperty(value = "客户名" ,index = 1)
    private String cusName;

    @ExcelProperty(value = "酒店" ,index = 2)
    private String hotelName;

    @ExcelProperty(value = "性别" ,index = 3)
    private String cusSex;

    @ExcelProperty(value = "标签" ,index = 4)
    private String tagNames;

    @ExcelProperty(value = "签名" ,index =5)
    private String cusSign;

    @ExcelProperty(value = "头像" ,index = 6)
    private String cusPhoto;

    @ExcelProperty(value = "openId" ,index = 7)
    private String cusOpenId;

    @ExcelProperty(value = "关注时间" ,index = 8)
    private String followDate;

    @ExcelProperty(value = "国家" ,index = 9)
    private String country;

    @ExcelProperty(value = "省份" ,index = 10)
    private String province;

    @ExcelProperty(value = "城市" ,index = 11)
    private String city;

    @ExcelProperty(value = "语言" ,index = 12)
    private String language;

    @ExcelProperty(value = "调研年龄" ,index = 13)
    private String surveyAge;

    @ExcelProperty(value = "境外目的地" ,index = 14)
    private String abroadDestination;

    @ExcelProperty(value = "国内目的地" ,index = 15)
    private String domesticDestination;

    @ExcelProperty(value = "活动" ,index = 16)
    private String activity;


}

package com.huazhu.application.cms.article.dto;

import com.huazhu.application.cms.organization.entity.Hotel;
import lombok.Data;

import java.util.List;

@Data
public class BrandDTO {

    private Long rowId;

    private String chineseName;

    private List<Hotel> hotels;
}

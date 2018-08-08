package com.huazhu.application.cms.fans.dto;

import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.tags.entity.Tags;
import lombok.Data;

import java.util.List;

@Data
public class FansInfoDTO {

    private List<Hotel> hotelList;

    private List<Tags> tagsList;
}

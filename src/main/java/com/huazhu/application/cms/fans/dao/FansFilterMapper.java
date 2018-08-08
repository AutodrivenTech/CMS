package com.huazhu.application.cms.fans.dao;

import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import com.huazhu.application.cms.fans.dto.FansFilterResultDTO;
import com.huazhu.application.cms.fans.entity.FansFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FansFilterMapper {

    List<FansFilterResultDTO> getFansFilterList(@Param("name") String name, @Param("activeflag") Integer activeflag);

    Integer addFilterFansInfo(FansFilter fansFilter);


    Integer udpateFansInfo(FansFilter fansFilter);

    FansFilterDTO getFansFilterDetail(@Param("fansId") Integer fansId);


}

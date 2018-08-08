package com.huazhu.application.cms.activity.dao;
import com.huazhu.application.cms.activity.dto.ActivityDetailInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityDetailInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityDetailInfoMapper  {

    List<ActivityDetailInfoDTO> queryAll(@Param("actId")Integer actId,@Param("activeFlag")Integer activeFlag);

    Integer update(ActivityDetailInfo activityDetailInfo);

    Integer addActivity(ActivityDetailInfo activityDetailInfo);


    ActivityDetailInfoDTO queryById(@Param("rowId")Integer rowId);

    Integer updateDetail(ActivityDetailInfo activityDetailInfo);

    Integer updateActDetailCount(@Param("rowId")Integer rowId);

}

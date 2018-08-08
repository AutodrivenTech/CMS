package com.huazhu.application.cms.activity.service.impl;


import com.huazhu.application.cms.activity.dao.ActivityDetailInfoMapper;
import com.huazhu.application.cms.activity.dto.ActivityDetailInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityDetailInfo;
import com.huazhu.application.cms.activity.service.ActivityDetailInfoService;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityDetailInfoServiceImpl implements ActivityDetailInfoService {

    @Autowired
    private ActivityDetailInfoMapper activityDetailInfoMapper;

    @Override
    public Integer updateActDetail(ActivityDetailInfo activityDetailInfo) {
        activityDetailInfo.setLastUpdateDate(DateUtil.getCurrentTime());
        return activityDetailInfoMapper.update(activityDetailInfo);
    }

    @Override
    public Integer delete(Integer rowId,Integer userId) {
        return activityDetailInfoMapper.update(new ActivityDetailInfo(){{
            setRowId(rowId);
            setActiveFlag(ActiveFlagEnum.DELETE.getValue());
            setLastUpdateDate(DateUtil.getCurrentTime());
           // setLastUpdateUser(Long.valueOf(userId));
        }});
    }

    @Override
    public Integer addActDetail(ActivityDetailInfo activityDetailInfo) {
        activityDetailInfo.setCreateDate(DateUtil.getCurrentTime());
        activityDetailInfo.setActiveFlag(ActiveFlagEnum.VALID.getValue());
        return activityDetailInfoMapper.addActivity(activityDetailInfo);
    }

    @Override
    public ActivityDetailInfoDTO getActDetailById(Integer rowId) {
        return activityDetailInfoMapper.queryById(rowId);
    }

    @Override
    public Integer updateActDetailCount(Integer rowId) {
        return activityDetailInfoMapper.updateActDetailCount(rowId);
    }
}

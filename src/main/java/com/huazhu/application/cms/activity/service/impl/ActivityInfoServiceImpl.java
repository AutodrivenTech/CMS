package com.huazhu.application.cms.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.activity.dao.ActivityDetailInfoMapper;
import com.huazhu.application.cms.activity.dao.ActivityInfoMapper;
import com.huazhu.application.cms.activity.dto.ActivityDetailInfoDTO;
import com.huazhu.application.cms.activity.dto.ActivityInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityDetailInfo;
import com.huazhu.application.cms.activity.entity.ActivityInfo;
import com.huazhu.application.cms.activity.service.ActivityInfoService;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityInfoServiceImpl implements ActivityInfoService {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;

    @Autowired
    private ActivityDetailInfoMapper activityDetailInfoMapper;

    @Override
    public PageInfo<ActivityInfoDTO> getActivityList(ActivityInfo activityInfo, Integer pageNo, Integer pageSize) {
        activityInfo.setActiveFlag(ActiveFlagEnum.VALID.getValue());
        PageInfo<ActivityInfoDTO> pageInfo = PageHelper.startPage(pageNo, pageSize).doSelectPageInfo(() -> activityInfoMapper.queryAll(activityInfo));

        pageInfo.getList().forEach(activityInfoDTO -> {
            List<ActivityDetailInfoDTO> activityDetailInfoDTOS = activityDetailInfoMapper.queryAll(activityInfoDTO.getRowId(), ActiveFlagEnum.VALID.getValue());
            Integer count=activityDetailInfoDTOS.stream().mapToInt(ActivityDetailInfoDTO::getActDetailCount).sum();
            activityInfoDTO.setDetailInfoDTOList(activityDetailInfoDTOS);
            activityInfoDTO.setActDetailCount(count);//扫描次数
        });
        return pageInfo;
    }

    @Override
    public Integer updateAct(ActivityInfo activityInfo) {
        activityInfo.setLastUpdateDate(DateUtil.getCurrentTime());
        return activityInfoMapper.updateAct(activityInfo);
    }

    @Override
    public Integer addAct(ActivityInfo activityInfo) {
        activityInfo.setCreateDate(DateUtil.getCurrentTime());
        activityInfo.setActiveFlag(ActiveFlagEnum.VALID.getValue());
        return activityInfoMapper.addAct(activityInfo);
    }

    @Override
    public Integer delete(Integer rowId, Integer userId) {
        Integer result = activityInfoMapper.updateAct(new ActivityInfo() {{
            setRowId(rowId);
            setActiveFlag(ActiveFlagEnum.DELETE.getValue());
          //  setLastUpdateUser(Long.valueOf(userId));
            setLastUpdateDate(DateUtil.getCurrentTime());
        }});
        if (result > 0) {
            ActivityDetailInfo activityDetailInfo = new ActivityDetailInfo() {{
                setActiveFlag(ActiveFlagEnum.DELETE.getValue());
               // setLastUpdateUser(Long.valueOf(userId));
                setLastUpdateDate(DateUtil.getCurrentTime());
                setActId(rowId);
            }};
            activityDetailInfoMapper.updateDetail(activityDetailInfo);
        }
        return result;
    }

    @Override
    public ActivityInfoDTO getActivityById(Integer rowId) {
        ActivityInfoDTO activityInfoDTO= activityInfoMapper.queryActivityById(rowId);
        if(activityInfoDTO!=null){
            List<ActivityDetailInfoDTO> activityDetailInfoDTOS = activityDetailInfoMapper.queryAll(activityInfoDTO.getRowId(), ActiveFlagEnum.VALID.getValue());

            Integer count=activityDetailInfoDTOS.stream().mapToInt(ActivityDetailInfoDTO::getActDetailCount).sum();
            activityInfoDTO.setActDetailCount(count);//扫描次数
            activityInfoDTO.setDetailInfoDTOList(activityDetailInfoDTOS);
        }
        return activityInfoDTO;
    }
}

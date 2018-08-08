package com.huazhu.application.cms.fans.service;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import com.huazhu.application.cms.fans.dto.FansFilterResultDTO;
import com.huazhu.application.cms.fans.dto.FansInfoDTO;
import com.huazhu.application.cms.fans.entity.FansFilter;

import java.util.List;

public interface FansFilterService {

    /**
     * 查询列表
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<FansFilterResultDTO> getFansFilterList(String name, Integer pageNo, Integer pageSize);

    /**
     * 查询详情
     * @param fansId
     * @return
     */
    FansFilterDTO getFansFilterDetail(Integer fansId);


    /**
     * 修改粉丝过滤器信息
     * @param fansFilter
     * @return
     */
    Integer updateFansFilterInfo(FansFilter fansFilter);

    /**
     * 添加
     * @param fansFilter
     * @return
     */
    Integer addFansFilter(FansFilter fansFilter);

    /**
     * 删除
     * @param fansId
     * @return
     */
    Integer deleteFansFilter(Integer fansId,Integer userId);


    FansInfoDTO getHotelAndTagInfo();

    List<FansFilterResultDTO> getAllFilter();


}

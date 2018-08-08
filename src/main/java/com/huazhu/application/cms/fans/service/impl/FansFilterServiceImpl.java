package com.huazhu.application.cms.fans.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.customer.dao.CusInfoMapper;
import com.huazhu.application.cms.fans.dao.FansFilterMapper;
import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import com.huazhu.application.cms.fans.dto.FansFilterResultDTO;
import com.huazhu.application.cms.fans.dto.FansInfoDTO;
import com.huazhu.application.cms.fans.entity.FansFilter;
import com.huazhu.application.cms.fans.service.FansFilterService;
import com.huazhu.application.cms.organization.dao.HotelMapper;
import com.huazhu.application.cms.organization.entity.Hotel;
import com.huazhu.application.cms.tags.dao.TagsMapper;
import com.huazhu.application.cms.tags.entity.Tags;
import com.huazhu.application.utils.DateUtil;
import com.huazhu.application.utils.enums.ActiveFlagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FansFilterServiceImpl implements FansFilterService {

    @Autowired
    private FansFilterMapper fansFilterMapper;

    @Autowired
    private CusInfoMapper cusInfoMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public PageInfo<FansFilterResultDTO> getFansFilterList(String name, Integer pageNo, Integer pageSize) {
        PageInfo<FansFilterResultDTO> pageInfo = PageHelper.startPage(pageNo, pageSize)
                .doSelectPageInfo(() -> fansFilterMapper.getFansFilterList(name, ActiveFlagEnum.VALID.getValue()));
        pageInfo.getList().forEach(fansFilterResultDTO -> {
           // FansFilterDTO fansFilterDTO = fansFilterMapper.getFansFilterDetail(fansFilterResultDTO.getRowId());
          //  fansFilterResultDTO.setFansCount(cusInfoMapper.getCusInfoCount(fansFilterDTO));
        });
        return pageInfo;
    }

    @Override
    public FansFilterDTO getFansFilterDetail(Integer fansId) {
        FansFilterDTO fansFilterDTO = fansFilterMapper.getFansFilterDetail(fansId);
        if (fansFilterDTO != null) {
            List<Hotel> hotelList = hotelMapper.queryHotelById(fansFilterDTO.getHotelId(), ActiveFlagEnum.VALID.getValue());
            List<Tags> tagsList = tagsMapper.queryTagsById(fansFilterDTO.getTagId(), ActiveFlagEnum.VALID.getValue());
            fansFilterDTO.setHotels(hotelList);
            fansFilterDTO.setTags(tagsList);
        }
        return fansFilterDTO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer updateFansFilterInfo(FansFilter fansFilter) {
        fansFilter.setLastUpdateDate(DateUtil.getCurrentTime());
        return fansFilterMapper.udpateFansInfo(fansFilter);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer addFansFilter(FansFilter fansFilter) {
        fansFilter.setCreateDate(DateUtil.getCurrentTime());
        fansFilter.setActiveFlag(ActiveFlagEnum.VALID.getValue());
        return fansFilterMapper.addFilterFansInfo(fansFilter);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteFansFilter(Integer fansId,Integer userId) {
        return fansFilterMapper.udpateFansInfo(new FansFilter(){{
            setRowId(fansId);
            setLastUpdateUser(userId);
            setLastUpdateDate(DateUtil.getCurrentTime());
            setActiveFlag(ActiveFlagEnum.DELETE.getValue());
        }});
    }

    @Override
    public FansInfoDTO getHotelAndTagInfo() {
        List<Hotel> hotelList = hotelMapper.queryHotel(new Hotel() {{
            setActiveFlag(ActiveFlagEnum.VALID.getValue());
        }});
        List<Tags> tagsList = tagsMapper.queryTagsInfo(ActiveFlagEnum.VALID.getValue());
        return new FansInfoDTO() {{
            setHotelList(hotelList);
            setTagsList(tagsList);
        }};
    }

    @Override
    public List<FansFilterResultDTO> getAllFilter() {

        return fansFilterMapper.getFansFilterList(null, ActiveFlagEnum.VALID.getValue());
    }




}

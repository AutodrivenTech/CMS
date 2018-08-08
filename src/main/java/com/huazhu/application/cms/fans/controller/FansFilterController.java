package com.huazhu.application.cms.fans.controller;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.common.BasicController;
import com.huazhu.application.cms.customer.dto.customer.result.CusTagInfoDTO;
import com.huazhu.application.cms.customer.service.CusInfoService;
import com.huazhu.application.cms.fans.dto.FansFilterDTO;
import com.huazhu.application.cms.fans.dto.FansFilterResultDTO;
import com.huazhu.application.cms.fans.dto.FansInfoDTO;
import com.huazhu.application.cms.fans.entity.FansFilter;
import com.huazhu.application.cms.fans.service.FansFilterService;
import com.huazhu.application.common.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "粉丝过滤器")
@RequestMapping("/cms/fansFilter")
@RestController
public class FansFilterController extends BasicController {

    @Autowired
    private FansFilterService fansFilterService;

    @Autowired
    private CusInfoService cusInfoService;

    @ApiOperation(value = "添加分期过滤器")
    @PostMapping("/addFansFilter")
    public Map<String,Object> addFansFilter(FansFilter fansFilter){
        Map<String,Object> map=new HashMap<>();
        if(fansFilter==null){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return  map;
        }
        fansFilter.setCreateUser(getUserId());
        if(fansFilterService.addFansFilter(fansFilter)<=0){
            map.put(Constant.RETURN_CODE, Constant.FANS_ERROR_CODE);
            map.put(Constant.RETURN_MSG, Constant.FANS_ERROR_MSG);
        }else{
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }
        return  map;
    }

    @ApiOperation(value = "过滤器列表")
    @GetMapping("/getFansFilterList")
    public Map<String,Object> getFansFilterList(String  name,Integer pageNo,Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        if(pageNo!=null && pageSize!=null){
            PageInfo<FansFilterResultDTO> pageInfo=fansFilterService.getFansFilterList(name,pageNo,pageSize);
            map.put(Constant.RETURN_DATA,pageInfo);
        }else{
            List<FansFilterResultDTO> fansFilterResultDTOS=fansFilterService.getAllFilter();
            map.put(Constant.RETURN_DATA,fansFilterResultDTOS);
        }
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        return  map;
    }

    @ApiOperation(value = "修改过滤器")
    @PostMapping("/updateFansFilter")
    public Map<String,Object> updateFansFilter(FansFilter fansFilter){
        Map<String,Object> map=new HashMap<>();
        if(fansFilter!=null){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return  map;
        }
        fansFilter.setLastUpdateUser(getUserId());
        if(fansFilterService.updateFansFilterInfo(fansFilter)<=0){
            map.put(Constant.RETURN_CODE, Constant.FANS_ERROR_CODE);
            map.put(Constant.RETURN_MSG, Constant.FANS_ERROR_MSG);
        }else{
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }
        return  map;
    }

    @ApiOperation(value = "删除过滤器")
    @PostMapping("/deleteFansFilter")
    public Map<String,Object> deleteFansFilter(Integer fansFilterId){
        Map<String,Object> map=new HashMap<>();
        if(fansFilterId!=null || fansFilterId<=0){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return  map;
        }
        if(fansFilterService.deleteFansFilter(fansFilterId,getUserId())<=0){
            map.put(Constant.RETURN_CODE, Constant.FANS_ERROR_CODE);
            map.put(Constant.RETURN_MSG, Constant.FANS_ERROR_MSG);
        }else{
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }
        return  map;
    }

    @ApiOperation(value = "查询详情")
    @GetMapping("/getFansFilterDetail")
    public Map<String,Object> getFansFilterDetail(Integer fansFilterId){
        Map<String,Object> map=new HashMap<>();
        if(fansFilterId==null || fansFilterId<=0){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return  map;
        }
        FansFilterDTO fansFilterDTO=fansFilterService.getFansFilterDetail(fansFilterId);
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        map.put(Constant.RETURN_DATA,fansFilterDTO);
        return  map;
    }

    @ApiOperation(value = "过滤器下拉框信息")
    @PostMapping("/getFansFilteInfo")
    public Map<String,Object> getFansFilteInfo(){
        Map<String,Object> map=new HashMap<>();
        FansInfoDTO fansInfoDTO=fansFilterService.getHotelAndTagInfo();
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        map.put(Constant.RETURN_DATA,fansInfoDTO);
        return  map;
    }

    @ApiOperation(value = "查询用户标签")
    @GetMapping("/getCusTagInfo")
    public Map<String,Object> getCusTagInfo(){
        Map<String,Object> map=new HashMap<>();
        List<CusTagInfoDTO> tagInfoDTOList=cusInfoService.getCusTagInfoList();
        map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        map.put(Constant.RETURN_DATA,tagInfoDTOList);
        return  map;
    }

}

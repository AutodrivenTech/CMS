package com.huazhu.application.cms.activity.controller;

import com.github.pagehelper.PageInfo;
import com.huazhu.application.cms.activity.dto.ActivityInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityInfo;
import com.huazhu.application.cms.activity.service.ActivityInfoService;
import com.huazhu.application.cms.common.BasicController;
import com.huazhu.application.common.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(value = "活动")
@RequestMapping("/cms/activity")
@RestController
public class ActivityController extends BasicController {

    @Autowired
    private ActivityInfoService activityInfoService;

    @ApiOperation(value = "活动列表")
    @GetMapping("/getActivityList")
    public Map<String,Object> getActivityList(ActivityInfo activityInfo,Integer pageNo,Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        PageInfo<ActivityInfoDTO> pageInfo=activityInfoService.getActivityList(activityInfo,pageNo,pageSize);
        map.put(Constant.RETURN_CODE,Constant.SUCCESS_CODE);
        map.put(Constant.RETURN_MSG,Constant.SUCCESS_CONTENT);
        map.put(Constant.RETURN_CODE,pageInfo);
        return map;
    }


    @ApiOperation(value = "新增活动" , notes = "新增活动")
    @PostMapping("/addActivity")
    public Map<String,Object> addActivity(ActivityInfo activityInfo){
        Map<String,Object> map = new HashMap<String,Object>();
        if(activityInfo != null) {
            //activityInfo.setCreateUser(Long.valueOf(getUserId()));
            if(activityInfoService.addAct(activityInfo)>0) {
                map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
                map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
            }else {
                map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
                map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
            }
        }else {
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
        }
        return map;
    }


    @ApiOperation(value = "修改活动" , notes = "修改活动")
    @PostMapping("/eidtActivity")
    public Map<String,Object> eidtActivity(ActivityInfo activityInfo){
        Map<String,Object> map = new HashMap<String,Object>();
        if(activityInfo != null) {
           // activityInfo.setLastUpdateUser(Long.valueOf(getUserId()));
            if(activityInfoService.updateAct(activityInfo) >0) {
                map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
                map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
            }else {
                map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
                map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
            }
        }else {
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
        }
        return map;
    }

    @ApiOperation(value = "预览活动" , notes = "预览活动")
    @RequestMapping("/previewActivity")
    public Map<String,Object> previewActivity(Integer rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(rowId != null || rowId<=0) {
            ActivityInfoDTO activityInfo=activityInfoService.getActivityById(rowId);
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
            map.put(Constant.RETURN_DATA, activityInfo);
        }else {
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
        }
        return map;
    }


    @ApiOperation(value = "删除")
    @PostMapping("/deleteActivity")
    public Map<String,Object> deleteActivity(Integer rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(rowId==null || rowId<=0){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return map;
        }
        if(activityInfoService.delete(rowId,null)<=0){
            map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
            map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
        }else{
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }
        return map;
    }


}

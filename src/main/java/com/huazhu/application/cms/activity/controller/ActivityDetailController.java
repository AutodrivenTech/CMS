package com.huazhu.application.cms.activity.controller;

import com.huazhu.application.cms.activity.dto.ActivityDetailInfoDTO;
import com.huazhu.application.cms.activity.entity.ActivityDetailInfo;
import com.huazhu.application.cms.activity.service.ActivityDetailInfoService;
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

@Api(value = "活动详情")
@RequestMapping(value = "/cms/activityDetail")
@RestController
public class ActivityDetailController extends BasicController {

    @Autowired
    private ActivityDetailInfoService detailInfoService;



    @ApiOperation(value = "新增活动详情" , notes = "新增活动详情")
    @PostMapping("/addActivityDetail")
    public Map<String,Object> addActivityDetail(ActivityDetailInfo activityDetailInfo){
        Map<String,Object> map = new HashMap<>();
        if(activityDetailInfo != null) {
          //  activityDetailInfo.setCreateUser(Long.valueOf(getUserId()));
            if(detailInfoService.addActDetail(activityDetailInfo)>0) {
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


    @ApiOperation(value = "修改活动详情" , notes = "修改活动详情")
    @PostMapping("/eidtActivityDetail")
    public Map<String,Object> eidtActivityDetail(ActivityDetailInfo activityDetailInfo){
        Map<String,Object> map = new HashMap<String,Object>();
        if(activityDetailInfo != null) {
         //   activityDetailInfo.setLastUpdateUser(Long.valueOf(getUserId()));
            if(detailInfoService.updateActDetail(activityDetailInfo) >0) {
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

    @ApiOperation(value = "查看详情" , notes = "查看详情")
    @GetMapping("/previewActivityDetail")
    public Map<String,Object> previewActivityDetail(Integer rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(rowId != null || rowId<=0) {
            ActivityDetailInfoDTO activityInfo=detailInfoService.getActDetailById(rowId);
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
    @PostMapping("/deleteActivityDetail")
    public Map<String,Object> deleteActivity(Integer rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(rowId==null || rowId<=0){
            map.put(Constant.RETURN_CODE, Constant.PARAM_NULL_CODE);
            map.put(Constant.RETURN_MSG, Constant.PARAM_NULL_CONTENT);
            return map;
        }
        if(detailInfoService.delete(rowId,null)<=0){
            map.put(Constant.RETURN_CODE, Constant.FAILURE_CODE);
            map.put(Constant.RETURN_MSG, Constant.FAILURE_CONTENT);
        }else{
            map.put(Constant.RETURN_CODE, Constant.SUCCESS_CODE);
            map.put(Constant.RETURN_MSG, Constant.SUCCESS_CONTENT);
        }
        return map;
    }


    @ApiOperation(value = "生成二维码")
    @PostMapping("/buildQrCode")
    public Map<String,Object> buildQrCode(Integer rowId){
        Map<String,Object> map = new HashMap<String,Object>();

        return map;
    }


}

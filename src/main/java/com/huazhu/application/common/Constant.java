package com.huazhu.application.common;

public interface Constant {
    public static final String RETURN_CODE = "code";

    public static final String RETURN_MSG = "msg";

    public static final String RETURN_DATA = "data";

    //成功编码
    public static final String SUCCESS_CODE = "0";
    //成功信息
    public static final String SUCCESS_CONTENT = "成功";

    //失败编码
    public static final String FAILURE_CODE = "1";
    //失败信息
    public static final String FAILURE_CONTENT = "失败";

    //参数为空编码
    public static final String PARAM_NULL_CODE = "20107";
    //参数为空描述
    public static final String PARAM_NULL_CONTENT = "参数为空";

    //无数据code
    public static final String NO_DATA_CODE = "201809";
    //无数据msg
    public static final String NO_DATA_MSG = "无数据";

    //微信接口每次最多拉取10000个关注者的OpenID
    public static final int WX_LIMIT_COUNT = 10000;

    //分页跨度
    public static final String PAGE_SIZE = "20";
    //分页跨度前端参数名称
    public static final String PAGE_SIZE_NAME = "pageSize";

    //密码是否一致
    public static final String PASSWORD_CODE = "201810";

    public static final String PASSWORD_MSG = "两次输入的密码不一致";

    public static final String PASSWORD_RESET_CODE = "201811";

    public static final String PASSWORD_RESET_MSG = "修改密码失败";

    public static final String ACCOUNT_NO_EXIST_CODE = "201812";

    public static final String ACCOUNT_NO_EXIST_MSG = "用户不存在";

    public static final String PASSWORD_ERROR_CODE = "201813";

    public static final String PASSWORD_ERROR_MSG = "用户名或者密码错误";

    public static final String FANS_ERROR_CODE = "201815";

    public static final String FANS_ERROR_MSG = "粉丝过滤器操作失败";

    public static final String TAG_ERROR_CODE = "201816";

    public static final String TAG_ERROR_MSG = "标签名称已存在";

    public static final String MATE_ERROR_CODE = "201817";

    public static final String MATE_ERROR_MSG = "已被使用,不能删除";

    public static final String ARTICLE_ERROR_CODE = "201818";

    public static final String ARTICLE_ERROR_MSG = "文章标题已存在";

    //存在下级目录
    public static final String EXIST_CHILDREN_CODE = "2000";
    public static final String EXIST_CHILDREN_MSG = "存在子级目录";
    
    //有效标志
    public static final int ACTIVE_FLAG = 10;







}

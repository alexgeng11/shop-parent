package com.kaysen.shop.base;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Classname ApiResponse
 * @Description TODO
 * @Date 2019/8/21 13:36
 * @Created by ks.xu
 */
public class ApiResponse implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    private Boolean flag;

    @SuppressWarnings("unused")
    private ApiResponse() {
        super();
    }

    public ApiResponse(ResponseEnum responseEnum,String msg, Object data) {
        super();
        this.msg = msg;
        this.data = data;
        this.flag = responseEnum.flag;
        this.code = responseEnum.code;
    }
    public ApiResponse(ResponseEnum responseEnum,String msg) {
        super();
        this.msg = msg;
        this.flag = responseEnum.flag;
        this.code = responseEnum.code;
    }
    public ApiResponse(ResponseEnum responseEnum, Object data) {
        super();
        this.data = data;
        this.flag = responseEnum.flag;
        this.code = responseEnum.code;
        this.msg = responseEnum.msg;
    }
    public ApiResponse(ResponseEnum responseEnum) {
        super();
        this.flag = responseEnum.flag;
        this.code = responseEnum.code;
        this.msg = responseEnum.msg;
    }
    public ApiResponse(Integer code,Object data,String msg,Boolean flag) {
        super();
        this.flag = flag;
        this.code =code;
        this.msg = msg;
        this.data=data;
    }

    public static ApiResponse success(){
        return new ApiResponse(200,new HashMap<>(),"操作成功",true);
    }
    public static ApiResponse success(Object data){
        return new ApiResponse(200,data,"操作成功",true);
    }
    public static ApiResponse success(String msg){
        return new ApiResponse(200,new HashMap<>(),msg,true);
    }
    public static ApiResponse success(Object data,String msg){
        return new ApiResponse(200,data,msg,true);
    }

    public static ApiResponse error(Object data,String msg){
        return new ApiResponse(200,data,msg,false);
    }
    public static ApiResponse error(Integer code,Object data,String msg){
        return new ApiResponse(code,data,msg,false);
    }
    public static ApiResponse paramsError(Object data,String msg){
        return new ApiResponse(400,data,msg,false);
    }
    public static ApiResponse paramsError(String msg){
        return new ApiResponse(400,null,msg,false);
    }
    public static ApiResponse exception(){
        return new ApiResponse(500,new HashMap<>(),"系统异常",false);

    }



    /**
     * 相应枚举类
     * @author Frank.Hou  作品
     * @DATE   2017年2月15日
     */
    public static enum ResponseEnum {
        ERROR(404,"操作失败",false),SUCCESS(200,"操作成功",true),EXCEPTION(500,"服务器繁忙",false);

        private Integer code;
        private String msg;
        private Boolean flag;
        public Integer getCode() {
            return code;
        }
        public void setCode(Integer code) {
            this.code = code;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public Boolean getFlag() {
            return flag;
        }
        public void setFlag(Boolean flag) {
            this.flag = flag;
        }
        private ResponseEnum(Integer code, String msg, Boolean flag) {
            this.code = code;
            this.msg = msg;
            this.flag = flag;
        }
        private ResponseEnum() {
        }

    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}

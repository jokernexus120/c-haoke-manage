package com.c.haoke.dubbo.server.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WebResult {

    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private String msg;
    @JsonIgnore
    private List<?> list;

    @JsonIgnore
    public static WebResult ok(List<?> list) {
        return new WebResult(200, "成功!", list);
    }

    @JsonIgnore
    public static WebResult ok(List<?> list, String msg) {
        return new WebResult(200, msg, list);
    }

    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("list", this.list);
        return map;
    }

    public Map<String, Object> getMeta() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("msg", msg);
        return map;
    }

    public WebResult() {
    }

    public WebResult(Integer status, String msg, List<?> list) {
        this.status = status;
        this.msg = msg;
        this.list = list;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "WebResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                '}';
    }
}

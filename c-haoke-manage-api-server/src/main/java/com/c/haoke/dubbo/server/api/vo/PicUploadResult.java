package com.c.haoke.dubbo.server.api.vo;

import java.io.Serializable;
import java.util.Date;

public class PicUploadResult implements Serializable {

    // 文件唯一标识
    private String uid;
    // 文件名
    private String name;
    // 状态有：uploading done error removed
    private String status;
    // 服务端响应内容，如：'{"status": "success"}'
    private String response;

    private Date uploadTime;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "PicUploadResult{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", response='" + response + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}

package com.c.haoke.dubbo.server.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("tb_ad")
public class Ad extends BasePojo {

    private static final long serialVersionUID = -493439243433085768L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //广告类型
    private Integer type;

    //描述
    private String title;

    //'图片URL地址
    private String url;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

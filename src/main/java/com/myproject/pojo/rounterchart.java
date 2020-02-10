package com.myproject.pojo;

import java.util.Date;

import com.myproject.entiy.BaseEntity;

public class rounterchart extends BaseEntity{
    private String rounterchartid;

    private String rounterchart;

    private String image;

    private Integer width;

    private Integer height;

    private String introduce;

    private String url;

    private Boolean isshow;

    private String remark;

    public String getRounterchartid() {
        return rounterchartid;
    }

    public void setRounterchartid(String rounterchartid) {
        this.rounterchartid = rounterchartid == null ? null : rounterchartid.trim();
    }

    public String getRounterchart() {
        return rounterchart;
    }

    public void setRounterchart(String rounterchart) {
        this.rounterchart = rounterchart == null ? null : rounterchart.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Boolean getIsshow() {
        return isshow;
    }

    public void setIsshow(Boolean isshow) {
        this.isshow = isshow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
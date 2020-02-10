package com.myproject.pojo;

import java.util.Date;

import com.myproject.entiy.BaseEntity;

public class options extends BaseEntity{
    private String optionsid;

    private String optionscontent;

    private String questionid;

    private Integer site;

    private String type;

    public String getOptionsid() {
        return optionsid;
    }

    public void setOptionsid(String optionsid) {
        this.optionsid = optionsid == null ? null : optionsid.trim();
    }

    public String getOptionscontent() {
        return optionscontent;
    }

    public void setOptionscontent(String optionscontent) {
        this.optionscontent = optionscontent == null ? null : optionscontent.trim();
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

}
package com.myproject.pojo;

import java.util.Date;

import com.myproject.entiy.BaseEntity;

public class answer extends BaseEntity{
    private String answerid;

    private String userid;

    private String optionsid;

    private String questionnairenumber;

    private String value;

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid == null ? null : answerid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOptionsid() {
        return optionsid;
    }

    public void setOptionsid(String optionsid) {
        this.optionsid = optionsid == null ? null : optionsid.trim();
    }

    public String getQuestionnairenumber() {
        return questionnairenumber;
    }

    public void setQuestionnairenumber(String questionnairenumber) {
        this.questionnairenumber = questionnairenumber == null ? null : questionnairenumber.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

}
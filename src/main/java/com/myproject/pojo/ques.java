package com.myproject.pojo;

import java.util.Date;
import java.util.List;

import com.myproject.entiy.BaseEntity;

public class ques extends BaseEntity{
    private String quesid;

    private String questionid;

    private String content;

    private String type;

    private Integer site;

    private String naireid;
    
    private List<options> options;

    public List<options> getOptions() {
		return options;
	}

	public void setOptions(List<options> options) {
		this.options = options;
	}

	public String getQuesid() {
        return quesid;
    }

    public void setQuesid(String quesid) {
        this.quesid = quesid == null ? null : quesid.trim();
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    public String getNaireid() {
        return naireid;
    }

    public void setNaireid(String naireid) {
        this.naireid = naireid == null ? null : naireid.trim();
    }
}
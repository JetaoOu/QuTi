package com.myproject.pojo;

import java.util.Date;
import java.util.List;

import com.myproject.entiy.BaseEntity;

public class question extends BaseEntity{
    private String questionid;

    private String content;

    private String digest;

    private String type;

    private Integer site;

    private String naireid;
    
    private List<ques> quess;
    
    private List<options> options;


    public List<options> getOptions() {
		return options;
	}

	public void setOptions(List<options> options) {
		this.options = options;
	}

	public List<ques> getQuess() {
		return quess;
	}

	public void setQuess(List<ques> quess) {
		this.quess = quess;
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

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
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
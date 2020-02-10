package com.myproject.entiy;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

	/**
	 * 基本实体，所有其他实体继承这实体
	 */
	private static final long serialVersionUID = 6096050328780487334L;

	private Date savetime;

    private Date changetime;

	public Date getSavetime() {
		return savetime;
	}

	public void setSavetime(Date savetime) {
		this.savetime = savetime;
	}

	public Date getChangetime() {
		return changetime;
	}

	public void setChangetime(Date changetime) {
		this.changetime = changetime;
	}
    
    
}

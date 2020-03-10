package com.myproject.entiy;

import java.util.ArrayList;
import java.util.HashMap;

public class DataDownLoad {
	
	private String title;
	private String degest;
	private String end;
	private ArrayList<HashMap> rowlist;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDegest() {
		return degest;
	}
	public void setDegest(String degest) {
		this.degest = degest;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public ArrayList<HashMap> getRowlist() {
		return rowlist;
	}
	public void setRowlist(ArrayList<HashMap> rowlist) {
		this.rowlist = rowlist;
	}


}

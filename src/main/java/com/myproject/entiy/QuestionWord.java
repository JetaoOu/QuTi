package com.myproject.entiy;

import java.util.List;

public class QuestionWord {
	
	
	
	public QuestionWord(String content, List<String> percent, String avg) {
		super();
		Content = content;
		this.percent = percent;
		this.avg = avg;
	}

	private String Content;
	
	private List<String> percent;
	
	private String avg;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public List<String> getPercent() {
		return percent;
	}

	public void setPercent(List<String> percent) {
		this.percent = percent;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
	
	

}

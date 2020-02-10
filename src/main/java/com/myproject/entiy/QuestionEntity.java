package com.myproject.entiy;

import java.util.List;

import com.myproject.pojo.question;
import com.myproject.pojo.options;

public class QuestionEntity {
	
	private question question;
	
	private List<options> optionsList;


	public question getQuestion() {
		return question;
	}

	public void setQuestion(question question) {
		this.question = question;
	}

	public List<options> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<options> optionsList) {
		this.optionsList = optionsList;
	}
}

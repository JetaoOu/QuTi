package com.myproject.entiy;

import java.util.List;

import com.myproject.pojo.question;
import com.myproject.pojo.questionnaire;

public class quData extends questionnaire{
	private List<question> questions;

	public List<question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<question> questions) {
		this.questions = questions;
	}
	

}

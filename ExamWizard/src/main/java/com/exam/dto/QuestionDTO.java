package com.exam.dto;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionDTO {
	public int qid;
	public String qtext;

	public ArrayList<OptionDTO> options = new ArrayList<>();
	
	public void setQuestion(int qid, String qtext) {
		this.qid=qid;
		this.qtext=qtext;
	}
	
	public void addOption(int oid, String otext) {
		OptionDTO q = new OptionDTO(oid,otext);
		options.add(q);
		this.permutate();
	}
	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQtext() {
		return qtext;
	}

	public void setQtext(String qtext) {
		this.qtext = qtext;
	}

	public ArrayList<OptionDTO> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<OptionDTO> options) {
		this.options = options;
	}

	public void permutate() {
		Collections.shuffle(options);  
	}

	@Override
	public String toString() {
		return "QuestionDTO [qid=" + qid + ", qtext=" + qtext + ", options=" + options + "]";
	}	
}

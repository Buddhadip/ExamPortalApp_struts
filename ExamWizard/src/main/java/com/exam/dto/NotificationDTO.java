package com.exam.dto;

import java.sql.SQLException;

import com.exam.dao.ExamDAO;
import com.exam.dao.UserDAO;
import com.exam.form.ExamForm;
import com.exam.form.ResultForm;
import com.exam.form.SignupForm;

public class NotificationDTO {
	private int nid;
	private String uname;
	private String uroll;
	private String uemail;
	private String ename;
	private String submission;
	private int total;
	private int score;
	
	public NotificationDTO(int nid,ResultDTO r)  {
		this.nid=nid;
		this.uname = r.getUname();
		this.uroll=r.getUroll();
		this.uemail=r.getUemail();
		this.ename=r.getEname();
		this.total=r.getTotal();
		this.score=r.getScore();
		this.submission=r.getSubmission();
	}
	
	
	public int getNid() {
		return nid;
	}


	public void setNid(int nid) {
		this.nid = nid;
	}


	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUroll() {
		return uroll;
	}
	public void setUroll(String uroll) {
		this.uroll = uroll;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSubmission() {
		return submission;
	}
	public void setSubmission(String submission) {
		this.submission = submission;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}


	public String toString() {
		return "ResultDTO [uname=" + uname + ", ename=" + ename + ", total=" + total + ", score=" + score + "]";
	}
}

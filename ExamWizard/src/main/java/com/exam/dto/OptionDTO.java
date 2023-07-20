package com.exam.dto;

public class OptionDTO {
	private int oid;
	private String otext;
	
	public OptionDTO(int oid, String otext) {
		this.oid=oid;
		this.otext=otext;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOtext() {
		return otext;
	}
	public void setOtext(String otext) {
		this.otext = otext;
	}
	@Override
	public String toString() {
		return "OptionDTO [oid=" + oid + ", otext=" + otext + "]";
	}
	
}

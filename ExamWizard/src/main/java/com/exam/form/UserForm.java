package com.exam.form;

public class UserForm {
		private String name;
		private String roll;
		private String email;
		public UserForm() {
		}
		
		public UserForm(String name, String roll, String email) {
			this.name=name;
			this.email=email;
			this.roll=roll;
		}
		@Override
		 public String toString() {
		        return "User [ Name = "+this.name+" , Roll = "+this.roll+" , Email = "+this.email+" ]";
		  }
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRoll() {
			return roll;
		}
		public void setRoll(String roll) {
			this.roll = roll;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}

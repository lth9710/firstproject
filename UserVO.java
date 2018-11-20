package com.project1;

import java.io.Serializable;



public class UserVO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public String userId;
	private String id;
	private String name;
	private String gender;
	private String email;
	private String pw;
	private String birth;
	private String tel;

	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String toString(){
		
		return "  아이디:"+id +" 이름:"+ name+" 성별:" + gender+" 전화번호:" + tel+" 이메일:" +email ; 
		
	}



/*//public String userId;
	private String id;
	private String name;
	private String gender;
	private String email;
	private String pw;
	private String birth;
	private String tel;*/
	
	
}

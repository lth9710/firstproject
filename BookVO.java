package com.project1;

import java.io.Serializable;

public class BookVO implements Serializable{

	public String userId;
	private int id;
	private String name;
	private String author;
	private boolean rental;
	
	@Override
	public String toString() {
		String daeyu = "";
		
		if(rental){
			daeyu="대여중";
		}else{
			daeyu="대여가능";
		}
		if(userId==null){
			userId="";
		}
		
		return  "  도서번호 :"+ id + " 책이름:" +name + " 저자:"+author+" 대여여부:"+ daeyu +"  "+userId;
	
	}

	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isRental() {
		return rental;
	}

	public void setRental(boolean rental) {
		this.rental = rental;
	}
	
	
	
}

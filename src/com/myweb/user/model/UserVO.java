package com.myweb.user.model;

import java.sql.Timestamp;

public class UserVO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private Timestamp regdate;
	
	
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public UserVO(String id, String pw, String name, String email, String address, Timestamp regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.regdate = regdate;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}


	//toString 오버라이딩 -- 필드값을 빠르게 확인 가능
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", regdate=" + regdate + "]";
	}
	

	
	

}

package com.myweb.board.model;

import java.sql.Timestamp;

public class BoardVO {
	//테이블명과 동일하게 선언합니다
	private int bno;
	private String writer;
	private String title;
	private String content;
	private Timestamp ragdate;
	private int hit;
	
	//생성자
	public BoardVO() {
		
	}


	public BoardVO(int bno, String writer, String title, String content, Timestamp ragdate, int hit) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.ragdate = ragdate;
		this.hit = hit;
	}


	//getter setter
	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getRagdate() {
		return ragdate;
	}


	public void setRagdate(Timestamp ragdate) {
		this.ragdate = ragdate;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
	
	
	
}

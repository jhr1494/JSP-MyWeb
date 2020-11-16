package com.myweb.util;

public class PageVO {
	
	//화면에 그려질 pageNation을 계산하는 클래스(pageNum와 정체게시글 수, amount를 가지고 다님
	private int startPage; //게시글 화면에 보여질 첫번째 번호
	private int endPage; //게시글 화면에 보여질 마지막 번호
	private boolean prev, next; //다음, 이전버튼 활성화 여부
	
	private int pageNum = 1; //조회하고 있는 페이지번호
	private int amount = 10; //화면(페이지당)에 보여질 데이터 개수
	private int total; //전체 게시글 수

	//생성자 생성시 계산처리
	public PageVO(int pageNum, int amount, int total) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.total = total;
		
		//1. endPager계산
		//현재 페이지 번호가 1~10이다 -> 화면에 보여질 끝번호 10
		//현재 페이지 번호가 14이다 -> 화면에 보여질 끝번호 20
		//공식 Math.ceil(페이지번호 / 화면에 보여질 페이지 수) X 화면에 보여질 페이지 수
		this.endPage = (int)Math.ceil(this.pageNum/(double)10) * 10;
		
		//2. startPage계산
		//공식 : 끝페이지 - 화면에 보여질 페이지 수 + 1
		this.startPage = this.endPage - 10 + 1;
		
		//3. readEnd 실제 끝번호
		//총 게시글이 52개라면 -> 페이지번호는 6번까지
		//총 게시글이 105개라면 -> 페이지번호는 11번까지
		//공식 : (int)Math.ceil( 전체글개수 / 페이지당 보여지는 데이터의 개수)
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		//마지막 페이지 도달시에 보여져야하는 끝번호가 달라집니다
		/*
		 * ex) total : 131개 개시물
		 * 1번페이지 클릭시 -> endPage = 10, realEnd = 14(endPage로 세팅)
		 * 11번 페이지 클릭시 -> endPage = 20, realEnd = 14(realEnd로 세팅)
		 * 결론 endPage > realEnd -> realEnd를 보여주면 됩니다
		 */
		if(endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		
		//4.이전버튼 활성화 여부
		//startPage점핑값 -> 1, 11, 21, 31....형태로 표기
		this.prev = this.startPage > 1;
		
		//5. 다음버튼 활성화 여부
		//위 realEnd와 endPage서로 연관이 있는데,
		/*
		 * ex)total = 131개 개시물
		 * 1~10번 페이지 조회시 -- endPage = 10, realEnd = 14 --> 다음버튼 활성화 true
		 * 11번 페이지 조회시 endPage = 14, realEnd = 14 -> 다음버튼 활성화 false
		 */
		this.next = realEnd > this.endPage;
		
		//확인
		System.out.println("시작페이지 : " + this.startPage + ", 끝페이지 : " + this.endPage);
		
	}

	
	
	
	
	//getter setter
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
	
}

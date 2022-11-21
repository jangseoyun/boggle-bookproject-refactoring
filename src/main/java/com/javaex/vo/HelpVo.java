package com.javaex.vo;

public class HelpVo {
	
	private int no;
	private String title;
	private String content;
	private String regDate;
	private int userNo;
	private String userName;
	
	
	
	public HelpVo() {
	
	}
	
	
	public HelpVo(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	
	
	public HelpVo(int no, String title, String content) {
		this.no = no;
		this.title = title;
		this.content = content;
	}


	public HelpVo(int no, String title, String content, String regDate, int userNo, String userName) {

		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}
	
	
	public HelpVo(int no, String title, String content, int userNo) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.userNo = userNo;
	}
	
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@Override
	public String toString() {
		return "HelpVo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", userNo=" + userNo + ", userName=" + userName + "]";
	}

	
	
	
	
	
	
}

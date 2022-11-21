package com.javaex.vo;

public class ReviewVo {
	
	private int reviewNo;
	private int userNo;
	private long bookNo;
	private int styleNo;
	private String reviewContent;
	private String reviewDate;
	private String emoName;
	
	
	public ReviewVo() {}


	public ReviewVo(int reviewNo, int userNo, long bookNo, int styleNo, String reviewContent, String reviewDate,
			String emoName) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.styleNo = styleNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.emoName = emoName;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public long getBookNo() {
		return bookNo;
	}


	public void setBookNo(long bookNo) {
		this.bookNo = bookNo;
	}


	public int getStyleNo() {
		return styleNo;
	}


	public void setStyleNo(int styleNo) {
		this.styleNo = styleNo;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public String getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}


	public String getEmoName() {
		return emoName;
	}


	public void setEmoName(String emoName) {
		this.emoName = emoName;
	}


	@Override
	public String toString() {
		return "ReviewVo [reviewNo=" + reviewNo + ", userNo=" + userNo + ", bookNo=" + bookNo + ", styleNo=" + styleNo
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", emoName=" + emoName + "]";
	}
	
	

}

package com.javaex.vo;

public class BookreviewVo {
	
	//필드
	private String bookTitle;
    private String bookNo;
   
    private String reviewContent;
    private int reviewLikeCount;
    private String reviewDate;
   
    private String emoName;
   
    private String nickName;

	//생성자
    public BookreviewVo() {}
    
	public BookreviewVo(String bookTitle, String bookNo, String reviewContent, int reviewLikeCount, String reviewDate,
			String emoName, String nickName) {
		super();
		this.bookTitle = bookTitle;
		this.bookNo = bookNo;
		this.reviewContent = reviewContent;
		this.reviewLikeCount = reviewLikeCount;
		this.reviewDate = reviewDate;
		this.emoName = emoName;
		this.nickName = nickName;
	}

	//메소드 g,s
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewLikeCount() {
		return reviewLikeCount;
	}

	public void setReviewLikeCount(int reviewLikeCount) {
		this.reviewLikeCount = reviewLikeCount;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
	//메소드 일반
	@Override
	public String toString() {
		return "ReviewVo [bookTitle=" + bookTitle + ", bookNo=" + bookNo + ", reviewContent=" + reviewContent
				+ ", reviewLikeCount=" + reviewLikeCount + ", reviewDate=" + reviewDate + ", emoName=" + emoName
				+ ", nickName=" + nickName + "]";
	}
   
	
	

}

package com.javaex.vo;

public class LikeReviewVo {

	private int reviewNo;
	private String bookTitle;
	private String bookNo;
	private String nickname;
	private int userNo;
	private String reviewContent;
	private String emoName;
	private int emoNo;
	private String reviewDate;
	private int styleNo;
	private int likecnt;
	private int likecheck;
	private String reviewLikeDate;
	private String userPro;
	
	public LikeReviewVo() {}
	
	public LikeReviewVo(int reviewNo, int userNo) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
	}
	public LikeReviewVo(int userNo, String emoName) {
		super();
		this.userNo = userNo;
		this.emoName = emoName;
	}
	public LikeReviewVo(int reviewNo, String bookTitle, String bookNo, String nickname, int userNo, String reviewContent,
			String emoName, int emoNo, String reviewDate, int styleNo, int likecnt, int likecheck) {
		super();
		this.reviewNo = reviewNo;
		this.bookTitle = bookTitle;
		this.bookNo = bookNo;
		this.nickname = nickname;
		this.userNo = userNo;
		this.reviewContent = reviewContent;
		this.emoName = emoName;
		this.emoNo = emoNo;
		this.reviewDate = reviewDate;
		this.styleNo = styleNo;
		this.likecnt = likecnt;
		this.likecheck = likecheck;
	}
	public LikeReviewVo(int reviewNo, String bookTitle, String nickname, int userNo, String reviewContent, String emoName,
			int emoNo, String reviewDate, int styleNo, int likecnt) {
		super();
		this.reviewNo = reviewNo;
		this.bookTitle = bookTitle;
		this.nickname = nickname;
		this.userNo = userNo;
		this.reviewContent = reviewContent;
		this.emoName = emoName;
		this.emoNo = emoNo;
		this.reviewDate = reviewDate;
		this.styleNo = styleNo;
		this.likecnt = likecnt;
	}
	public LikeReviewVo(int reviewNo, String bookTitle, String bookNo, String nickname, int userNo, String reviewContent,
			String emoName, int emoNo, String reviewDate, int styleNo, int likecnt) {
		super();
		this.reviewNo = reviewNo;
		this.bookTitle = bookTitle;
		this.bookNo = bookNo;
		this.nickname = nickname;
		this.userNo = userNo;
		this.reviewContent = reviewContent;
		this.emoName = emoName;
		this.emoNo = emoNo;
		this.reviewDate = reviewDate;
		this.styleNo = styleNo;
		this.likecnt = likecnt;
	}
	
	public LikeReviewVo(int reviewNo, String bookTitle, String bookNo, String nickname, int userNo, String reviewContent,
			String emoName, int emoNo, String reviewDate, int styleNo, int likecnt, int likecheck,
			String reviewLikeDate) {
		super();
		this.reviewNo = reviewNo;
		this.bookTitle = bookTitle;
		this.bookNo = bookNo;
		this.nickname = nickname;
		this.userNo = userNo;
		this.reviewContent = reviewContent;
		this.emoName = emoName;
		this.emoNo = emoNo;
		this.reviewDate = reviewDate;
		this.styleNo = styleNo;
		this.likecnt = likecnt;
		this.likecheck = likecheck;
		this.reviewLikeDate = reviewLikeDate;
	}
	public LikeReviewVo(int reviewNo, String bookTitle, String bookNo, String nickname, int userNo, String reviewContent,
			String emoName, int emoNo, String reviewDate, int styleNo, int likecnt, int likecheck,
			String reviewLikeDate, String userPro) {
		super();
		this.reviewNo = reviewNo;
		this.bookTitle = bookTitle;
		this.bookNo = bookNo;
		this.nickname = nickname;
		this.userNo = userNo;
		this.reviewContent = reviewContent;
		this.emoName = emoName;
		this.emoNo = emoNo;
		this.reviewDate = reviewDate;
		this.styleNo = styleNo;
		this.likecnt = likecnt;
		this.likecheck = likecheck;
		this.reviewLikeDate = reviewLikeDate;
		this.userPro = userPro;
	}
	

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getEmoName() {
		return emoName;
	}
	public void setEmoName(String emoName) {
		this.emoName = emoName;
	}
	public int getEmoNo() {
		return emoNo;
	}
	public void setEmoNo(int emoNo) {
		this.emoNo = emoNo;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getStyleNo() {
		return styleNo;
	}
	public void setStyleNo(int styleNo) {
		this.styleNo = styleNo;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public int getLikecheck() {
		return likecheck;
	}
	public void setLikecheck(int likecheck) {
		this.likecheck = likecheck;
	}
	public String getReviewLikeDate() {
		return reviewLikeDate;
	}
	public void setReviewLikeDate(String reviewLikeDate) {
		this.reviewLikeDate = reviewLikeDate;
	}
	public String getUserPro() {
		return userPro;
	}
	public void setUserPro(String userPro) {
		this.userPro = userPro;
	}

	@Override
	public String toString() {
		return "LikeReviewVo [reviewNo=" + reviewNo + ", bookTitle=" + bookTitle + ", bookNo=" + bookNo + ", nickname="
				+ nickname + ", userNo=" + userNo + ", reviewContent=" + reviewContent + ", emoName=" + emoName
				+ ", emoNo=" + emoNo + ", reviewDate=" + reviewDate + ", styleNo=" + styleNo + ", likecnt=" + likecnt
				+ ", likecheck=" + likecheck + ", reviewLikeDate=" + reviewLikeDate + ", userPro=" + userPro + "]";
	}
	
	
	

}

	
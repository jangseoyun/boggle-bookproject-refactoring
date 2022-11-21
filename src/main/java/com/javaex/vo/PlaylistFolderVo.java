package com.javaex.vo;

public class PlaylistFolderVo {

	//필드
	private int playlistNo;
	private String playlistName;
	private String playlistDate;
	
	private int reviewNo;
	private String reviewContent;
	private String reviewDate;
	
	private String nickname;
	private int userNo;
	
	private String bookNo;
	private String bookTitle;
	
	private int styleNo;
	private String emoName;
	
	private int rn;
	private int likecnt;

	
	//생성자
	public PlaylistFolderVo() {}

	public PlaylistFolderVo(int playlistNo, String playlistName) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
	}

	public PlaylistFolderVo(int playlistNo, String playlistName, String nickname) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
		this.nickname = nickname;
	}
	
	

	public PlaylistFolderVo(int playlistNo, String playlistName, String nickname, int userNo) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
		this.nickname = nickname;
		this.userNo = userNo;
	}

	public PlaylistFolderVo(int playlistNo, int reviewNo, String reviewContent, String bookNo, String bookTitle,
			String emoName) {
		super();
		this.playlistNo = playlistNo;
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.emoName = emoName;
	}

	public PlaylistFolderVo(int playlistNo, int reviewNo, String reviewContent, String reviewDate, int userNo,
			String bookNo, String bookTitle, int styleNo, String emoName, int rn) {
		super();
		this.playlistNo = playlistNo;
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.styleNo = styleNo;
		this.emoName = emoName;
		this.rn = rn;
	}

	public PlaylistFolderVo(int playlistNo, String playlistName, int reviewNo, String reviewContent, String reviewDate,
			String nickname, int userNo, String bookNo, String bookTitle, int styleNo, String emoName) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.nickname = nickname;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.styleNo = styleNo;
		this.emoName = emoName;
	}


	public PlaylistFolderVo(int playlistNo, String playlistName, int reviewNo, String reviewContent, String reviewDate,
			String nickname, int userNo, String bookNo, String bookTitle, int styleNo, String emoName, int rn) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.nickname = nickname;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.styleNo = styleNo;
		this.emoName = emoName;
		this.rn = rn;
	}
	
	public PlaylistFolderVo(int playlistNo, String playlistName, String playlistDate, int reviewNo,
			String reviewContent, String reviewDate, String nickname, int userNo, String bookNo, String bookTitle,
			int styleNo, String emoName, int rn) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
		this.playlistDate = playlistDate;
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.nickname = nickname;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.styleNo = styleNo;
		this.emoName = emoName;
		this.rn = rn;
	}

	public PlaylistFolderVo(int playlistNo, String playlistName, String playlistDate, int reviewNo,
			String reviewContent, String reviewDate, String nickname, int userNo, String bookNo, String bookTitle,
			int styleNo, String emoName, int rn, int likecnt) {
		super();
		this.playlistNo = playlistNo;
		this.playlistName = playlistName;
		this.playlistDate = playlistDate;
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.nickname = nickname;
		this.userNo = userNo;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.styleNo = styleNo;
		this.emoName = emoName;
		this.rn = rn;
		this.likecnt = likecnt;
	}

	//메소드 g,s
	public int getPlaylistNo() {
		return playlistNo;
	}

	public void setPlaylistNo(int playlistNo) {
		this.playlistNo = playlistNo;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getStyleNo() {
		return styleNo;
	}

	public void setStyleNo(int styleNo) {
		this.styleNo = styleNo;
	}

	public String getEmoName() {
		return emoName;
	}

	public void setEmoName(String emoName) {
		this.emoName = emoName;
	}
	
	public int getRownum() {
		return rn;
	}

	public void setRownum(int rownum) {
		this.rn = rownum;
	}

	public String getPlaylistDate() {
		return playlistDate;
	}

	public void setPlaylistDate(String playlistDate) {
		this.playlistDate = playlistDate;
	}
	
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	//메소드 일반
	@Override
	public String toString() {
		return "PlaylistFolderVo [playlistNo=" + playlistNo + ", playlistName=" + playlistName + ", playlistDate="
				+ playlistDate + ", reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", reviewDate="
				+ reviewDate + ", nickname=" + nickname + ", userNo=" + userNo + ", bookNo=" + bookNo + ", bookTitle="
				+ bookTitle + ", styleNo=" + styleNo + ", emoName=" + emoName + ", rn=" + rn + ", likecnt=" + likecnt
				+ "]";
	}
}

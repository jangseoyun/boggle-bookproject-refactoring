package com.javaex.vo;

public class BookmarkVo {
	private int userNo;
	private int book_user_no;
	private String bookNo;
	private String bookmark_date;
	private String nickname;
	private String book_title;
	private String author;
	private String book_url;
	private int genre_no;
	private String cover_url;
	
	public BookmarkVo() {}
	
	public BookmarkVo(int userNo) {}
	
	public BookmarkVo(int userNo, String bookNo) {
		super();
		this.bookNo = bookNo;
		this.userNo=userNo;
	}
	
	public BookmarkVo(int userNo, String bookNo, String author, String cover_url) {
		super();
		this.bookNo = bookNo;
		this.userNo=userNo;
	}
	
	public BookmarkVo(int userNo, int book_user_no, String bookNo, String bookmark_date, String nickname,
			String book_title, String author, String book_url, int genre_no, String cover_url) {
		super();
		this.userNo = userNo;
		this.book_user_no = book_user_no;
		this.bookNo = bookNo;
		this.bookmark_date = bookmark_date;
		this.nickname = nickname;
		this.book_title = book_title;
		this.author = author;
		this.book_url = book_url;
		this.genre_no = genre_no;
		this.cover_url = cover_url;
	}
	
	public BookmarkVo(String book_title, String author, String book_url, String cover_url, String bookNo) {
		super();
		this.book_title = book_title;
		this.author = author;
		this.book_url = book_url;
		this.cover_url = cover_url;
		this.bookNo = bookNo;
		
	}
	
	//g.s
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getBook_user_no() {
		return book_user_no;
	}

	public void setBook_user_no(int book_user_no) {
		this.book_user_no = book_user_no;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookmark_date() {
		return bookmark_date;
	}

	public void setBookmark_date(String bookmark_date) {
		this.bookmark_date = bookmark_date;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBook_url() {
		return book_url;
	}

	public void setBook_url(String book_url) {
		this.book_url = book_url;
	}

	public int getGenre_no() {
		return genre_no;
	}

	public void setGenre_no(int genre_no) {
		this.genre_no = genre_no;
	}

	public String getCover_url() {
		return cover_url;
	}

	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}

	@Override
	public String toString() {
		return "BookmarkVo [userNo=" + userNo + ", book_user_no=" + book_user_no + ", bookNo=" + bookNo
				+ ", bookmark_date=" + bookmark_date + ", nickname=" + nickname + ", book_title=" + book_title
				+ ", author=" + author + ", book_url=" + book_url + ", genre_no=" + genre_no + ", cover_url="
				+ cover_url + "]";
	}
	
}

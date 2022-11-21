package com.javaex.vo;

public class BookVo {
	
	//필드
	private String bookTitle;
	private String author;
	private String coverUrl;
	private int bookNo;
	private String bookUrl;
	private int bookReviewCount;
	private int genreNo;
	
	//생성자
	public BookVo() {}
	public BookVo(String bookTitle, String author, String coverUrl, int bookNo, String bookUrl, int bookReviewCount,
			int genreNo) {
		super();
		this.bookTitle = bookTitle;
		this.author = author;
		this.coverUrl = coverUrl;
		this.bookNo = bookNo;
		this.bookUrl = bookUrl;
		this.bookReviewCount = bookReviewCount;
		this.genreNo = genreNo;
	}


	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookUrl() {
		return bookUrl;
	}
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}
	public int getBookReviewCount() {
		return bookReviewCount;
	}
	public void setBookReviewCount(int bookReviewCount) {
		this.bookReviewCount = bookReviewCount;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	
	
	
	
	@Override
	public String toString() {
		return "BookVo [bookTitle=" + bookTitle + ", author=" + author + ", coverUrl=" + coverUrl + ", bookNo=" + bookNo
				+ ", bookUrl=" + bookUrl + ", bookReviewCount=" + bookReviewCount + "]";
	}
	
	

}

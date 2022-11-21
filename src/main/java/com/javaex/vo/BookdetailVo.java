package com.javaex.vo;

public class BookdetailVo {
	
	//필드
		private int rn;
		
		private String bookNo;
		private String bookTitle;
		private String author;
		private String bookUrl;
		private String coverUrl;
		
		private int reviewNo;
		private String reviewContent;
		private String reviewDate;
		private int styleNo;
		private String emoName;
		private int userNo;
		private String nickname;
		
		private int likecnt;
		private int bookReviewCount;


		//생성자
		public BookdetailVo() {}

		public BookdetailVo(int bookReviewCount) {
			super();
			this.bookReviewCount = bookReviewCount;
		}

		public BookdetailVo(String bookTitle, String author, String bookUrl, String coverUrl) {
			super();
			this.bookTitle = bookTitle;
			this.author = author;
			this.bookUrl = bookUrl;
			this.coverUrl = coverUrl;
		}

		public BookdetailVo(String bookNo, String bookTitle, String author, String bookUrl, String coverUrl,
				int bookReviewCount) {
			super();
			this.bookNo = bookNo;
			this.bookTitle = bookTitle;
			this.author = author;
			this.bookUrl = bookUrl;
			this.coverUrl = coverUrl;
			this.bookReviewCount = bookReviewCount;
		}

		public BookdetailVo(String bookNo, String bookTitle, int reviewNo, String reviewContent, String reviewDate,
				String emoName, int userNo, String nickname, int likecnt) {
			super();
			this.bookNo = bookNo;
			this.bookTitle = bookTitle;
			this.reviewNo = reviewNo;
			this.reviewContent = reviewContent;
			this.reviewDate = reviewDate;
			this.emoName = emoName;
			this.userNo = userNo;
			this.nickname = nickname;
			this.likecnt = likecnt;
		}

		public BookdetailVo(int rn, String bookTitle, int reviewNo, String reviewContent, String reviewDate,
				int styleNo, String emoName, int userNo, String nickname, int likecnt) {
			super();
			this.rn = rn;
			this.bookTitle = bookTitle;
			this.reviewNo = reviewNo;
			this.reviewContent = reviewContent;
			this.reviewDate = reviewDate;
			this.styleNo = styleNo;
			this.emoName = emoName;
			this.userNo = userNo;
			this.nickname = nickname;
			this.likecnt = likecnt;
		}

		public BookdetailVo(int rn, String bookNo, String bookTitle, String author, String bookUrl, String coverUrl,
				int reviewNo, String reviewDate, int styleNo, String emoName, int userNo, String nickname, int likecnt,
				int bookReviewCount) {
			super();
			this.rn = rn;
			this.bookNo = bookNo;
			this.bookTitle = bookTitle;
			this.author = author;
			this.bookUrl = bookUrl;
			this.coverUrl = coverUrl;
			this.reviewNo = reviewNo;
			this.reviewDate = reviewDate;
			this.styleNo = styleNo;
			this.emoName = emoName;
			this.userNo = userNo;
			this.nickname = nickname;
			this.likecnt = likecnt;
			this.bookReviewCount = bookReviewCount;
		}
		
		public BookdetailVo(int rn, String bookNo, String bookTitle, String author, String bookUrl, String coverUrl,
				int reviewNo, String reviewContent, String reviewDate, int styleNo, String emoName, int userNo,
				String nickname, int likecnt, int bookReviewCount) {
			super();
			this.rn = rn;
			this.bookNo = bookNo;
			this.bookTitle = bookTitle;
			this.author = author;
			this.bookUrl = bookUrl;
			this.coverUrl = coverUrl;
			this.reviewNo = reviewNo;
			this.reviewContent = reviewContent;
			this.reviewDate = reviewDate;
			this.styleNo = styleNo;
			this.emoName = emoName;
			this.userNo = userNo;
			this.nickname = nickname;
			this.likecnt = likecnt;
			this.bookReviewCount = bookReviewCount;
		}

		//메소드g,s

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

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getBookUrl() {
			return bookUrl;
		}

		public void setBookUrl(String bookUrl) {
			this.bookUrl = bookUrl;
		}

		public String getCoverUrl() {
			return coverUrl;
		}

		public void setCoverUrl(String coverUrl) {
			this.coverUrl = coverUrl;
		}

		public int getBookReviewCount() {
			return bookReviewCount;
		}

		public void setBookReviewCount(int bookReviewCount) {
			this.bookReviewCount = bookReviewCount;
		}

		public int getRn() {
			return rn;
		}

		public void setRn(int rn) {
			this.rn = rn;
		}

		public int getReviewNo() {
			return reviewNo;
		}

		public void setReviewNo(int reviewNo) {
			this.reviewNo = reviewNo;
		}

		public String getReviewDate() {
			return reviewDate;
		}

		public void setReviewDate(String reviewDate) {
			this.reviewDate = reviewDate;
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

		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public int getLikecnt() {
			return likecnt;
		}

		public void setLikecnt(int likecnt) {
			this.likecnt = likecnt;
		}
		
		public String getReviewContent() {
			return reviewContent;
		}

		public void setReviewContent(String reviewContent) {
			this.reviewContent = reviewContent;
		}

		//메소드 일반
		@Override
		public String toString() {
			return "BookdetailVo [rn=" + rn + ", bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", author=" + author
					+ ", bookUrl=" + bookUrl + ", coverUrl=" + coverUrl + ", reviewNo=" + reviewNo + ", reviewContent="
					+ reviewContent + ", reviewDate=" + reviewDate + ", styleNo=" + styleNo + ", emoName=" + emoName
					+ ", userNo=" + userNo + ", nickname=" + nickname + ", likecnt=" + likecnt + ", bookReviewCount="
					+ bookReviewCount + "]";
		}
		
	
	
	
}

package com.javaex.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

	
}

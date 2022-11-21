package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BookdetailDao;
import com.javaex.vo.BookdetailVo;

@Service
public class BookdetailService {
	
	@Autowired
	private BookdetailDao bookdetailDao;

	/* 해당 책 서평 리스트 */
	public List<BookdetailVo> getReviewList(String bookNo) {

		System.out.println("Service.getReviewList");
		return bookdetailDao.getReviewList(bookNo);

	}
	
	/* 서평 인기순 리스트 */
	public List<BookdetailVo> getReviewBest(String bookNo) {
		
		System.out.println("Service.getReviewBest");
		List<BookdetailVo> reviewBest = bookdetailDao.getReviewBest(bookNo);
		
		return reviewBest;
		
	}
	
	/* 해당 책 정보 */
	public BookdetailVo getBookVo(String bookNo) {

		System.out.println("Service.getBookVo");
		return bookdetailDao.getBookVo(bookNo);

	}
	
	/* 해당 책 총 서평 수 */ 
	public int getCount(String bookNo) {
		
		System.out.println("Service.getCount");
		int getCount = bookdetailDao.getCount(bookNo);
		
		return getCount;
	}
	
	/* 로딩 북마크 체크 */
	public String bookmarkCheck(String bookNo, String userNo) {
		
		System.out.println("Service.bookmarkCheck");
		int bookmarkCheck = bookdetailDao.bookmarkCheck(bookNo,userNo);
		
		if(bookmarkCheck == 0) {
			return "true";
		}else if(bookmarkCheck == 1){
			return "false";
		}else {
			return "error";
		}

	}
	
	/* 북마크 추가*/ 
	public String bookmarkInsert(String userNo, String bookNo) {
		
		System.out.println("Service.bookmark");
		//북마크 추가 
		int addCount = bookdetailDao.bookmarkInsert(userNo,bookNo);
		
		/*-로 화면 변경되어야함*/
		String addResult = "true";
		if(addCount == 1) {
			addResult = "false";
		}
		
		return addResult;
	}
	
	
	/* 북마크 제거 */
	public String bookmarkDelete(String userNo, String bookNo) {
		
		System.out.println("Service.bookmarkDelete");
		int deleteCount = bookdetailDao.bookmarkDelete(userNo,bookNo);
		
		/* +로 화변 변경되어야함 */
		String deleteResult = "false";
		if(deleteCount == 1) {
			deleteResult = "true";
		}
		
		return deleteResult;
		
	}
	
	/* 서평 삭제 */
	public int reviewDelete(int reviewNo) {
		System.out.println("Service.reviewDelete");
		int deleteResult = bookdetailDao.reviewDelete(reviewNo);		
		return deleteResult;
	}
	
	

}

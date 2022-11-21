package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BookdetailVo;

@Repository
public class BookdetailDao {
	
	@Autowired
	private SqlSession sqlSession;
	

	/* 서평 리스트 (최신순) */
	public List<BookdetailVo> getReviewList(String bookNo) {

		System.out.println("Dao.getReviewList");
		List<BookdetailVo> reviewList = sqlSession.selectList("bookdetail.reviewListLatest",bookNo);
		System.out.println(reviewList);

		return reviewList;

	}
	
	/* 서평 리스트 (인기순) */
	public List<BookdetailVo> getReviewBest(String bookNo) {
		
		System.out.println("Dao.getReviewBest");
		List<BookdetailVo> reviewBest = sqlSession.selectList("bookdetail.reviewListBest",bookNo);
		System.out.println("dao.인기순리스트:"+reviewBest);
		
		return reviewBest;
	}
	
	
	/* 해당 책 정보 */
	public BookdetailVo getBookVo(String bookNo) {

		System.out.println("Dao.getBookVo");
		BookdetailVo bookVo = sqlSession.selectOne("bookdetail.getbookVo",bookNo);
		System.out.println("dao: "+bookVo);

		return bookVo;

	}
	
	/* 해당 책 총 서평 수 */ 
	public int getCount(String bookNo) {

		System.out.println("Dao.getCount");
		int getCount = sqlSession.selectOne("bookdetail.bookReviewCount",bookNo);
		System.out.println(getCount);

		return getCount;

	}
	
	/* 로딩 북마크 체크 */
	public int bookmarkCheck(String bookNo, String userNo) {
		
		System.out.println("Dao.bookmarkCheck");
		
		Map<String, String> bookmark = new HashMap<String, String>();
		bookmark.put("userNo", userNo);
		bookmark.put("bookNo", bookNo);
		
		System.out.println("dao:"+bookmark);
		
		int bookmarkCheck = sqlSession.selectOne("bookdetail.bookmarkCheck",bookmark);
		System.out.println(bookmarkCheck);
		
		return bookmarkCheck;
	}
	
	/* 북마크 추가*/ 
	public int bookmarkInsert(String userNo, String bookNo) {
		
		System.out.println("Dao.bookmarkInsert");
		
		Map<String, String> markInsert = new HashMap<String, String>();
		markInsert.put("userNo", userNo);
		markInsert.put("bookNo", bookNo);
		
		int addCount = sqlSession.insert("bookdetail.bookmarkInsert",markInsert);
		System.out.println("addCount:"+addCount);
		
		return addCount;
	}
	
	
	/* 북마크 제거 */
	public int bookmarkDelete(String userNo, String bookNo) {
		
		System.out.println("Dao.bookmarkDelete");
		
		Map<String, String> markDelete = new HashMap<String, String>();
		markDelete.put("userNo", userNo);
		markDelete.put("bookNo", bookNo);
		
		int deleteCount = sqlSession.delete("bookdetail.bookmarkDelete",markDelete);
		System.out.println("deleteCount:"+deleteCount);

		
		return deleteCount;
		
	}
	
	
	/* 서평 삭제 */
	public int reviewDelete(int reviewNo) {
		System.out.println("Dao.reviewDelete");
		
		int deleteResult = sqlSession.delete("bookdetail.reviewDelete",reviewNo);		
		System.out.println("책상세 서평 삭제 결과:"+deleteResult);
		
		return deleteResult;
	}
	

}

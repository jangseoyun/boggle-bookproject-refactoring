package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.StyleVo;

@Repository
public class ReviewWriteDao {

	@Autowired
	SqlSession sqlSession;
	
	public int getReviewTotalCnt(long isbn) {
		return sqlSession.selectOne("reviewwrite.getReviewTotalCnt", isbn);
	}
	
	
	public List<StyleVo> getStyle(int emoNo) {
		List<StyleVo> list = sqlSession.selectList("reviewwrite.getStyle", emoNo);
		
		System.out.println("style list: " + list);
		
		return list;
	}
	
	public int addReview(Map<String, Object> map) {
		int result = sqlSession.insert("reviewwrite.addReview", map);
		
		System.out.println(result + "건 | 리뷰가 저장됨");

		return result;
	}
	
	public void addGenre(Map<String, Object> map) {
		int result = sqlSession.insert("reviewwrite.addGenre", map);
		
		System.out.println(result + "건 | 장르 저장");
	}
	
	public void addBook(Map<String, Object> map) {
		int result = sqlSession.insert("reviewwrite.addBook", map);
		
		System.out.println(result + "건 | book 저장");
	}
	
	public int checkGenre(Map<String,Object> map) {
		return sqlSession.selectOne("reviewwrite.checkGenre", map);
	}
	
	public int checkBook(Map<String, Object> map) {
		return sqlSession.selectOne("reviewwrite.checkBook", map);
	}
	
	public int checkBook(String bookTitle) {
		int result = sqlSession.selectOne("reviewwrite.checkBookStr", bookTitle);
		
		System.out.println(result + "건 | db에 있는 책 정보");
		
		return result;
	}
	
	public Map<String, Object> getBookInfo(String bookTitle) {
		Map<String, Object> result = sqlSession.selectOne("reviewwrite.getBookInfo", bookTitle);
		
		System.out.println("책 정보: "+result);
		
		return result;
	}
	
	public Map<String, Object> getPrevReviewInfo(int reviewNo) {
		Map<String, Object> result = sqlSession.selectOne("reviewwrite.getPrevReviewInfo", reviewNo);
		
		return result;
	}
	
	public int checkReviewWriter(Map<String, Object> map) {
		return sqlSession.selectOne("reviewwrite.checkReviewWriter", map);
	}
	
	public int checkBookUpdate(Map<String, Object> map) {
		return sqlSession.selectOne("reviewwrite.checkBookUpdate", map);
	}

	public int modifyReview(Map<String, Object> map) {
		int result = sqlSession.update("reviewwrite.modifyReview", map);
		
		System.out.println(result + "건 | 서평 수정 완료");
		
		return result;
	}
}

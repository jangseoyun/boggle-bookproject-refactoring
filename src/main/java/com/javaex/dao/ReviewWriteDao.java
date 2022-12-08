package com.javaex.dao;

import com.javaex.dto.reviewwrite.ReviewAddRequest;
import com.javaex.dto.reviewwrite.ReviewAddResponse;
import com.javaex.dto.reviewwrite.ReviewModifyRequest;
import com.javaex.dto.reviewwrite.StyleDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Mapper
@Repository
public interface ReviewWriteDao {

    int getReviewTotalCnt(long isbn);

    List<StyleDto> getStyle(Long emoNo);

    int checkGenre(Long genreNo);

    void addGenre(ReviewAddRequest reviewAddRequest);

    int checkBook(Long bookNo);

    int findByBookTitle(String bookTitle);

    int addBook(ReviewAddRequest reviewAddRequest);

    int addReview(ReviewAddRequest reviewAddRequest);

    ReviewAddResponse selectReviewOne(Long ReviewNo);

    Map<String, Object> getBookInfo(String bookTitle);

    Map<String, Object> getPrevReviewInfo(Long reviewNo);

    int checkReviewWriter(Map<String, Long> reviewWriterMap);

    int checkBookUpdate(ReviewModifyRequest reviewModifyRequest);
	/*
	


	public int checkBook(String bookTitle) {
		int result = sqlSession.selectOne("reviewwrite.checkBookStr", bookTitle);
		
		System.out.println(result + "건 | db에 있는 책 정보");
		
		return result;
	}



	public int modifyReview(Map<String, Object> map) {
		int result = sqlSession.update("reviewwrite.modifyReview", map);
		
		System.out.println(result + "건 | 서평 수정 완료");
		
		return result;
	}*/
}

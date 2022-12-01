package com.javaex.dao;

import com.javaex.dto.bookdetail.BookDetailInfo;
import com.javaex.dto.bookdetail.BookMarkRequest;
import com.javaex.dto.bookdetail.BookReviewDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Mapper
@Repository
public interface BookdetailDao {

    /* 서평 리스트 (최신순) */
    List<BookReviewDto> reviewListLatest(String bookNo);

    /* 서평 리스트 (인기순) */
    List<BookReviewDto> reviewListBest(String bookNo);

    /* 해당 책 정보 */
    BookDetailInfo getbookVo(String bookNo);

    /* 해당 책 총 서평 수 */
    int bookReviewCount(String bookNo);

    /* 로딩 북마크 체크 */
    int bookmarkCheck(BookMarkRequest bookMarkRequest);

    /* 북마크 추가*/
    int bookmarkInsert(BookMarkRequest bookMarkRequest);


    /* 북마크 제거 */
    int bookmarkDelete(BookMarkRequest bookMarkRequest);


    /*//* 서평 삭제 *//*
    public int reviewDelete(int reviewNo) {
        System.out.println("Dao.reviewDelete");

        int deleteResult = sqlSession.delete("bookdetail.reviewDelete", reviewNo);
        System.out.println("책상세 서평 삭제 결과:" + deleteResult);

        return deleteResult;
    }*/


}

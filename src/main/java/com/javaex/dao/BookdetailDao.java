package com.javaex.dao;

import com.javaex.dto.bookdetail.BookDetailInfo;
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
    /*public int bookmarkCheck(String bookNo, String userNo) {

        System.out.println("Dao.bookmarkCheck");

        Map<String, String> bookmark = new HashMap<String, String>();
        bookmark.put("userNo", userNo);
        bookmark.put("bookNo", bookNo);

        System.out.println("dao:" + bookmark);

        int bookmarkCheck = sqlSession.selectOne("bookdetail.bookmarkCheck", bookmark);
        System.out.println(bookmarkCheck);

        return bookmarkCheck;
    }

    *//* 북마크 추가*//*
    public int bookmarkInsert(String userNo, String bookNo) {

        System.out.println("Dao.bookmarkInsert");

        Map<String, String> markInsert = new HashMap<String, String>();
        markInsert.put("userNo", userNo);
        markInsert.put("bookNo", bookNo);

        int addCount = sqlSession.insert("bookdetail.bookmarkInsert", markInsert);
        System.out.println("addCount:" + addCount);

        return addCount;
    }


    *//* 북마크 제거 *//*
    public int bookmarkDelete(String userNo, String bookNo) {

        System.out.println("Dao.bookmarkDelete");

        Map<String, String> markDelete = new HashMap<String, String>();
        markDelete.put("userNo", userNo);
        markDelete.put("bookNo", bookNo);

        int deleteCount = sqlSession.delete("bookdetail.bookmarkDelete", markDelete);
        System.out.println("deleteCount:" + deleteCount);


        return deleteCount;

    }


    *//* 서평 삭제 *//*
    public int reviewDelete(int reviewNo) {
        System.out.println("Dao.reviewDelete");

        int deleteResult = sqlSession.delete("bookdetail.reviewDelete", reviewNo);
        System.out.println("책상세 서평 삭제 결과:" + deleteResult);

        return deleteResult;
    }*/


}

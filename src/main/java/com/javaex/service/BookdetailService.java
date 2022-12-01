package com.javaex.service;

import com.javaex.dao.BookdetailDao;
import com.javaex.dto.bookdetail.BookDetailInfo;
import com.javaex.dto.bookdetail.BookReviewDto;
import com.javaex.dto.bookdetail.BookReviewResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookdetailService {
    private final BookdetailDao bookdetailDao;

    /* 해당 책 서평 리스트 */
    public BookReviewResponse getReviewList(String bookNo) {
        log.info("{}번 책 서평 최신순 리스트", bookNo);
        List<BookReviewDto> bookReviews = bookdetailDao.reviewListLatest(bookNo);
        return new BookReviewResponse(bookReviews);
    }

    /* 서평 인기순 리스트 */
    public BookReviewResponse getReviewBest(String bookNo) {
        log.info("{}번 책 서평 인기순 리스트", bookNo);
        List<BookReviewDto> bookReviews = bookdetailDao.reviewListBest(bookNo);
        return new BookReviewResponse(bookReviews);
    }

    /* 해당 책 정보 */
    public BookDetailInfo getBookVo(String bookNo) {
        log.info("{}번, 책 정보 가져오기", bookNo);
        BookDetailInfo getBookDetailInfo = bookdetailDao.getbookVo(bookNo);
        log.info("getbookVo :{}", getBookDetailInfo);
        return getBookDetailInfo;
    }

    /* 해당 책 총 서평 수 */
    public int getCount(String bookNo) {
        int getCount = bookdetailDao.bookReviewCount(bookNo);
        return getCount;
    }

    /*//* 로딩 북마크 체크 *//*
    public String bookmarkCheck(String bookNo, String userNo) {

        System.out.println("Service.bookmarkCheck");
        int bookmarkCheck = bookdetailDao.bookmarkCheck(bookNo, userNo);

        if (bookmarkCheck == 0) {
            return "true";
        } else if (bookmarkCheck == 1) {
            return "false";
        } else {
            return "error";
        }

    }

    *//* 북마크 추가*//*
    public String bookmarkInsert(String userNo, String bookNo) {

        System.out.println("Service.bookmark");
        //북마크 추가
        int addCount = bookdetailDao.bookmarkInsert(userNo, bookNo);

        *//*-로 화면 변경되어야함*//*
        String addResult = "true";
        if (addCount == 1) {
            addResult = "false";
        }

        return addResult;
    }


    *//* 북마크 제거 *//*
    public String bookmarkDelete(String userNo, String bookNo) {

        System.out.println("Service.bookmarkDelete");
        int deleteCount = bookdetailDao.bookmarkDelete(userNo, bookNo);

        *//* +로 화변 변경되어야함 *//*
        String deleteResult = "false";
        if (deleteCount == 1) {
            deleteResult = "true";
        }

        return deleteResult;

    }

    *//* 서평 삭제 *//*
    public int reviewDelete(int reviewNo) {
        System.out.println("Service.reviewDelete");
        int deleteResult = bookdetailDao.reviewDelete(reviewNo);
        return deleteResult;
    }*/


}

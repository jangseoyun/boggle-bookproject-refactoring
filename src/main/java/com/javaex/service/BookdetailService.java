package com.javaex.service;

import com.javaex.dao.BookdetailDao;
import com.javaex.dto.bookdetail.*;
import com.javaex.dto.bookdetail.factory.BookReviewFactory;
import com.javaex.dto.bookdetail.factory.BookmarkFactory;
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

    /* 로딩 북마크 체크 */
    public String bookmarkCheck(BookMarkRequest bookMarkRequest) {
        int bookmarkCheck = bookdetailDao.bookmarkCheck(bookMarkRequest);

        if (bookmarkCheck == 0) {
            return "true";
        } else if (bookmarkCheck == 1) {
            return "false";
        } else {
            return "error";
        }
    }

    //* 북마크 추가*/
    public BookMarkResponse bookmarkInsert(BookMarkRequest bookMarkRequest) {
        int addResult = bookdetailDao.bookmarkInsert(bookMarkRequest);
        return BookmarkFactory.createResponse(addResult, bookMarkRequest.getBookNo());
    }


    /* 북마크 제거 */
    public BookMarkResponse bookmarkDelete(BookMarkRequest bookMarkRequest) {
        int deleteCount = bookdetailDao.bookmarkDelete(bookMarkRequest);
        return BookmarkFactory.createResponse(deleteCount, bookMarkRequest.getBookNo());
    }

    /* 서평 삭제 */
    public ReviewDeleteResponse reviewDelete(Long reviewNo) {
        int deleteResult = bookdetailDao.reviewDelete(reviewNo);
        System.out.println("service: "+deleteResult);
        return BookReviewFactory.createDeleteResponse(deleteResult);
    }


}

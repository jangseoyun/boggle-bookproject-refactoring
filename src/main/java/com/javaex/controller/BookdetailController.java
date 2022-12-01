package com.javaex.controller;

import com.javaex.dto.bookdetail.*;
import com.javaex.service.BookdetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle/book-detail")
public class BookdetailController {
    /* 필드 */
    private final BookdetailService bookdetailService;

    /* 책 상세페이지 */
    @GetMapping("/{book-no}")
    public ResponseEntity<BookDetailResponse> bookDetail(@RequestParam("user-no") Long userNo
            , @PathVariable("book-no") String bookNo) {
        log.info("{}번 유저, 책 상세페이지 접속", userNo);
        //책 정보
        BookDetailInfo bookInfo = bookdetailService.getBookVo(bookNo);
        //해당 책 서평 총 수
        int bookReviewCount = bookdetailService.getCount(bookNo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new BookDetailResponse(bookInfo, bookReviewCount));
    }

    /* 서평 리스트 (최신순)*/
    @GetMapping("/{book-no}/reviews")
    public ResponseEntity<BookReviewResponse> reviewListing(@PathVariable("book-no") String bookNo) {
        log.info("{}번 책 서평 리스트", bookNo);
        //서평 리스트
        BookReviewResponse bookReviews = bookdetailService.getReviewList(bookNo);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookReviews);
    }

    /* 서평 리스트 (인기순) */
    @GetMapping("/{book-no}/reviews/popularity")
    public ResponseEntity<BookReviewResponse> reviewBest(@PathVariable("book-no") String bookNo) {
        log.info("{}번 책 서평 리스트(인기순)", bookNo);
        BookReviewResponse bookReviews = bookdetailService.getReviewBest(bookNo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookReviews);
    }

    /* 로딩시 이전 북마크 데이터 확인 */
    @GetMapping("/bookmark") //todo: 메세지 리팩토링 예정
    public ResponseEntity checkbookMark(BookMarkRequest bookMarkRequest) {
        log.info("{} 도서, {} 유저 북마크 체크", bookMarkRequest.getBookNo(), bookMarkRequest.getUserNo());
        String bookmarkCheck = bookdetailService.bookmarkCheck(bookMarkRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookmarkCheck);
    }

    /* 북마크 추가 */
	@PutMapping("/bookmark")
	public ResponseEntity<BookMarkResponse> bookmarkAdd(BookMarkRequest bookMarkRequest
                            , @RequestParam("mark-status") String markStatus) {
        log.info("{} 유저 북마크 상태 : {}", bookMarkRequest.getUserNo(), markStatus);
        BookMarkResponse bookMarkResponse = bookdetailService.bookmarkInsert(bookMarkRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookMarkResponse);
	}

    /* 북마크 삭제 */
    @DeleteMapping("/bookmark")
    public ResponseEntity<BookMarkResponse> bookmarkDelete(BookMarkRequest bookMarkRequest
                                , @RequestParam("mark-status") String markStatus) {//false
        BookMarkResponse bookMarkResponse = bookdetailService.bookmarkDelete(bookMarkRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookMarkResponse);
    }
	
	/* 서평 삭제 */
	@DeleteMapping("/review/{no}")
	public ResponseEntity<ReviewDeleteResponse> reviewRemove(@PathVariable("no") Long reviewNo) {
		log.info("{}번 서평 삭제 요청", reviewNo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookdetailService.reviewDelete(reviewNo));
	}


}

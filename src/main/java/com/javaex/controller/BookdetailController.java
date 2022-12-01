package com.javaex.controller;

import com.javaex.dto.bookdetail.BookDetailInfo;
import com.javaex.dto.bookdetail.BookDetailResponse;
import com.javaex.dto.bookdetail.BookReviewResponse;
import com.javaex.service.BookdetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle")
public class BookdetailController {
	/* 필드 */
	private final BookdetailService bookdetailService;

	/* 책 상세페이지 */
	@GetMapping("/{user-no}/bookdetail")
	public ResponseEntity<BookDetailResponse> bookDetail(@RequestParam("user-no") Long userNo
											, @PathVariable("no") String bookNo) {
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
	
	/*//* 로딩시 이전 북마크 데이터 확인 *//*
	@ResponseBody
	@RequestMapping("/checkbookMark")
	public String checkbookMark(@RequestParam("bookNo") String bookNo,
								@RequestParam("userNo") String userNo,
								Model model) {
		
		System.out.println("Controller.checkbookMark");
		
		//로딩시 북마크 체크(세션넘버, 북넘버)
		String bookmarkCheck = bookdetailService.bookmarkCheck(bookNo,userNo);
		
		model.addAttribute(bookmarkCheck);
		
		return bookmarkCheck;
	}
	
	*//* 북마크 추가 / 제거 *//*
	@ResponseBody
	@RequestMapping("/bookmark")
	public String bookmark(@RequestParam("markresult") String markresult,
						   @RequestParam("userNo") String userNo,
						   @RequestParam("bookNo") String bookNo) {
		
		System.out.println("Controller.bookmark");
		System.out.println("controller: "+markresult);
		
		if(markresult.equals("false")) {
			
			String deleteResult = bookdetailService.bookmarkDelete(userNo,bookNo);
			System.out.println("북마크 삭제, +화면"+deleteResult);
			return deleteResult;
			
		}else{
			String addResult = bookdetailService.bookmarkInsert(userNo,bookNo);
			System.out.println("북마크 추가, -화면"+addResult);
			return addResult;

		}
	}
	
	*//* 서평 삭제 *//*
	@ResponseBody
	@RequestMapping("/delete")
	public int reviewRemove(@RequestParam("reviewNo") int reviewNo) {
		
		System.out.println("Controller.reviewRemove");
		int deleteResult = bookdetailService.reviewDelete(reviewNo);
		
		return deleteResult;
		
	}*/
	
	
	
	
	
	

}

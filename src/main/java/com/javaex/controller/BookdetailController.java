package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BookdetailService;
import com.javaex.vo.BookdetailVo;

@Controller
@RequestMapping("/bookdetail")
public class BookdetailController {
	
	/* 필드 */
	@Autowired
	private BookdetailService bookdetailService;

	/* 책 상세페이지 */
	@RequestMapping("")
	public String bookDetail(@RequestParam("bookNo") String bookNo,
							 @RequestParam("userNo") String userNo,
							 Model model) {
		
		System.out.println(bookNo);
		System.out.println("Controller.bookdetail");
		
		//책 정보
		BookdetailVo bookVo = bookdetailService.getBookVo(bookNo);
		System.out.println("controller: "+ bookVo);
		
		//해당 책 서평 총 수 
		int bookReviewCount = bookdetailService.getCount(bookNo);
		System.out.println(bookReviewCount);

		//데이터 보내기
		Map<String, Object> bookMap = new HashMap<String, Object>();
		bookMap.put("bookVo", bookVo);
		bookMap.put("bookReviewCount", bookReviewCount);

		//데이터 보내기
		model.addAttribute("bookMap",bookMap);
		
		return "book_detail/book_detail";
	}
	
	/* 서평 리스트 (최신순)*/
	@ResponseBody
	@RequestMapping("/reviewLatest")
	public List<BookdetailVo> reviewListing(@RequestParam("bookNo") String bookNo,
								Model model) {
		
		System.out.println("Controller.reviewListing");
		
		//서평 리스트
		List<BookdetailVo> reviewList = bookdetailService.getReviewList(bookNo);
		System.out.println(reviewList);
		
		model.addAttribute("reviewList",reviewList);
		
		return reviewList;
		
	}
	
	/* 서평 리스트 (인기순) */
	@ResponseBody
	@RequestMapping("/reviewBest")
	public List<BookdetailVo> reviewBest(@RequestParam("bookNo") String bookNo,
											Model model) {
							
		System.out.println("Controller.reviewBest");
		System.out.println(bookNo);
		List<BookdetailVo> reviewBest = bookdetailService.getReviewBest(bookNo);
		System.out.println(reviewBest);
		
		return reviewBest;
	}
	
	/* 로딩시 이전 북마크 데이터 확인 */
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
	
	/* 북마크 추가 / 제거 */
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
	
	/* 서평 삭제 */
	@ResponseBody
	@RequestMapping("/delete")
	public int reviewRemove(@RequestParam("reviewNo") int reviewNo) {
		
		System.out.println("Controller.reviewRemove");
		int deleteResult = bookdetailService.reviewDelete(reviewNo);
		
		return deleteResult;
		
	}
	
	
	
	
	
	

}

package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class test {
	
//	@RequestMapping("")
//	public String bookDetail() {
//		System.out.println("main");
//		
//		return "main/main";
//	}
	
	@RequestMapping("/analyze")
	public String analyze() {
		System.out.println("user_analyze");
		
		return "analyze/user_analyze";
	}
	
	
//	@RequestMapping("/mybook")
//	public String mybook() {
//		System.out.println("mybook");
//		
//		return "mybook/mybook_review";
//	}
	
	@RequestMapping("/imgpreview")
	public String imgpreview() {
		System.out.println("image_preview");
		
		return "mybook/image_preview";
	}
	
//	@RequestMapping("/review_write")
//	public String review_write() {
//		System.out.println("review_write");
//		
//		return "review_write/review_write";
//	}
	
//	@RequestMapping("/taste_main")
//	public String taste_main() {
//		System.out.println("taste_main");
//		
//		return "taste/taste-main";
//	}
	
//	@RequestMapping("/click_playlist")
//	public String click_playlist() {
//		System.out.println("click_playlist");
//		
//		return "taste/click-playlist";
//	}
//	
//	@RequestMapping("/{nickname}/like_playlist")
//	public String like_playlist() {
//		System.out.println("like_playlist");
//		
//		return "taste/like-playlist";
//	}/*내가 좋아요한*/
	
	@RequestMapping("/main_book")
	public String main_book() {
		System.out.println("main_book");
		
		return "taste/main-book";
	}
	
	@RequestMapping("/playlist_edit")
	public String playlist_edit() {
		System.out.println("playlist_edit");
		
		return "taste/playlist_edit";
	}
	
	@RequestMapping("/playlist")
	public String playlist() {
		System.out.println("playlist");
		
		return "taste/playlist";
	}
	
	
	@RequestMapping("/recommend_playlist")
	public String recommend() {
		System.out.println("recommend");
		return "taste/recommend_playlist";
	}/*오늘의 추천 (2번째줄) 플레이리스트 */
	
	@RequestMapping("/hot_playlist")
	public String hot() {
		System.out.println("hot_playlist");
		return "taste/hot_playlist";
	}/*인기순*/
	
	@RequestMapping("/written_playlist")
	public String written() {
		System.out.println("written_playlist");
		return "taste/written_playlist";
	}/*내가 작성한 */
	
}

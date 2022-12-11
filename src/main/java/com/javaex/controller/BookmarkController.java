package com.javaex.controller;

import com.javaex.dto.bookmark.BookMarkListResponse;
import com.javaex.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/boggle")
public class BookmarkController {
	// field
	private final BookmarkService bookmarkService;

	// 리스트 출력 기능
	@GetMapping("/{other-email}/bookmark")
	public ResponseEntity bookmarkController(Authentication authentication, @PathVariable("other-email") String userEmail)  {
		log.info("로그인한 사람의 닉네임 : " + authentication.getName());
		List<BookMarkListResponse> getBookMarkList;
		//로그인한 유저가 접속한 북마크 페이지
		if (userEmail != authentication.getName()) {
			log.info("anotherUser");
			 getBookMarkList = bookmarkService.getBookMarkList(userEmail);
		} else {
			log.info("loginUser");
			getBookMarkList= bookmarkService.getBookMarkList(authentication.getName());
		}

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(getBookMarkList);
	}
}
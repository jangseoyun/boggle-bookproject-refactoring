package com.javaex.service;

import com.javaex.dao.BookmarkDao;
import com.javaex.dto.bookmark.BookMarkListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookmarkService {
	private final BookmarkDao bookmarkDao;

	// 유저 번호 입력시 해당유저 북마크 리스트 출력
	public List<BookMarkListResponse> getBookMarkList(String userEmail) {
		log.info("getBookmarkList");
		List<BookMarkListResponse> bookMarkList = bookmarkDao.bookMarkList(userEmail);
		return bookMarkList;
	}
	
	// 유저 번호 입력시 해당유저 북마크 리스트 출력
	public List<BookMarkListResponse> previewBookmarkLimitFiv(Long userNo) {
		return bookmarkDao.previewBookmarkLimitFiv(userNo);
	}
}

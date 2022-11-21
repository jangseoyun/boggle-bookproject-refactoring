package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.BookmarkDao;
import com.javaex.vo.BookmarkVo;

@Repository
public class BookmarkService {

	// field
	@Autowired
	private BookmarkDao bookmarkDao;

//	// 유저 번호 입력시 해당유저 북마크 리스트 출력
	public List<BookmarkVo> getBMList(int userNo) {
		System.out.println("Service.getBookmarkList");
	
		List<BookmarkVo> bmList = bookmarkDao.getBMList(userNo);
		return bmList;
	}
	
	// 유저 번호 입력시 해당유저 북마크 리스트 출력
	public List<BookmarkVo> get5book(int userNo) {
		System.out.println("Service.get5book");
	
		List<BookmarkVo> get5book = bookmarkDao.get5book(userNo);
		return get5book;
	}
}

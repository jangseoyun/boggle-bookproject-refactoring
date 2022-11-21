package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.PlaylistDao;
import com.javaex.vo.PlaylistVo;

@Repository
public class PlaylistService {
	
	//필드
	@Autowired
	private PlaylistDao playlistDao; 
	
	//좋아요한 플레이리스트 리스트출력
	public List<PlaylistVo> likelist(int userNo){
		
		List<PlaylistVo> likeplay = playlistDao.likelist(userNo);
		System.out.println(likeplay);
		
		return likeplay;
	}
	
	//인기리스트출력
	public List<PlaylistVo> popularlist(){
		
		List<PlaylistVo> popularlist = playlistDao.popularlist();
		System.out.println(popularlist);
		
		return popularlist;
	}
	
	//유저 넘버 주면, 특정유저가 만든 리스트 출력
	public List<PlaylistVo> makelist(int userNo){
		
		List<PlaylistVo> makelist = playlistDao.makelist(userNo);
		System.out.println(makelist);
		
		return makelist;
	}
	
	
	
}

package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PlaylistClickDao;
import com.javaex.vo.PlaylistClickVo;

@Service
public class PlaylistClickService{
	
	//field
	@Autowired
	private PlaylistClickDao playlistClickDao;
	
	//좋아요한 플레이리스트 리스트출력
	public List<PlaylistClickVo> likelistclick (int userNo){
		
		List<PlaylistClickVo> likeplayclick = playlistClickDao.likelistclick(userNo);
		System.out.println(likeplayclick);
		
		return likeplayclick;
	}
	
	public List<PlaylistClickVo> popularlistclick(){
		List<PlaylistClickVo> popularplayclick = playlistClickDao.popularlistclick();
		System.out.println(popularplayclick);
		
		return popularplayclick;
	}
	
	public List<PlaylistClickVo> makelistclick(int userNo){
		List<PlaylistClickVo> makelistclick = playlistClickDao.makelistclick(userNo);
		System.out.println(makelistclick);
		
		return makelistclick;
	}
}

package com.javaex.service;

import com.javaex.dao.PlaylistDao;
import com.javaex.dto.playlist.LikePlaylistDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaylistService {
	private final PlaylistDao playlistDao;
	
	//좋아요한 플레이리스트 리스트출력
	public List<LikePlaylistDto> previewPlaylistLimitFiv(Long userNo){
		return playlistDao.previewPlaylistLimitFiv(userNo);
	}
	
	//인기리스트출력
	/*public List<PlaylistVo> popularlist(){
		
		List<PlaylistVo> popularlist = playlistDao.popularlist();
		System.out.println(popularlist);
		
		return popularlist;
	}
	
	//유저 넘버 주면, 특정유저가 만든 리스트 출력
	public List<PlaylistVo> makelist(int userNo){
		
		List<PlaylistVo> makelist = playlistDao.makelist(userNo);
		System.out.println(makelist);
		
		return makelist;
	}*/
	
	
	
}

package com.javaex.service;

import com.javaex.dao.PlaylistClickDao;
import com.javaex.dto.clickPlaylist.ClickPlayListDto;
import com.javaex.dto.playlist.LikePlaylistDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaylistClickService{
	private final PlaylistClickDao playlistClickDao;
	
	/*좋아요한 플레이리스트 목록*/
	public List<LikePlaylistDto> getLikePlayList (Long userNo){
		return playlistClickDao.likePlayList(userNo);
	}

	/*인기순 플레이리스트 목록*/
	public List<ClickPlayListDto> popularPlayList(){
		return playlistClickDao.popularPlayList();
	}

	/*특정 유저 플레이리스트 목록*/
	public List<ClickPlayListDto> playListByUser(Long userNo){
		return playlistClickDao.playListByUser(userNo);
	}
}

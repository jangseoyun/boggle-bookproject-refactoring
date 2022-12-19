package com.javaex.dao;

import com.javaex.dto.clickPlaylist.ClickPlayListDto;
import com.javaex.dto.playlist.LikePlaylistDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Mapper
@Repository
public interface PlaylistClickDao {

	List<LikePlaylistDto> likePlayList(Long userNo);

	List<ClickPlayListDto> popularPlayList();

	/*특정유저가 만든 리스트 출력*/
	List<ClickPlayListDto> playListByUser(Long userNo);

}

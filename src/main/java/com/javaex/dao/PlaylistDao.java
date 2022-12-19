package com.javaex.dao;

import com.javaex.dto.playlist.LikePlaylistDto;
import com.javaex.dto.playlist.PopularPlayListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Mapper
@Repository
public interface PlaylistDao {
	List<LikePlaylistDto> previewPlaylistLimitFiv(Long userNo);

	//인기리스트출력
	List<PopularPlayListDTO> popularPlaylistLimitFiv();

	//특정유저가 만든 리스트 출력
	List<PopularPlayListDTO> playListByUserLimitFiv(Long userNo);

}

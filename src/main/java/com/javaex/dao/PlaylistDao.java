package com.javaex.dao;

import com.javaex.dto.playlist.LikePlaylistDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Lazy
@Mapper
@Repository
public interface PlaylistDao {
	List<LikePlaylistDto> previewPlaylistLimitFiv(Long userNo);
	
	/*//인기리스트출력
	public List<PlaylistVo> popularlist(){
		
		List<PlaylistVo> popularlist = sqlSession.selectList("playlist.popularplay");
		
		return popularlist;
	}
	
	//특정유저가 만든 리스트 출력
	public List<PlaylistVo> makelist(int userNo){
		
		List<PlaylistVo> makelist = sqlSession.selectList("playlist.makelist", userNo);
		
		return makelist;
	}*/

}

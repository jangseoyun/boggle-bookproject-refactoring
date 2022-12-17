package com.javaex.dao;

import java.util.List;

import com.javaex.dto.clickPlaylist.LikePlayListDto;
import com.javaex.dto.clickPlaylist.PlayListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PlaylistClickVo;
import com.javaex.vo.PlaylistVo;

@Lazy
@Mapper
@Repository
public interface PlaylistClickDao {

	List<LikePlayListDto> likePlayList(Long userNo);

	List<PlayListDto> popularPlayList();

	/*특정유저가 만든 리스트 출력*/
	List<PlayListDto> playListByUser(Long userNo);

}

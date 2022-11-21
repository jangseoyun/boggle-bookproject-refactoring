package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PlaylistClickVo;
import com.javaex.vo.PlaylistVo;

@Repository
public class PlaylistClickDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<PlaylistClickVo> likelistclick(int userNo){
		List<PlaylistClickVo> likeplayclick = sqlSession.selectList("playlistclick.likelistclick", userNo);
		
		return likeplayclick;
	}
	
	public List<PlaylistClickVo> popularlistclick(){
		List<PlaylistClickVo> popularplayclick = sqlSession.selectList("playlistclick.popularplayclick");
		
		return popularplayclick;
	}
	
	//특정유저가 만든 리스트 출력
		public List<PlaylistClickVo> makelistclick(int userNo){
			
			List<PlaylistClickVo> makelistclick = sqlSession.selectList("playlistclick.makelistclick", userNo);
			
			return makelistclick;
		}

}

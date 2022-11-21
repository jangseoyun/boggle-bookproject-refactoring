package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PlaylistVo;

@Repository
public class PlaylistDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<PlaylistVo> likelist(int userNo){
		
		List<PlaylistVo> likeplay = sqlSession.selectList("playlist.likelist", userNo);
		System.out.println(likeplay);
		
		return likeplay;
	}
	
	//인기리스트출력
	public List<PlaylistVo> popularlist(){
		
		List<PlaylistVo> popularlist = sqlSession.selectList("playlist.popularplay");
		
		return popularlist;
	}
	
	//특정유저가 만든 리스트 출력
	public List<PlaylistVo> makelist(int userNo){
		
		List<PlaylistVo> makelist = sqlSession.selectList("playlist.makelist", userNo);
		
		return makelist;
	}
	
	
}

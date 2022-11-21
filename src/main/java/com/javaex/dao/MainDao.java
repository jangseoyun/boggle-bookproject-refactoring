package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MusicVo;
import com.javaex.vo.PlaylistVo;
import com.javaex.vo.ReviewVo;

@Repository
public class MainDao {

	@Autowired
	SqlSession sqlSession;
	
	public List<Map<String, Object>> getEmotion(){
		System.out.println("EmotionDao.getEmotion()");
		
		List<Map<String, Object>> list =  sqlSession.selectList("emotion.getEmotion");
		
		return list;
	}

	public List<Map<String, Object>> getReviewListByEmo(int emoNum) {
		System.out.println("EmotionDao.getReviewListByEmo()");
		
		List<Map<String, Object>> list =  sqlSession.selectList("emotion.getReviewListByEmo", emoNum);
		
		System.out.println("list sort by emoNo: " + list);
		
		return list;
	}
	
	public List<Map<String, Object>> getReviewListByPly(int playlistNo) {
		List<Map<String, Object>> list = sqlSession.selectList("emotion.getReviewListByPly", playlistNo);
		
		System.out.println("review list sort by playlistNo: " + list);
		
		return list;
	}
	
	
	public List<MusicVo> getMusicListByEmo(int emoNo) {
		System.out.println("EmotionDao.getMusicListByEmo()");
		
		List<MusicVo> list = sqlSession.selectList("emotion.getMusicListByEmo", emoNo);
		
		System.out.println("music list sort by emotion no: " + list);
		
		return list;
	}
	
	public List<MusicVo> getMusicListByPly(int playlistNo) {
		List<MusicVo> list = sqlSession.selectList("emotion.getMusicListByPly", playlistNo);
		
		System.out.println("playlist music list: " + list);
		
		return list;
	}
	
	public int getTotalEmotagCnt() {
		int result = sqlSession.selectOne("emotion.getTotalEmoTagCnt");
		
		System.out.println("***random emotag number: " + result);
		
		return result;
	}
	
	public List<PlaylistVo> getMyPlaylist(int userNo) {
		List<PlaylistVo> list = sqlSession.selectList("emotion.getMyPlaylist-1", userNo);
		
		System.out.println("내가 작성한 플리: " + list);
		
		return list;
	}
	
	public List<PlaylistVo> getMyPlaylistTwo(int userNo) {
		List<PlaylistVo> list = sqlSession.selectList("emotion.getMyPlaylist-2", userNo);
		
		System.out.println("내가 좋아요한 플리: " + list);
		
		return list;
	}
	
	public int addNewPlaylist(PlaylistVo pvo) {
		return sqlSession.insert("emotion.addNewPlaylist", pvo);
	}
	/*
	public int addNewPlaylistAtUser(PlaylistVo pvo) {
		return sqlSession.insert("emotion.addNewPlaylistAtUser", pvo);
	}
	*/
	public int addReviewToPly(Map<String, Object> map) {
		int result = sqlSession.insert("emotion.addReviewToPly", map);
		System.out.println(result + "건 : 리뷰를 플리에 저장");
		return result;
	}
	
	public int deleteReviewFromPly(Map<String, Object> map) {
		int result = sqlSession.delete("emotion.deleteReviewFromPly", map);
		System.out.println(result + "건 : 리뷰를 플리에서 삭제");
		return result;
	}
	
	public int alreadyAdded(Map<String, Object> map) {
		int result =  sqlSession.selectOne("emotion.alreadyAdded", map);
		
		return result;
	}
	
	public int alreadyLiked(Map<String, Object> reviewVo) {
		int result = sqlSession.selectOne("emotion.alreadyLiked", reviewVo);

		return result;
	}
	
	public int likeReview(ReviewVo reviewVo) {
		int result = sqlSession.insert("emotion.likeReview", reviewVo);
		
		System.out.println(result + "건  좋아요");
		
		return result;
	}
	
	public int cancelLike(ReviewVo reviewVo) {
		int result = sqlSession.delete("emotion.cancelLike", reviewVo);
		
		System.out.println(result + "건 좋아요 취소");
		
		return result;
	}
}
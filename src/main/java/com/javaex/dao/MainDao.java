package com.javaex.dao;

import com.javaex.dto.main.AddPlayListRequest;
import com.javaex.vo.MusicVo;
import com.javaex.vo.PlaylistVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Mapper
@Repository
public interface MainDao {
    List<Map<String, Object>> getEmotion();

	List<Map<String, Object>> getReviewListByEmo(Long emoNum);
    List<MusicVo> getMusicListByEmo(Long emoNo);

    List<Map<String, Object>> getReviewListByPly(Long playlistNo);

    List<MusicVo> getMusicListByPly(Long playlistNo);

    Long getTotalEmoTagCnt();

    Long alreadyLiked(Map<String, Object> reviewVo);

    List<PlaylistVo> getMyPlaylist(Long userNo);

    List<PlaylistVo> getLikeMyPlaylist(Long userNo);

    Long alreadyAdded(Map<String, Object> map);

    int addReviewToPly(Map<String, Object> map);

    int deleteReviewFromPly(Map<String, Object> map);

    int addNewPlaylist(AddPlayListRequest addPlayListRequest);

    int likeReview(Map<String, Object> map);

    int cancelLike(Map<String, Object> map);

	/*
	public int addNewPlaylistAtUser(PlaylistVo pvo) {
		return sqlSession.insert("emotion.addNewPlaylistAtUser", pvo);
	}
	*/

}
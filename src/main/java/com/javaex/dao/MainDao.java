package com.javaex.dao;

import com.javaex.dto.main.AddPlayListRequest;
import com.javaex.dto.playlist.MusicDTO;
import com.javaex.dto.playlist.PlaylistDTO;
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
    List<MusicDTO> getMusicListByEmo(Long emoNo);

    List<Map<String, Object>> getReviewListByPly(Long playlistNo);

    List<MusicDTO> getMusicListByPly(Long playlistNo);

    Long getTotalEmoTagCnt();

    Long alreadyLiked(Map<String, Object> reviewVo);

    List<PlaylistDTO> getMyPlaylist(Long userNo);

    List<PlaylistDTO> getLikeMyPlaylist(Long userNo);

    Long alreadyAdded(Map<String, Object> map);

    int addReviewToPly(Map<String, Object> map);

    int deleteReviewFromPly(Map<String, Object> map);

    int addNewPlaylist(AddPlayListRequest addPlayListRequest);

    int likeReview(Map<String, Object> map);

    int cancelLike(Map<String, Object> map);

    //int addNewPlaylistAtUser(PlaylistDTO pvo);

}

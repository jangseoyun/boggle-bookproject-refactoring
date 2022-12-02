package com.javaex.service;

import com.javaex.dao.MainDao;
import com.javaex.dto.main.AddPlayListRequest;
import com.javaex.dto.main.AddPlayListResponse;
import com.javaex.dto.main.MainReviewByEmoRequest;
import com.javaex.dto.main.ToggleReviewLikeResponse;
import com.javaex.vo.MusicVo;
import com.javaex.vo.PlaylistVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final MainDao mainDao;

    public List<Map<String, Object>> getEmotion() {
        return mainDao.getEmotion();
    }

    public Map<String, Object> getReviewListByEmo(MainReviewByEmoRequest mainReviewByEmoRequest) {
        log.info("getReviewListByEmo");

        List<Map<String, Object>> reviewList = new ArrayList<>();
        List<MusicVo> musicList = new ArrayList<>();

        if (mainReviewByEmoRequest.getEmoNo() != null) {//감정 태그 선택
            log.info("list sort by emotion");
            reviewList = mainDao.getReviewListByEmo(mainReviewByEmoRequest.getEmoNo());
            musicList = mainDao.getMusicListByEmo(mainReviewByEmoRequest.getEmoNo());
        } else if (mainReviewByEmoRequest.getPlaylistNo() != null) {//플레이리스트 재생
            log.info("list sort by playlist");
            reviewList = mainDao.getReviewListByPly(mainReviewByEmoRequest.getPlaylistNo());
            log.info("reviewList{}:", reviewList);
            musicList = mainDao.getMusicListByPly(mainReviewByEmoRequest.getPlaylistNo());
            log.info("musicList{}:", musicList);
        }

        if (reviewList.size() != 0) {
            for (Map<String, Object> reviewVo : reviewList) { // reviewVo, userNo
                reviewVo.put("userNo", mainReviewByEmoRequest.getUserNo());
                Long result = mainDao.alreadyLiked(reviewVo);
                System.out.println("좋아요 개수: " + result);
                reviewVo.put("alreadyLikedCnt", result);
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("reviewList", reviewList);
        map.put("musicList", musicList);

        return new HashMap<>();
    }

    public Map<String, Object> beforeLoginPlaylist() {
        // emoNo, playlistNo 둘 다 null인 경우 (userNo 존재 여부 상관없이) 메인 자동 재생
        List<Map<String, Object>> reviewList = new ArrayList<>();
        List<MusicVo> musicList = new ArrayList<>();

        log.info("default list sort by random");
        Long totalEmoTagCnt = mainDao.getTotalEmoTagCnt();
        reviewList = mainDao.getReviewListByEmo(totalEmoTagCnt);
        musicList = mainDao.getMusicListByEmo(totalEmoTagCnt);

        Map<String, Object> map = new HashMap<>();
        map.put("reviewList", reviewList);
        map.put("musicList", musicList);

        return map;
    }

    public List<PlaylistVo> getMyPlaylist(Long userNo) {
        List<PlaylistVo> playlist = mainDao.getMyPlaylist(userNo); // playlistNo, playlistName
        List<PlaylistVo> likeMyPlaylist = mainDao.getLikeMyPlaylist(userNo);

        List<PlaylistVo> myPlaylist = new ArrayList<>();
        myPlaylist.addAll(playlist);
        myPlaylist.addAll(likeMyPlaylist);

        return myPlaylist;
    }

    public List<Map<String, Object>> getMyPlaylistModal(Long userNo, Long reviewNo) { // userNo, reviewNo
        // 리스트 받기
        List<PlaylistVo> myPlaylist1 = mainDao.getMyPlaylist(userNo); // playlistNo, playlistName
        List<PlaylistVo> myPlaylist2 = mainDao.getLikeMyPlaylist(userNo);

        List<PlaylistVo> myPlaylist = new ArrayList<>();
        myPlaylist.addAll(myPlaylist1);
        myPlaylist.addAll(myPlaylist2);

        log.info("모달 > 플레이리스트:{}: ", myPlaylist);
        List<Map<String, Object>> modalPlaylist = new ArrayList<>();

        // 전에 저장했는지 여부 확인
        for (PlaylistVo pvo : myPlaylist) {
            //TODO : 객체로 만들기
            Map<String, Object> map = new HashMap<>();

            map.put("playlistNo", pvo.getPlaylistNo());
            map.put("playlistName", pvo.getPlaylistName());

            map.put("reviewNo", reviewNo);
            map.put("userNo", pvo.getUserNo());

            Long alreadyAdded = mainDao.alreadyAdded(map);
            map.put("cnt", alreadyAdded);

            modalPlaylist.add(map);
        }

        return modalPlaylist;
    }

    public Integer toggleReviewToPly(Map<String, Object> map) {
        Integer result = null;
        String btnIcon = String.valueOf(map.get("icon"));

        if (btnIcon.equals("fa-plus")) {
            log.info("리뷰 추가");
            result = mainDao.addReviewToPly(map);
        } else if (btnIcon.equals("fa-check")) {
            log.info("리뷰 삭제");
            result = mainDao.deleteReviewFromPly(map);
        }

        return result;
    }

    public AddPlayListResponse addNewPlaylist(AddPlayListRequest addPlayListRequest) {
        log.info("addNewPlaylist");
        int resultCode = mainDao.addNewPlaylist(addPlayListRequest);
        return new AddPlayListResponse(resultCode);
    }

    public ToggleReviewLikeResponse toggleReviewLike(Long userNo, Long reviewNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("reviewNo", reviewNo);
        map.put("userNo", userNo);
        map.put("review_user_no", null);

        Long alreadyLiked = mainDao.alreadyLiked(map);

        if (alreadyLiked == 0) { // 좋아요
            mainDao.likeReview(map);
        } else { // 좋아요 취소
            mainDao.cancelLike(map);
        }

        return new ToggleReviewLikeResponse(alreadyLiked);
    }
}

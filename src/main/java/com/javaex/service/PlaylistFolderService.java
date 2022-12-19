package com.javaex.service;

import com.javaex.dao.PlaylistFolderDao;
import com.javaex.dto.playlistFolder.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaylistFolderService { //TODO: 두잇 !
    private final PlaylistFolderDao playlistfolderDao;

    /*플레이리스트 폴더 클릭 -> 해당 플레이리스트 서평 리스트 + 페이징 */

    public PlaylistFolderResponse playlistReviewList(Long playlistNo, int crtPage) {
        log.info("playlistReviewList + paging");

        //★플레이리스트 커버-----------------
        PlaylistCoverDto playlistCoverResult = playlistfolderDao.playlistCover(playlistNo);

        // 서평 리스트+페이징
        // ★리스트 가져오기
        int listCnt = 5;
        //현재페이지 처리 0이하 접근 제한
        crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
        //페이지 시작글 번호
        int startRnum = (crtPage - 1) * listCnt + 1;
        //페이지 마지막글 번호
        int endRnum = (startRnum + listCnt) - 1;

        Map<String, Object> playlistData = new HashMap<>();
        playlistData.put("playlistNo", playlistNo);
        playlistData.put("startRnum", startRnum);
        playlistData.put("endRnum", endRnum);
        //rownum 리스트 요청
        List<PlaylistFolderVo> playList = playlistfolderDao.reviewList(playlistData);
        log.info("service: {}", playList);
        //2) ★페이지 카운트 가져오기-----------------
        //전체 글갯수 가져오기
        Long folderReviewCnt = playlistfolderDao.folderReviewCnt(playlistNo);
        log.info("folderReviewCnt: {}", folderReviewCnt);

        //페이지당 버튼 갯수
        int pageBtnCount = 5;

        //마지막 버튼 번호(올림해서 한 그룹에 동일한 값이 나오도록 만들어준다)
        int endPageBtnNo = (int) (Math.ceil(crtPage / (double) pageBtnCount)) * pageBtnCount;

        //시작 버튼 번호
        int startPageBtnNo = endPageBtnNo - (pageBtnCount - 1);

        //다음 화살표 유무
        boolean next = false;
        if (endPageBtnNo * listCnt < folderReviewCnt) {
            next = true;
        } else {//다음 화살표가 안보이면 마지막 버튼값을 다시 계산
            endPageBtnNo = (int) Math.ceil(folderReviewCnt / (double) listCnt);
        }

        //이전 화살표 유무
        boolean prev = false;
        if (startPageBtnNo != 1) {
            prev = true;
        }

        //3) ★포장---------------------------------
        PlaylistFolderResponse playlistFolderResponse = new PlaylistFolderResponse(prev, next, startPageBtnNo, endPageBtnNo, playList, playlistCoverResult);
        log.info("{}", playlistFolderResponse);

        return playlistFolderResponse;
    }

    /*플리 모달 페이징 */
 //TODO: paging 반복 메서드로 빼기
    public PlaylistFolderModalResponse madalListPage(int crtPage) {
        log.info("modalListPage");

        //★리스트 가져오기
        //페이지당 글 개수
        int listCnt = 5;

        //현재페이지 처리(0이하 접근 제한)
        crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);

        //페이지 시작글 번호
        int startRnum = (crtPage - 1) * listCnt + 1;
        //페이지 마지막 글 번호
        int endRnum = (startRnum + listCnt) - 1;

        Map<String, Integer> pageStartEndMap = new HashMap<>();
        pageStartEndMap.put("startRnum", startRnum);
        pageStartEndMap.put("endRnum", endRnum);
        //vo로 묶어서 보내주기
        List<PlaylistFolderVo> modalList = playlistfolderDao.madalListPage(pageStartEndMap);

        //2) ★페이지 카운트 가져오기-----------------
        //전체 글갯수 가져오기
        Long totalCnt = playlistfolderDao.totalCnt();
        log.info("totalCnt:{}", totalCnt);

        //페이지당 버튼 갯수
        int pageBtnCount = 5;

        //마지막 버튼 번호
        int endPageBtnNo = (int) (Math.ceil(crtPage / (double) pageBtnCount)) * pageBtnCount;

        //시작 버튼 번호
        int startPageBtnNo = endPageBtnNo - (pageBtnCount - 1);

        //다음 화살표 유무
        boolean next = false;
        if (endPageBtnNo * listCnt < totalCnt) {
            next = true;
        } else {//다음 화살표가 안보이면 마지막 버튼값을 다시 계산
            endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
        }

        //이전 화살표 유무
        boolean prev = false;
        if (startPageBtnNo != 1) {
            prev = true;
        }

        //3) ★포장---------------------------------
        PlaylistFolderModalResponse playlistFolderModalResponse = new PlaylistFolderModalResponse(prev, next, startPageBtnNo, endPageBtnNo, modalList);
        return playlistFolderModalResponse;

    }

/* 플리 검색 결과 가져오기*/

    public List<PlaylistFolderSearchDto> getSearchResult(String search) {
        return playlistfolderDao.playlistSearch(search);
    }

/* 선택 서평 등록하기*/

    public int reviewsInsert(Long playlistNo, List<Integer> reviewChkArr) {
        log.info("{}: reviewsInsert", playlistNo);
        int addList = 0;
        for (int i = 0; i < reviewChkArr.size(); i++) {//arr안에 선택한 reviewNo
            Map<String, Object> reviewInsertMap = new HashMap<>();
            reviewInsertMap.put("playlistNo", playlistNo);
            reviewInsertMap.put("reviewNo", reviewChkArr.get(i));//TODO: get 없을 때 예외처리
            addList = playlistfolderDao.reviewsInsert(reviewInsertMap);
            log.info("service 성공: {]", addList);
        }
        return addList;
    }

/* 서평 삭제*/

    public int reviewDelete(Long reviewNo) {
        return playlistfolderDao.reviewDelete(reviewNo);
    }

/* 로딩시 좋아요 체크*/

    public int checkLike(Long playlistNo, Long userNo) {
        Map<String, Long> likeMap = new HashMap<>();
        likeMap.put("playlistNo", playlistNo);
        likeMap.put("userNo", userNo);

        int checkLike = playlistfolderDao.checkLike(likeMap);
        return checkLike;
    }

    /* 해당 플리 좋아요 취소*/

    public int playlistUnlike(PlaylistLikeDto playlistLikeDto) {
        int unlikeResult = playlistfolderDao.playlistUnlike(playlistLikeDto);
        return unlikeResult;
    }

    public int playlistLike(PlaylistLikeDto playlistLikeDto) {
        log.info("playlistLike");
        return playlistfolderDao.playlistLike(playlistLikeDto);
    }

}

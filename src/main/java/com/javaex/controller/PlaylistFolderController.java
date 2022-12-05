package com.javaex.controller;

import com.javaex.dto.playlistFolder.PlaylistFolderModalResponse;
import com.javaex.dto.playlistFolder.PlaylistFolderResponse;
import com.javaex.dto.playlistFolder.PlaylistFolderSearchDto;
import com.javaex.dto.playlistFolder.PlaylistLikeDto;
import com.javaex.service.PlaylistFolderService;
import com.javaex.vo.PlaylistFolderVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle/playlist")
public class PlaylistFolderController {
    private final PlaylistFolderService playlistfolderService;

    /* 플레이리스트 폴더 클릭 -> 해당 플레이리스트 서평 리스트+페이징  */
    @GetMapping("/{playlist-no}/folder")
    public ResponseEntity<PlaylistFolderResponse> playlistFolder(@PathVariable("playlist-no") Long playlistNo,
                                                                 @RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {

        log.info("{} + paging : {}", playlistNo, crtPage);

        //플레이리스트 번호 받기
        //해당 폴더 서평리스트 가져오기(5개)
        PlaylistFolderResponse playlistFolderResponse = playlistfolderService.playlistReviewList(playlistNo, crtPage);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(playlistFolderResponse);
    }

    /* 플리 모달 페이징+리스트 */
    @GetMapping("/modal")
    public ResponseEntity<PlaylistFolderModalResponse> modalListPage(@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {
        log.info("modalListPage 요청 페이지: {}", crtPage);
        //해당페이지의 글 리스트 5개
        PlaylistFolderModalResponse playlistFolderModalResponse = playlistfolderService.madalListPage(crtPage);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(playlistFolderModalResponse);
    }

    /* 플리 모달 검색창 */
    @GetMapping("/review-search")
    public ResponseEntity<List<PlaylistFolderSearchDto>> reviewSearch(@RequestParam(value = "search") String searchTxt) {
        log.info("reviewSearch: {}", searchTxt);
        List<PlaylistFolderSearchDto> searchResult = playlistfolderService.getSearchResult(searchTxt);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(searchResult);
    }

    /* 플리 모달 추가 선택 등록 *///TODO
    @PutMapping("/{playlist-no}/reviews")
    public ResponseEntity addReviews(@PathVariable("playlist-no") Long playlistNo,
                                     @RequestBody List<Integer> reviewChkArr) {// reviewNo list
        log.info("선택한 서평:{}", reviewChkArr);
        int addResult = playlistfolderService.reviewsInsert(playlistNo, reviewChkArr);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("등록 성공");
    }

    /* 서평 삭제 */
    @DeleteMapping("/review/{review-no}")
    public int reviewRemove(@PathVariable("review-no") Long reviewNo) {
        log.info("{}: reviewDelete", reviewNo);
        int deleteResult = playlistfolderService.reviewDelete(reviewNo);
        return deleteResult;
    }

    /* 로딩시 플리 좋아요 체크 *///TODO: enum type 변경
    @GetMapping("{playlist-no}/like")
    public ResponseEntity checkLike(@PathVariable("playlist-no") Long playlistNo,
                         @RequestParam("user-no") Long userNo) {
        log.info("{}플리 checkLike, user: {}", playlistNo, userNo);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(playlistfolderService.checkLike(playlistNo, userNo));
    }

    /* 해당 플리 좋아요 취소 *///TODO: enum
    @DeleteMapping("/like")
    public ResponseEntity playlistUnlike(@RequestBody PlaylistLikeDto playlistLikeDto) {
        log.info("playlistUnlike {}", playlistLikeDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(playlistfolderService.playlistUnlike(playlistLikeDto));
    }

    /* 해당 플리 좋아요 */
    @PutMapping("/like")
    public ResponseEntity playlistLike(@RequestBody PlaylistLikeDto playlistLikeDto) {
        log.info("playlistLike {}", playlistLikeDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(playlistfolderService.playlistLike(playlistLikeDto));
    }

}

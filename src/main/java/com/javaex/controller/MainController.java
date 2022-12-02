package com.javaex.controller;

import com.javaex.dto.main.AddPlayListRequest;
import com.javaex.dto.main.AddPlayListResponse;
import com.javaex.dto.main.MainReviewByEmoRequest;
import com.javaex.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle/index")
public class MainController {

    private final MainService mainService;

    @GetMapping("")
    public String bookDetail() {
        log.info("메인 페이지 요청");
        return "main/main";
    }

    @GetMapping("/emotion")
    public ResponseEntity<List<Map<String, Object>>> getEmotion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainService.getEmotion());
    }

    /*메인 서평 플레이*/
    @GetMapping("/play")
    public ResponseEntity getReviewListByEmo(@RequestBody MainReviewByEmoRequest mainReviewByEmoRequest) {
        log.info("reuqest: {}", mainReviewByEmoRequest);
        //TODO : 하나로 보내줄 수 있도록  service에서 처리
        if (mainReviewByEmoRequest.getPlaylistNo() == null && mainReviewByEmoRequest.getEmoNo() == null) {
            // emoNo, playlistNo 둘 다 null인 경우 (userNo 존재 여부 상관없이) 메인 자동 재생
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mainService.beforeLoginPlaylist());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainService.getReviewListByEmo(mainReviewByEmoRequest));
    }

    @GetMapping("{user-no}/playlist")
    public ResponseEntity getMyPlaylist(@PathVariable(value = "user-no") Long userNo) {
        log.info("getMyPlaylist");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainService.getMyPlaylist(userNo));
    }

    @GetMapping("{user-no}/playlist-modal")//TODO: 로직 이해 필요
    public ResponseEntity getMyPlaylistModal(@PathVariable("user-no") Long userNo
                                            , @RequestParam("review-no") Long reviewNo) {
        log.info("getMyPlaylistModal");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainService.getMyPlaylistModal(userNo, reviewNo));
    }

	@PostMapping("/toggleReviewToPly")//update, delete
	public Integer toggleReviewToPly(@RequestBody Map<String, Object> map) {
		log.info("toggleReviewToPly");
		return mainService.toggleReviewToPly(map);
	}

    @PutMapping("/playlist")
    public ResponseEntity<AddPlayListResponse> addNewPlaylist(@RequestBody AddPlayListRequest addPlayListRequest) {
        log.info("addNewPlaylist : {}", addPlayListRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainService.addNewPlaylist(addPlayListRequest));
    }

    @PutMapping("{user-no}/toggle-review-like")
    public ResponseEntity toggleReviewLike(@PathVariable("user-no") Long userNo
                                         , @RequestParam("review-no") Long reviewNo) {
        log.info("toggleReviewLike");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mainService.toggleReviewLike(userNo, reviewNo));
    }

	@GetMapping("{no}/playlist")
	public String playlist(@PathVariable("no") Long playlistNo) {
		log.info("playlist");
		return "main/main";
	}
}
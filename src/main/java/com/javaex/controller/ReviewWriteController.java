package com.javaex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dto.reviewwrite.EmotionStyleResponse;
import com.javaex.dto.reviewwrite.ReviewAddRequest;
import com.javaex.dto.reviewwrite.ReviewAddResponse;
import com.javaex.dto.reviewwrite.ReviewModifyRequest;
import com.javaex.dto.user.UserDto;
import com.javaex.service.MainService;
import com.javaex.service.ReviewWriteService;
import com.javaex.service.UserService;
import com.javaex.util.HttpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle/review")
public class ReviewWriteController {
    private final ReviewWriteService reviewWriteService;
    private final UserService userService;

    private final MainService mainService;

    @GetMapping("/search-book")
    public String searchBook(@RequestParam String query,
                             @RequestParam(value = "crtPage", required = false, defaultValue = "1") String crtPage) throws IOException {
        log.info("searchBook()");

        // API
        String key = "ttbmay-primavera1830001";

        HashMap<String, Object> result = new HttpUtil()
                .url("http://www.aladin.co.kr/ttb/api/ItemSearch.aspx")
                .method("get")
                .queryString("TTBKey", key)
                .queryString("query", query)
                .queryString("output", "js")
                .queryString("MaxResults", "4")
                .queryString("Start", crtPage)
                .build();

        String jsonStr = result.get("body").toString();
        jsonStr = jsonStr.substring(0, jsonStr.length() - 1);

        Object status = result.get("status");
        Object header = result.get("header");

        // review total cnt ????????????
        JSONObject jsonObj = new JSONObject(jsonStr);
        JSONArray items = jsonObj.getJSONArray("item");
        List<Object> list = reviewWriteService.addReviewTotalCnt(items);

        // json --> java data type
        ObjectMapper objectMapper = new ObjectMapper();

        // ?????????
        // ????????? ??? ?????? ??????
        int pageBtnCnt = 5;

        // ????????? ?????? ??????
        int endBtnNo = (int) (Math.ceil(Integer.parseInt(crtPage) / (double) pageBtnCnt)) * pageBtnCnt;

        // ?????? ?????? ??????
        int startBtnNo = endBtnNo - (pageBtnCnt - 1);

        // mapping
        Map<String, Object> map = new HashMap<>();
        map.put("endBtnNo", endBtnNo);
        map.put("startBtnNo", startBtnNo);
        map.put("list", list);

        String str = objectMapper.writeValueAsString(map);
        return str;
    }

    @GetMapping("/style/{emotion-no}")
    public ResponseEntity<EmotionStyleResponse> getStyle(@PathVariable(value = "emotion-no") Long emoNo) {
        log.info("getStyle");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reviewWriteService.getStyle(emoNo));
    }

    @PostMapping("")//TODO: return ?????? int??? ?????? ReviewAddResponse ??????
    public ResponseEntity<ReviewAddResponse> addReview(@RequestBody ReviewAddRequest reviewAddRequest,
                                                       Authentication authentication) {
        log.info("reviewRequest: {}", reviewAddRequest);
        log.info("addReview user: {} ", authentication.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reviewWriteService.addReview(reviewAddRequest));
    }

    @GetMapping("/book")
    public List<Map<String, Object>> getBookInfo(@RequestParam(value = "book-title") String bookTitle) throws JsonProcessingException {
        log.info("getBookInfo bookTitle: {}", bookTitle);
        return reviewWriteService.getBookInfo(bookTitle);
    }

    @GetMapping("/{review-no}")
    public Map<String, Object> getPrevReviewInfo(@PathVariable(value = "review-no") Long reviewNo) {
        log.info("getPrevReviewInfo reviewNo:{}", reviewNo);
        return reviewWriteService.getPrevReviewInfo(reviewNo);
    }

    @PutMapping("")
    public Map<String, String> modifyReview(@RequestBody ReviewModifyRequest reviewModifyRequest,
                                            Authentication authentication) {
        log.info("modifyReview : {}", reviewModifyRequest);
        int result = reviewWriteService.checkReviewWriter(reviewModifyRequest.getReviewNo(), reviewModifyRequest.getUserNo());

        log.info("????????? review??? userNo??? ???????????????: {} ", result);

        String getUserEmail = authentication.getName();
        UserDto getUser = userService.findByUserEmail(getUserEmail);

        String redirect = null;
        if (result == 0) { // ???????????? ?????? ????????? ??????????????? ??? ??????
            redirect = "user/loginForm";
        } else { // ??????
            int result2 = reviewWriteService.modifyReview(reviewModifyRequest);

            if (result2 == 1) {
                redirect = getUser.getNickname();
            }
        }

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("redirect", redirect);

        return resultMap;
    }

    /* ???????????? (?????? ????????????????????? ?????? ??????), ??? ??????, ?????????, ???????????????, ???????????? ??? */
	/*@GetMapping("/my-playlist")
	public List<PlaylistVo> getMyPlaylist(Authentication authentication) {
		log.info("getMyPlaylist");
        String getUserEmail = authentication.getName();
        //email??? user ????????????
        Long userNo = userService.findByUserEmail(getUserEmail).getUserNo();
		return mainService.getMyPlaylist(userNo);
	}*/


	@PutMapping("/{playlist-no}/playlist")//?????? ????????????????????? ??????
	public int addReviewToPly(@PathVariable("playlist-no")Long playlistNo,
			                   @RequestParam(value="review-no") Long reviewNo) {
		log.info("addReviewToPly");

		Map<String, Object> map = new HashMap<>();
		map.put("playlistNo", playlistNo);
		map.put("reviewNo", reviewNo);
		return mainService.addReviewToPly(map);
	}
}

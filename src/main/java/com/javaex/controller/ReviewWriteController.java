package com.javaex.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dto.reviewwrite.EmotionStyleResponse;
import com.javaex.dto.reviewwrite.ReviewAddRequest;
import com.javaex.dto.reviewwrite.ReviewAddResponse;
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

        // review total cnt 추가하기
        JSONObject jsonObj = new JSONObject(jsonStr);
        JSONArray items = jsonObj.getJSONArray("item");
        List<Object> list = reviewWriteService.addReviewTotalCnt(items);

        // json --> java data type
        ObjectMapper objectMapper = new ObjectMapper();

        // 페이징
        // 페이지 당 버튼 개수
        int pageBtnCnt = 5;

        // 마지막 버튼 번호
        int endBtnNo = (int) (Math.ceil(Integer.parseInt(crtPage) / (double) pageBtnCnt)) * pageBtnCnt;

        // 시작 버튼 번호
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

    @PostMapping("")//TODO: return 타입 int로 받음 ReviewAddResponse 수정
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

    /*@PutMapping("")
    public Map<String, String> modifyReview(@RequestBody ReviewModifyRequest reviewModifyRequest,
                                            Authentication authentication) {
        log.info("modifyReview : {}", reviewModifyRequest);
        int result = reviewWriteService.checkReviewWriter(reviewModifyRequest.getReviewNo(), reviewModifyRequest.getUserNo());

        log.info("수정한 review를 userNo가 작성했는지: {} ", result);

        String getUserEmail = authentication.getName();
        UserDto getUser = userService.findByUserEmail(getUserEmail);

        String redirect = null;
        if (result == 0) { // 작성자가 남의 서평을 수정하려고 할 경우
            redirect = "user/loginForm";
        } else { // 수정
            int result2 = reviewWriteService.modifyReview(reviewModifyRequest);

            if (result2 == 1) {
                redirect = getUser.getNickname();
            }
        }

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("redirect", redirect);

        return resultMap;
    }*/

    /* 서평쓰기 (서평 플레이리스트에 추가 모달), 내 서재, 남서재, 상세페이지, 취향저격 홈 */
	/*@ResponseBody
	@RequestMapping("/getMyPlaylist")
	public List<PlaylistVo> getMyPlaylist(HttpSession session) {
		System.out.println("ReviewWriterController > getMyPlaylist");
		int userNo = ((UserVo) session.getAttribute("authUser")).getUserNo();
		return mainDao.getMyPlaylist(userNo);
	}
	
	@ResponseBody
	@RequestMapping("/addReviewToPly")
	public int addReviewToPly(@RequestParam(value="playlistNo")int playlistNo, 
			                   @RequestParam(value="reviewNo") int reviewNo) {
		System.out.println("ReviewWriterController > addReviewToPly");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("playlistNo", playlistNo);
		map.put("reviewNo", reviewNo);
		
		return mainDao.addReviewToPly(map);
	}*/
}

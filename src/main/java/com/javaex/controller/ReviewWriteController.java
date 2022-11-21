package com.javaex.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaex.dao.MainDao;
import com.javaex.dao.ReviewWriteDao;
import com.javaex.service.ReviewWriteService;
import com.javaex.util.HttpUtil;
import com.javaex.vo.PlaylistVo;
import com.javaex.vo.StyleVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/review")
public class ReviewWriteController {

	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	ReviewWriteDao reviewWriteDao;
	@Autowired
	MainDao mainDao;
	
	@RequestMapping("/write")
   public String review_write() {
      System.out.println("write");
      
      return "review_write/review_write";
   }
	
	
	@ResponseBody
	@RequestMapping(value="/searchbook", method = {RequestMethod.GET, RequestMethod.POST}, produces="applicatioin/json;charset=UTF-8")
	public String searchbook(@RequestParam String query, 
							 @RequestParam(value="crtPage", required=false, defaultValue="1") String crtPage) throws IOException {
		System.out.println("ReviewWriteController > searchbook()");
		
		///////////////////////
		// API
		///////////////////////
		
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
		
		///////////////////////
		// review total cnt 추가하기
		///////////////////////
		
		JSONObject jsonObj = new JSONObject(jsonStr);
		
		JSONArray items = jsonObj.getJSONArray("item");

		List<Object> list = reviewWriteService.addReviewTotalCnt(items);
		
		///////////////////////////////
		// json --> java data type
		///////////////////////////////

		ObjectMapper objectMapper = new ObjectMapper();

		///////////////////////
		// 페이징
		///////////////////////
		
		// 페이지 당 버튼 개수
		int pageBtnCnt = 5;
		
		// 마지막 버튼 번호
		int endBtnNo = (int) (Math.ceil(Integer.parseInt(crtPage) / (double)pageBtnCnt)) * pageBtnCnt;
		
		// 시작 버튼 번호
		int startBtnNo = endBtnNo - (pageBtnCnt - 1);		
		
		///////////////////////
		// mapping
		///////////////////////
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("endBtnNo", endBtnNo);
		map.put("startBtnNo", startBtnNo);
		map.put("list", list);
		
		String str = objectMapper.writeValueAsString(map);
		
		return str;
	}

	@ResponseBody
	@RequestMapping("/getStyle")
	public List<StyleVo> getStyle(@RequestParam(value="emoNo") int emoNo) {
		System.out.println("ReviewWriteController > getStyle");
		
		return reviewWriteService.getStyle(emoNo);
	}
	
	@ResponseBody
	@RequestMapping("/addReview")
	public Map<String, String> addReview(@RequestBody Map<String, Object> map,
							HttpSession session) throws JsonProcessingException {
		System.out.println("ReviewWriteController > addReview");
	
		System.out.println(map);
 
		reviewWriteService.addReview(map);

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		String redirect;
		
		if(authUser == null) {
			redirect = "user/loginForm";
		} else {
			redirect = authUser.getNickname();
		}

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("redirect", redirect);
		resultMap.put("reviewNo", String.valueOf(map.get("reviewNo")) );
		
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/getBookInfo")
	public List<Map<String, Object>> getBookInfo(@RequestParam(value="bookTitle") String bookTitle) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("ReviewWriteController > getBookInfo");
		
		System.out.println("bookTitle: "+bookTitle);
		
		return reviewWriteService.getBookInfo(bookTitle);
	}
	
	@ResponseBody
	@RequestMapping("/getPrevReviewInfo")
	public Map<String, Object> getPrevReviewInfo(@RequestParam(value="reviewNo") int reviewNo) {
		System.out.println("ReviewWriteController > getPrevReviewInfo");
		
		System.out.println("reviewNo: " + reviewNo);
		
		return reviewWriteService.getPrevReviewInfo(reviewNo);
	}
	
	@ResponseBody
	@RequestMapping("/modifyReview")
	public Map<String, String> modifyReview(@RequestBody Map<String, Object> map,
											HttpSession session) {
		System.out.println("ReviewWriteController > modifyReview");
		
		System.out.println("요청에서 받은 값: " + map);
		//{bookNo=9791166686603, bookTitle=다섯 번째 감각, author=김보영, bookURL=https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=287367114, genreNo=1, coverURL=https://image.aladin.co.kr/product/28736/71/cover500/k442836780_1.jpg, userNo=6, styleNo=5, reviewContent=세상은 원래부터 기괴하고 무섭고 아름답고 당황스러웠다. 그동안 우리는 두꺼운 습관의 담요를 뒤집어 쓰고 이를 무시하고 있었을 뿐이다. 그리고 김보영의 단편들을 읽는 것은 그 담요를 은근슬적 떨구는 과정이다. , genreName=소설/시/희곡, reviewNo=3}

		int result = reviewWriteDao.checkReviewWriter(map);
		
		System.out.println("수정한 review를 userNo가 작성했는지: " + result);
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		
		String redirect = null;
		
		if(result == 0) { // 작성자가 남의 서평을 수정하려고 할 경우
			redirect =  "user/loginForm";
		}
		else { // 수정
			int result2 = reviewWriteService.modifyReview(map);
			
			if(result2 == 1) {
				redirect = authUser.getNickname();
			}
		}
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("redirect", redirect);
		
		return resultMap;
	}
	
	/* 서평쓰기 (서평 플레이리스트에 추가 모달), 내 서재, 남서재, 상세페이지, 취향저격 홈 */
	@ResponseBody
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
	}
}

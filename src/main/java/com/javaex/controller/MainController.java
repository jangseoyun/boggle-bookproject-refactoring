package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.MainService;
import com.javaex.vo.PlaylistVo;
import com.javaex.vo.ReviewVo;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@RequestMapping("")
	public String bookDetail() {
		System.out.println("main");
		
		return "main/main";
	}

	@ResponseBody
	@RequestMapping("/getemotion")
	public List<Map<String, Object>> getEmotion() {
		System.out.println("MainController > getEmotion()");
		
		return mainService.getEmotion();
	}
	
	@ResponseBody
	@RequestMapping("/reviewmusiclist") 
	public Map<String, Object> getReviewListByEmo(@RequestParam(value="emoNo", required=false) String emoNo,
												  @RequestParam(value="playlistNo", required=false) Integer playlistNo,
												  @RequestParam(value="userNo", required=false) String userNo) {
		System.out.println("MainController > getReviewList()");

		System.out.println("--userNo: " + userNo);
		System.out.println("--emoNo: " + emoNo);
		System.out.println("--plyNo: " + playlistNo);

		if(emoNo == null) {
			emoNo = "null";
		}
		
		Integer emoNoInt = null;
		if( !"null".equals(emoNo) ) {
			System.out.println("감정 분류 리스트 불러오겠습니다.");
			emoNoInt = Integer.parseInt(emoNo);
		}

		Integer userNoInt = null;
		if( !userNo.equals("undefined") && !userNo.equals("null") ) {
			System.out.println("로그인 상태");
			userNoInt = Integer.parseInt(userNo);
		} 

		return mainService.getReviewListByEmo(userNoInt, emoNoInt, playlistNo);
		
	}
	
	@ResponseBody
	@RequestMapping("/getMyPlaylist")
	public List<PlaylistVo> getMyPlaylist(@RequestParam(value="userNo") int userNo) {
		System.out.println("MainController > getMyPlaylist");
		
		return mainService.getMyPlaylist(userNo);
	}
	
	@ResponseBody
	@RequestMapping("/getMyPlaylistModal")
	public List<Map<String, Object>> getMyPlaylistModal(@RequestBody ReviewVo reviewVo) { 
		System.out.println("MainController > getMyPlaylistModal");
		
		List<Map<String, Object>> modalPlaylist = mainService.getMyPlaylistModal(reviewVo);
		return modalPlaylist;
	}
	
	@ResponseBody
	@RequestMapping("/toggleReviewToPly")
	public Integer toggleReviewToPly(@RequestBody Map<String, Object> map) {
		System.out.println("MainController > toggleReviewToPly");
		
		return mainService.toggleReviewToPly(map);
	}
	
	@ResponseBody
	@RequestMapping("/addNewPlaylist")
	public int addNewPlaylist(@RequestBody PlaylistVo pvo) { // userNo, playlistName, emoNo
		System.out.println("MainController > addNewPlaylist" + pvo);
		
		return mainService.addNewPlaylist(pvo);
	}
	
	@ResponseBody
	@RequestMapping("/toggleReviewLike")	
	public Map<String, String> toggleReviewLike(@RequestBody ReviewVo reviewVo) { // reviewNo, userNo
		System.out.println("MainController > toggleReviewLike");
		
		String result = mainService.toggleReviewLike(reviewVo);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		
		return map;
	}

	@RequestMapping("/playlist")
	public String playlist(@RequestParam(value="playlistNo") int playlistNo) {
		System.out.println("MainController > playlist");

		return "main/main";
	}
}
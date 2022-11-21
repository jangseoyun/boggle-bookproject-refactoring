package com.javaex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MainDao;
import com.javaex.vo.MusicVo;
import com.javaex.vo.PlaylistVo;
import com.javaex.vo.ReviewVo;

@Service
public class MainService {

	@Autowired
	MainDao emoDao;
	
	public List<Map<String, Object>> getEmotion(){
		System.out.println("MainService > getEmotion()");
		
		return emoDao.getEmotion();
	}
	
	public Map<String, Object> getReviewListByEmo(Integer userNo, Integer emoNo, Integer playlistNo) {
		System.out.println("MainService.getReviewList()");

		List<Map<String, Object>> reviewList = new ArrayList<Map<String, Object>>();
		List<MusicVo> musicList = new ArrayList<MusicVo>();
		
		if(emoNo != null) {
			System.out.println("list sort by emotion");
			
			reviewList = emoDao.getReviewListByEmo(emoNo);
			musicList = emoDao.getMusicListByEmo(emoNo);
		}
		else if(playlistNo != null) {
			System.out.println("list sort by playlist");
			
			reviewList = emoDao.getReviewListByPly(playlistNo);
			musicList = emoDao.getMusicListByPly(playlistNo);
		} else { 	// emoNo, playlistNo 둘 다 null인 경우 (userNo 존재 여부 상관없이)
			System.out.println("default list sort by random");
			
			int totalEmotagCnt = emoDao.getTotalEmotagCnt();
			
			//int randomEmoNo = (int) Math.ceil(Math.random() * totalEmotagCnt);
			
			//System.out.println("***random emotion number: " + totalEmotagCnt);
			
			reviewList = emoDao.getReviewListByEmo(totalEmotagCnt);
			musicList = emoDao.getMusicListByEmo(totalEmotagCnt);
		}

		if(userNo != null) { // 로그인 상태라면 하트 카운트 값 받기
			
			System.out.println("서평 총 수: " + reviewList.size());

			if(reviewList.size() != 0) {
				for(Map<String, Object> reviewVo : reviewList) { // reviewVo, userNo

					reviewVo.put("userNo", userNo);
				
					int result = emoDao.alreadyLiked(reviewVo);
					
					System.out.println("좋아요 개수: " + result);
					
					reviewVo.put("alreadyLikedCnt", result);
				}
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewList", reviewList);
		map.put("musicList", musicList);
		
		return map;
	}
	
	public List<PlaylistVo> getMyPlaylist(int userNo) {
		System.out.println("MainService.getMyPlaylist()");
		
		//List<PlaylistVo> myPlaylist = emoDao.getMyPlaylist(userNo);

		List<PlaylistVo> myPlaylist1 = emoDao.getMyPlaylist(userNo); // playlistNo, playlistName
		List<PlaylistVo> myPlaylist2 = emoDao.getMyPlaylistTwo(userNo);
		
		List<PlaylistVo> myPlaylist = new ArrayList<>();
		myPlaylist.addAll(myPlaylist1);
		myPlaylist.addAll(myPlaylist2);
		
		return myPlaylist;
	}
	
	public List<Map<String, Object>> getMyPlaylistModal(ReviewVo reviewVo) { // userNo, reviewNo
		System.out.println("MainService.getMyPlaylistModal()");
		
		// 리스트 받기
		List<PlaylistVo> myPlaylist1 = emoDao.getMyPlaylist(reviewVo.getUserNo()); // playlistNo, playlistName
		List<PlaylistVo> myPlaylist2 = emoDao.getMyPlaylistTwo(reviewVo.getUserNo());
		
		List<PlaylistVo> myPlaylist = new ArrayList<>();
		myPlaylist.addAll(myPlaylist1);
		myPlaylist.addAll(myPlaylist2);
		
		System.out.println("모달 > 플레이리스트: " + myPlaylist);
		
		List<Map<String, Object>> modalPlaylist = new ArrayList<Map<String, Object>>();
		
		// 전에 저장했는지 여부 확인
		for(PlaylistVo pvo : myPlaylist) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("playlistNo", pvo.getPlaylistNo());
			map.put("playlistName", pvo.getPlaylistName());
			
			map.put("reviewNo", reviewVo.getReviewNo());
			map.put("userNo", pvo.getUserNo());
						
			int alreadyAdded = emoDao.alreadyAdded(map);

			map.put("cnt", alreadyAdded);

			modalPlaylist.add(map);
			
		}
		
		return modalPlaylist;
	}
	
	public int addNewPlaylist(PlaylistVo pvo) {
		System.out.println("MainService > addNewPlaylist");
		
		return emoDao.addNewPlaylist(pvo);
	}
	
	public Integer toggleReviewToPly(Map<String, Object> map) {
		
		Integer result = null;
		
		String btnIcon = String.valueOf( map.get("icon"));
		
		if(btnIcon.equals("fa-plus")) {
			System.out.println("리뷰 추가");
			
			result = emoDao.addReviewToPly(map);
		} else if(btnIcon.equals("fa-check")){
			System.out.println("리뷰 삭제");
			
			result = emoDao.deleteReviewFromPly(map);
		}
		
		return result;
		
	}
	
	public String toggleReviewLike(ReviewVo reviewVo) {
		
		String result;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewNo", reviewVo.getReviewNo());
		map.put("userNo", reviewVo.getUserNo());
		
		int alreadyLiked = emoDao.alreadyLiked(map);
		
		if(alreadyLiked == 0) { // 좋아요
			emoDao.likeReview(reviewVo);
			result = "좋아요";
		} else { // 좋아요 취소
			emoDao.cancelLike(reviewVo);
			result = "좋아요 취소";
		}
		
		return result;
	}
}

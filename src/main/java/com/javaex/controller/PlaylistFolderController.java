package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.PlaylistFolderService;
import com.javaex.vo.PlaylistFolderVo;

@Controller
@RequestMapping("/playlist")
public class PlaylistFolderController {
	
	@Autowired
	private PlaylistFolderService playlistfolderService;
	
	/* 플레이리스트 폴더 클릭 -> 해당 플레이리스트 서평 리스트+페이징  */
	@RequestMapping("/folder")
	public String playlistFolder(@RequestParam("playlistNo") int playlistNo,
								 @RequestParam("userNo") int userNo,
								 @RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage,
								 Model model) {
		
		System.out.println("Controller.playlistFolder+paging");
		System.out.println(playlistNo);
		System.out.println("요청 페이지:"+crtPage);

		//플레이리스트 번호 받기
		//해당 폴더 서평리스트 가져오기(5개)
		Map<String, Object> foldermainMap = playlistfolderService.playlistReviewList(playlistNo,userNo,crtPage);
		System.out.println("controller: "+foldermainMap);
		
		//데이터 보내기
		model.addAttribute("foldermainMap",foldermainMap);
		
		return "taste/click-playlist";
		
	}
	
	/* 플리 모달 페이징+리스트 */
	@ResponseBody
	@RequestMapping("/modalListPage")
	public Map<String, Object> modalListPage(@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {
		
		System.out.println("Controller.modalListPage");
		System.out.println(crtPage);
		
		//해당페이지의 글 리스트 5개
		Map<String, Object> playlistMap = playlistfolderService.madalListPage(crtPage);
		System.out.println(playlistMap);

		return playlistMap;
	}
	
	
	/* 플리 모달 검색창 */
	@ResponseBody
	@RequestMapping("/reviewSearch")
	public List<PlaylistFolderVo> reviewSearch(@RequestParam(value="SearchTxt") String searchTxt ) {
		
		System.out.println("Controller.reviewSearch");
		System.out.println(searchTxt);
		
		List<PlaylistFolderVo> searchResult = playlistfolderService.getSearchResult(searchTxt);
		System.out.println("컨트롤러:"+searchResult);
		
		return searchResult;
	}
	
	/* 플리 모달 추가 선택 등록 */
	@RequestMapping("/addReviews")
	public @ResponseBody int addReviews(@ModelAttribute PlaylistFolderVo playlistFolderVo, 
										   @RequestParam("userNo") int userNo,
										   @RequestParam (value="reviewChkBoxArr[]") List<Integer> reviewChkBoxArr) {
											
		System.out.println("Controller.배열");
		System.out.println(playlistFolderVo);
		System.out.println(reviewChkBoxArr);

		int addResult = playlistfolderService.reviewsInsert(playlistFolderVo, reviewChkBoxArr);
		
		return addResult;
	
	}
	
	/* 서평 삭제 */
	@ResponseBody
	@RequestMapping("/reviewDelete")
	public int reviewRemove(@RequestParam("reviewNo") int reviewNo) {
		
		System.out.println("Controller.reviewDelete");
		System.out.println(reviewNo);
		
		int deleteResult = playlistfolderService.reviewDelete(reviewNo);
		
		return deleteResult;
		
	}
	
	/* 로딩시 플리 좋아요 체크 */
	@ResponseBody
	@RequestMapping("/checkLike")
	public int checkLike(@ModelAttribute PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Controller.checkLike");
		System.out.println(playlistFolderVo);
		
		int checkLike = playlistfolderService.checkLike(playlistFolderVo);
		
		return checkLike;
	}
	
	/* 해당 플리 좋아요 취소 */
	@ResponseBody
	@RequestMapping("/playlistUnlike")
	public int playlistUnlike(@ModelAttribute PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Controller.playlistUnlike");
		int unlikeResult = playlistfolderService.playlistUnlike(playlistFolderVo);
		
		return unlikeResult;
	}
	
	/* 해당 플리 좋아요 */
	@ResponseBody
	@RequestMapping("/addplaylistLike")
	public int addplaylistLike(@ModelAttribute PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Controller.addplaylistLike");
		int likeResult = playlistfolderService.playlistlike(playlistFolderVo);
		
		return likeResult;
	}

}

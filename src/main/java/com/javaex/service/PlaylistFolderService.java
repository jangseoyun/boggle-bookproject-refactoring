package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PlaylistFolderDao;
import com.javaex.vo.PlaylistFolderVo;

@Service
public class PlaylistFolderService {
	
	@Autowired
	private PlaylistFolderDao playlistfolderDao;
	
	/* 플레이리스트 폴더 클릭 -> 해당 플레이리스트 서평 리스트 + 페이징 */
	public Map<String, Object> playlistReviewList(int playlistNo, int userNo, int crtPage) {
		
		System.out.println("Service.playlistReviewList+paging");
		
		//★플레이리스트 커버-----------------
		PlaylistFolderVo playlistCover = playlistfolderDao.playlistCover(playlistNo,userNo);
		System.out.println("Service.playlistCover");
		
		// 서평 리스트+페이징
		// ★리스트 가져오기
		int listCnt = 5;
		//현재페이지 처리 0이하 접근 제한
		crtPage = (crtPage>0) ? crtPage : (crtPage=1);
		//페이지 시작글 번호
		int startRnum = (crtPage-1)*listCnt +1;
		System.out.println("startRnum"+startRnum);
		//페이지 마지막글 번호
		int endRnum = (startRnum + listCnt) -1;
		System.out.println("endRnum"+endRnum);
		//rownum 리스트 요청
		List<PlaylistFolderVo> playList = playlistfolderDao.playlistReviewList(playlistNo,startRnum,endRnum);
		System.out.println("service:"+playList);
		//2) ★페이지 카운트 가져오기-----------------
		//전체 글갯수 가져오기
		int folderReviewCnt = playlistfolderDao.folderReviewTotal(playlistNo);
		System.out.println("folderReviewCnt:"+folderReviewCnt);
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 버튼 번호(올림해서 한 그룹에 동일한 값이 나오도록 만들어준다)
		int endPageBtnNo = (int)(Math.ceil( crtPage/(double)pageBtnCount))*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo = endPageBtnNo - (pageBtnCount-1); 
		
		//다음 화살표 유무
		boolean next = false;
		if(endPageBtnNo*listCnt < folderReviewCnt) {
			next = true;
		}else {//다음 화살표가 안보이면 마지막 버튼값을 다시 계산
			endPageBtnNo = (int)Math.ceil(folderReviewCnt/(double)listCnt);
		}
		
		//이전 화살표 유무
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		//3) ★포장---------------------------------
		Map<String,Object> playlistPage = new HashMap<String,Object>();
		playlistPage.put("prev", prev);
		playlistPage.put("startPageBtnNo", startPageBtnNo);
		playlistPage.put("endPageBtnNo", endPageBtnNo);
		playlistPage.put("next", next);
		playlistPage.put("playList", playList);
		playlistPage.put("playlistCover", playlistCover);
		
		System.out.println(playlistPage);

		return playlistPage;
		
	}

	/* 플리 모달 페이징 */
	public Map<String,Object> madalListPage(int crtPage) {
		
		System.out.println("Service.modalListPage");
		
		
		//★리스트 가져오기
		//페이지당 글 개수
		int listCnt = 5;
		
		//현재페이지 처리(0이하 접근 제한)
		crtPage = (crtPage>0) ? crtPage : (crtPage=1);
		
		//페이지 시작글 번호
		int startRnum = (crtPage-1)*listCnt +1;
		//페이지 마지막 글 번호
		int endRnum = (startRnum + listCnt) -1;
		//vo로 묶어서 보내주기
		List<PlaylistFolderVo> modalList = playlistfolderDao.madalListPage(startRnum,endRnum);
		
		//2) ★페이지 카운트 가져오기-----------------
		//전체 글갯수 가져오기
		int totalCnt = playlistfolderDao.selectTotal();
		System.out.println("totalCnt:"+totalCnt);
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 버튼 번호
		int endPageBtnNo = (int)(Math.ceil( crtPage/(double)pageBtnCount))*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo = endPageBtnNo - (pageBtnCount-1);
		
		//다음 화살표 유무
		boolean next = false;
		if(endPageBtnNo*listCnt < totalCnt) {
			next = true;
		}else {//다음 화살표가 안보이면 마지막 버튼값을 다시 계산
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt);
		}
		
		//이전 화살표 유무
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		//3) ★포장---------------------------------
		Map<String,Object> playlistMap = new HashMap<String,Object>();
		playlistMap.put("prev", prev);
		playlistMap.put("startPageBtnNo", startPageBtnNo);
		playlistMap.put("endPageBtnNo", endPageBtnNo);
		playlistMap.put("next", next);
		playlistMap.put("modalList", modalList);
		
		return playlistMap;

	}
	
	/* 플리 검색 결과 가져오기 */
	public List<PlaylistFolderVo> getSearchResult(String search) {
		
		System.out.println("Service.getSearchResult");
		
		List<PlaylistFolderVo> searchResult = playlistfolderDao.getSearchResult(search);
		
		return searchResult;
	}
	
	/* 선택 서평 등록하기 */
	public int reviewsInsert( PlaylistFolderVo playlistFolderVo,  List<Integer> reviewChkBoxArr) {
		
		System.out.println("Service.reviewsInsert");
		
		int addList = 0;
		
		for(int i=0; i<reviewChkBoxArr.size(); i++) {
			playlistFolderVo.setReviewNo(reviewChkBoxArr.get(i));
			System.out.println(playlistFolderVo);
			
			addList = playlistfolderDao.reviewsInsert(playlistFolderVo);
			System.out.println("service 성공:"+addList);
		}
		
		return addList;
	}
	
	/* 서평 삭제 */
	public int reviewDelete(int reviewNo) {
		System.out.println("Service.reviewDelete");
		int deleteResult = playlistfolderDao.reviewDelete(reviewNo);		
		return deleteResult;
	}
	
	/* 로딩시 좋아요 체크 */
	public int checkLike(PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Service.checkLike");
		int checkLike = playlistfolderDao.checkLike(playlistFolderVo);
		
		return checkLike;
	}
	
	/* 해당 플리 좋아요 취소 */
	public int playlistUnlike(PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Service.playlistUnlike");
		int unlikeResult = playlistfolderDao.playlistUnlike(playlistFolderVo);
		
		return unlikeResult;
		
	}
	
	public int playlistlike(PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Service.playlistlike");
		int likeResult = playlistfolderDao.playlistlike(playlistFolderVo);
		
		return likeResult;
	}

}

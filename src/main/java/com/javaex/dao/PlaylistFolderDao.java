package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PlaylistFolderVo;

@Repository
public class PlaylistFolderDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	/* 플레이리스트 폴더 클릭 -> 해당 플레이리스트 서평 리스트  */
	public List<PlaylistFolderVo> playlistReviewList(int playlistNo,int startRnum, int endRnum) {
		
		System.out.println("Dao.playlistReviewList");
		
		//map 
		Map<String, Object> playlistData = new HashMap<String, Object>();
		playlistData.put("playlistNo", playlistNo);
		playlistData.put("startRnum", startRnum);
		playlistData.put("endRnum", endRnum);
		
		//서평리스트
		List<PlaylistFolderVo> playList = sqlSession.selectList("playlistFolder.reviewList",playlistData);
		System.out.println("dao:"+playList);

		return playList;
		
	}
	
	/* 해당 플리(folder) 총 서평 수  */
	public int folderReviewTotal(int playlistNo) {
		System.out.println("Dao.folderReviewTotal");
		int folderReviewCnt = sqlSession.selectOne("playlistFolder.folderReviewCnt",playlistNo);
		System.out.println(folderReviewCnt);
		return folderReviewCnt;
	}

	/* 플레이리스트 커버 */
	
	  public PlaylistFolderVo playlistCover(int playlistNo, int userNo) {
	  
	  System.out.println("Dao.playlistCover");
	  
	  Map<String, Integer> playlist = new HashMap<String, Integer>();
	  playlist.put("playlistNo", playlistNo); 
	  playlist.put("userNo", userNo);
	  
	  //playlistCover 
	  PlaylistFolderVo playlistCover = sqlSession.selectOne("playlistFolder.playlistCover",playlist);
	  System.out.println(playlistCover);

	  return playlistCover;
	  
	  }

	/* 플리 모달 페이징 */
	public List<PlaylistFolderVo> madalListPage(int startRnum, int endRnum) {
		
		System.out.println("Dao.modalPage");
		System.out.println(startRnum+","+endRnum);
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		List<PlaylistFolderVo> playlistPage = sqlSession.selectList("playlistFolder.modalPage",map);
		System.out.println(playlistPage);
		
		return playlistPage;
	}
	
	/* 전체 글갯수 가져오기 */
	public int selectTotal() {
		System.out.println("Dao.selectTotal");
		int totalCnt = sqlSession.selectOne("playlistFolder.totalCnt");
		return totalCnt;
		
	}
	
	/* 플리 검색 결과 가져오기 */
	public List<PlaylistFolderVo> getSearchResult(String search) {
		
		System.out.println("Dao.getSearchResult");
		List<PlaylistFolderVo> searchResult = sqlSession.selectList("playlistFolder.playlistSearch",search);
		
		System.out.println("검색 결과 : "+searchResult);
		
		return searchResult;
	}
	
	/* 선택 서평 등록하기 */
	public int reviewsInsert(PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Dao.reviewsInsert");
		int addVo = sqlSession.insert("playlistFolder.reviewsInsert",playlistFolderVo);
		System.out.println("등록 성공:"+addVo);
		
		return addVo;
	}
	
	/* 서평 삭제 */
	public int reviewDelete(int reviewNo) {
		
		System.out.println("Dao.reviewDelete");
		
		int deleteResult = sqlSession.delete("playlistFolder.reviewDelete",reviewNo);
		System.out.println("삭제 성공 여부:"+deleteResult);
		return deleteResult;
		
	}
	
	/* 로딩시 좋아요 체크 */
	public int checkLike(PlaylistFolderVo playlistFolderVo) {	
		
		System.out.println("Dao.checkLike");
		int checkLike = sqlSession.selectOne("playlistFolder.checkLike",playlistFolderVo);
		System.out.println("좋아요 체크:"+checkLike);
		
		return checkLike;
		
	}
	
	/* 해당 플리 좋아요 취소 */
	public int playlistUnlike(PlaylistFolderVo playlistFolderVo) {
		
		System.out.println("Dao.playlistUnlike");
		int unlikeResult = sqlSession.delete("playlistFolder.playlistUnlike",playlistFolderVo);
		System.out.println("좋아요 취소:"+unlikeResult);
		
		return unlikeResult;
		
	}
	
	/* 해당 플리 좋아요 */
	public int playlistlike(PlaylistFolderVo playlistFolderVo) {
		System.out.println("Dao.playlistlike");
		int likeResult = sqlSession.insert("playlistFolder.playlistlike",playlistFolderVo);
		System.out.println("플리 좋아요:"+likeResult);
		
		return likeResult;
	}
	
	
	
}

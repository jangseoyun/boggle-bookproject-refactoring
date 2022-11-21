package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.LikeReviewDao;
import com.javaex.vo.LikeReviewVo;
import com.javaex.vo.MybookVo;

@Service
public class LikeReviewService {

	@Autowired
	private LikeReviewDao likeReviewDao;

//	/* 해당 유저가 좋아요한 서평 리스트 */
//	public List<LikeReviewVo> getlist(int userNo) {
//		System.out.println("Service.getLikeReviewList");
//
//		List<LikeReviewVo> lrList = likeReviewDao.getlist(userNo);
//		return lrList;
//	}
	
	//유저번호 입력시 해당유저 서평리스트 출력해주는 메소드
	public List<LikeReviewVo> list(int userNo){
		
		List<LikeReviewVo> lrList = likeReviewDao.getlist(userNo);
		
		return lrList;
	}
	
	
	//좋아요 여부 확인
		public int likeok(LikeReviewVo checklike) {
			//System.out.println("mybookService.likeok()");

			int count = likeReviewDao.checklike(checklike);

			return count;
		}
		
		//좋아요 확인, 좋아요 몇개인지 확인하는 메소드
		public LikeReviewVo likecnt(LikeReviewVo checklike) {
			//System.out.println("mybookService.likeok()");
			
			//좋아요 여부 확인
			int count = likeReviewDao.checklike(checklike);
			
			//좋아요 몇개인지 확인
			LikeReviewVo likeok = likeReviewDao.checklikecnt(checklike);
			
			//두개를 Vo에 넣기
			likeok.setLikecheck(count);		
			
			System.out.println(likeok);
			
			return likeok;
		}
		
		//좋아요를 하는 메소드(review_user에 인서트)
		public void like(LikeReviewVo checklike) {
			
			//현재+1
			likeReviewDao.like(checklike);
		}
		
		//좋아요 취소하는 메소드(review_user에서 삭제)
		public void dislike(LikeReviewVo checklike) {
			
			likeReviewDao.dislike(checklike);
		}
		
		//유저넘버 입력시 해당유저가 가장 최근에 좋아요한 서평가져오기
		public List<LikeReviewVo> likereview(int userNo) {
			
			List<LikeReviewVo> likereview = likeReviewDao.likereview(userNo);
			
			return likereview;
		}
		
		//해당유저 넘버를 주면 좋아요한 서평리스트를 출력하는 메소드+해당유저의 서평 총 갯수 출력
		public List<LikeReviewVo> likelist(int userNo) {
			
			List<LikeReviewVo> likelist = likeReviewDao.likelist(userNo);
			
			for(int i=0; i<likelist.size(); i++) {
				
				int No = likelist.get(i).getUserNo();
				
				LikeReviewVo reviewcnt = likeReviewDao.reviewcnt(No);
				int rvcnt = reviewcnt.getLikecheck();
				
				likelist.get(i).setLikecheck(rvcnt);
			}
			
			System.out.println("좋아요한유저서평들"+likelist);
			
			return likelist;
		}
	
	
	//서평 삭제 메소드
	//해당 유저의 넘버와 리뷰넘버를 주면 삭제하는 메소드
		public int delete(LikeReviewVo delete) {
			
			//리뷰넘버정보를 주면 해당 리뷰를 쓴 유저 정보를 줌
			int reviewNo = delete.getReviewNo();
			LikeReviewVo checkuser = likeReviewDao.checkuser(reviewNo);
			
			int reviewerNo = checkuser.getUserNo();
			int userNo = delete.getUserNo();
			
			System.out.println("리뷰쓴유저넘버 : "+reviewerNo);
			System.out.println("세션유저넘버 : "+userNo);
			
			//그 유저넘버가 지금 세션 유저넘버(받아온값)와 같을때 삭제
			if(reviewerNo == userNo) {
				//삭제, 1은 로그인사용자와 삭제하려는 리뷰작성자가 같음을 의미
				likeReviewDao.delete(delete);
				
				return 1;
			}else {
				//삭제불가, 0은 로그인사용자와 삭제하려는 리뷰작성자가 다름을 의미
				 return 0;
			}
		}

		

}
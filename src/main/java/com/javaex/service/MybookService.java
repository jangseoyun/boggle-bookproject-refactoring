package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.MybookDao;
import com.javaex.vo.MybookVo;

@Repository
public class MybookService {
	
	//필드
	@Autowired
	private  MybookDao mybookDao;
	
	//유저번호 입력시 해당유저 서평리스트 출력해주는 메소드
	public List<MybookVo> list(int userNo){
		System.out.println("mybookService.list()");
		
		List<MybookVo> mbList = mybookDao.getList(userNo);
		
		return mbList;
	}
	
	//유저번호 입력시 해당유저 서평리스트 출력해주는 메소드(최신순)
	public List<MybookVo> popularlist(int userNo){
		System.out.println("mybookService.popularlist()");
		
		List<MybookVo> mbList = mybookDao.getPopular(userNo);
		
		return mbList;
	}
	
	
	//좋아요 여부 확인
	public int likeok(MybookVo checklike) {
		//System.out.println("mybookService.likeok()");

		int count = mybookDao.checklike(checklike);

		return count;
	}
	
	
	//좋아요 확인, 좋아요 몇개인지 확인하는 메소드
	public MybookVo likecnt(MybookVo checklike) {
		//System.out.println("mybookService.likeok()");
		
		//좋아요 여부 확인
		int count = mybookDao.checklike(checklike);
		
		//좋아요 몇개인지 확인
		MybookVo likeok = mybookDao.checklikecnt(checklike);
		
		//두개를 Vo에 넣기
		likeok.setLikecheck(count);		
		
		System.out.println(likeok);
		
		return likeok;
	}
	
	//좋아요를 하는 메소드(review_user에 인서트)
	public void like(MybookVo checklike) {
		System.out.println("mybookService.like()");
		
		//현재+1
		mybookDao.like(checklike);
	}
	
	//좋아요 취소하는 메소드(review_user에서 삭제)
	public void dislike(MybookVo checklike) {
		System.out.println("mybookService.dislike()");
		
		mybookDao.dislike(checklike);
	}
	
	//유저넘버 입력시 해당유저가 가장 최근에 좋아요한 서평가져오기
	public List<MybookVo> likereview(int userNo) {
		System.out.println("mybookService.likereview");
		
		List<MybookVo> likereview = mybookDao.likereview(userNo);
		
		return likereview;
	}
	
	//해당유저 넘버를 주면 좋아요한 서평리스트를 출력하는 메소드+해당유저의 서평 총 갯수 출력
	public List<MybookVo> likelist(int userNo) {
		System.out.println("mybookService.likelist");
		
		List<MybookVo> likelist = mybookDao.likelist(userNo);
		
		for(int i=0; i<likelist.size(); i++) {

			int No = likelist.get(i).getUserNo();
			
			MybookVo reviewcnt = mybookDao.reviewcnt(No);
			int rvcnt = reviewcnt.getLikecheck();
			
			likelist.get(i).setLikecheck(rvcnt);
		}
		
		System.out.println("좋아요한유저서평들"+likelist);
		
		return likelist;
	}
	
	//해당 유저의 넘버와 리뷰넘버를 주면 삭제하는 메소드
	public int delete(MybookVo wannadelete) {
		
		//리뷰넘버정보를 주면 해당 리뷰를 쓴 유저 정보를 줌
		int reviewNo = wannadelete.getReviewNo();
		MybookVo checkuser = mybookDao.checkuser(reviewNo);

		int reviewerNo = checkuser.getUserNo();
		int userNo = wannadelete.getUserNo();
		
		System.out.println("리뷰쓴유저넘버 : "+reviewerNo);
		System.out.println("세션유저넘버 : "+userNo);
		
		//그 유저넘버가 지금 세션 유저넘버(받아온값)와 같을때 삭제
		if(reviewerNo == userNo) {
			//삭제, 1은 로그인사용자와 삭제하려는 리뷰작성자가 같음을 의미
			mybookDao.delete(reviewNo);
			
			return 1;
		}else {
			//삭제불가, 0은 로그인사용자와 삭제하려는 리뷰작성자가 다름을 의미
			 return 0;
		}
	}
	
	//해당 유저넘버, 감정태그 받으면 그 리스트만 출력
	public List<MybookVo> emoList(MybookVo emo){
		System.out.println("mybookService.emoList");
		
		List<MybookVo> emoList = mybookDao.emoList(emo);
		
		return emoList;	
	}
	
	
	
}

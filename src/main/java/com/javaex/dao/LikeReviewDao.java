package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.LikeReviewVo;
import com.javaex.vo.MybookVo;

@Repository
public class LikeReviewDao {

	@Autowired
	private SqlSession sqlSession;

	/* 해당 서평 리스트 가져오기 */
	public List<LikeReviewVo> getlist(int userNo) {

		List<LikeReviewVo> lrList = sqlSession.selectList("likereview.getLRlist", userNo);
		System.out.println(lrList);
		return lrList;
	}

	// 유저넘버 입력시 해당유저가 가장 최근에 좋아요한 서평가져오기
	public List<LikeReviewVo> likereview(int userNo) {

		List<LikeReviewVo> likereview = sqlSession.selectList("likereview.like1", userNo);

		return likereview;
	}

	// 유저넘버 입력시 해당유저가 가장 최근에 좋아요한 서평 유저목록
	public List<LikeReviewVo> likelist(int userNo) {

		List<LikeReviewVo> likelist = sqlSession.selectList("likereview.likelist", userNo);

		return likelist;
	}

	// 리뷰 넘버 -> 유저 넘버
	public LikeReviewVo checkuser(int reviewNo) {

		LikeReviewVo checkuser = sqlSession.selectOne("likereview.checkuser", reviewNo);

		return checkuser;
	}

	public int checklike(LikeReviewVo checklike) {
		// System.out.println("MybookDao.checklike()");

		List<LikeReviewVo> likecount = sqlSession.selectList("likereview.checklike", checklike);
		int count = likecount.size();

		// System.out.println(count+"건 조회됨");

		return count;
	}

	public LikeReviewVo checklikecnt(LikeReviewVo checklike) {
		// System.out.println("MybookDao.checklike()");

		// 좋아요 몇개인지 담아서 보냄
		LikeReviewVo likecnt = sqlSession.selectOne("likereview.checklikecnt", checklike);

		System.out.println("Dao좋아요갯수" + likecnt);

		return likecnt;
	}

	public void like(LikeReviewVo checklike) {

		int count = sqlSession.insert("likereview.like", checklike);
		System.out.println(count + "건을 좋아요하였습니다.");
	}

	public void dislike(LikeReviewVo checklike) {

		int count = sqlSession.delete("likereview.dislike", checklike);
		System.out.println(count + "건을 좋아요 취소하였습니다.");
	}

	// 서평 삭제
	// 리뷰넘버정보를 주면 해당 리뷰 삭제
	public void delete(LikeReviewVo delete) {

		sqlSession.delete("likereview.delete", delete);
	}

	// 유저넘버 입력시 해당 유저의 총 서평갯수
	public LikeReviewVo reviewcnt(int userNo) {

		LikeReviewVo reviewcnt = sqlSession.selectOne("likereview.reviewcnt", userNo);

		return reviewcnt;
	}

}
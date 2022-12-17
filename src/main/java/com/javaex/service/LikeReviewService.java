package com.javaex.service;

import com.javaex.dao.LikeReviewDao;
import com.javaex.dto.likeReviews.DeleteResult;
import com.javaex.dto.likeReviews.LatestLikeReviewsDto;
import com.javaex.dto.likeReviews.ReviewLikeTotalCountResult;
import com.javaex.dto.mybook.LikeStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeReviewService {

    private final LikeReviewDao likeReviewDao;

    //유저넘버 입력시 해당유저가 가장 최근에 좋아요한 서평가져오기
    public List<LatestLikeReviewsDto> getLatestLikeReviews(Long userNo) {
        List<LatestLikeReviewsDto> latestLikeReviewsResult = likeReviewDao.latestLikeReviews(userNo);
        // 중복체크 및 값 set해서 List 업데이트, 지금 로그인한 유저
        for (LatestLikeReviewsDto likeReview : latestLikeReviewsResult) {
            Map<String, Long> reviewNoAndUserNo = new HashMap<>();
            reviewNoAndUserNo.put("reviewNo", likeReview.getReviewNo());
            reviewNoAndUserNo.put("userNo", userNo);
            LikeStatus likeStatus = checkReviewLike(reviewNoAndUserNo);//reviewNo, userNo
            likeReview.setLikeStatus(likeStatus);
        }
        return latestLikeReviewsResult;
    }

    //좋아요 여부
    private LikeStatus checkReviewLike(Map<String, Long> reviewNoAndUserNo) {
        Long checkLikeResult = likeReviewDao.checkReviewLike(reviewNoAndUserNo);//userNo, reviewNo
        if (checkLikeResult == 1) {
            return LikeStatus.LIKE;
        } else {
            return LikeStatus.UNLIKE;
        }
    }

    //서평 삭제 메소드
    //해당 유저의 넘버와 리뷰넘버를 주면 삭제하는 메소드
    public DeleteResult deleteByReviewNo(Long deleteReviewNo, Long deleteRequestUserNo) {
        //리뷰넘버정보를 주면 해당 리뷰를 쓴 유저 정보를 줌
        Map<String, Long> reviewByUserInfo = likeReviewDao.checkReviewByUser(deleteReviewNo);
        log.info("리뷰 쓴 유저넘버:{}, 로그인 유저넘버:{}, 삭제할 리뷰 번호:{}", reviewByUserInfo.get("userNo"), deleteRequestUserNo, deleteReviewNo);

        //그 유저넘버가 지금 세션 유저넘버(받아온값)와 같을때 삭제
        if (reviewByUserInfo.get("userNo") == deleteRequestUserNo) {
            //삭제, 1은 로그인사용자와 삭제하려는 리뷰작성자가 같음을 의미
            Long deleteResult = likeReviewDao.deleteByReviewNo(deleteReviewNo);
            if (deleteResult == 1) {//TODO: 메서드 정리 및 빼기
                return DeleteResult.DELETE_SUCCESS;
            } else {
                return DeleteResult.DELETE_FAIL;
            }
        } else {
            return DeleteResult.NOT_REVIEWER;
        }
    }

    //좋아요 확인, 좋아요 몇개인지 확인하는 메소드
    public ReviewLikeTotalCountResult likeCount(Long reviewNo, Long userNo) {
        //좋아요 여부 확인
        Map<String, Long> reviewNoAndUserNo = new HashMap<>();
        reviewNoAndUserNo.put("reviewNo", reviewNo);
        reviewNoAndUserNo.put("userNo", userNo);

        //loginUser reviewNo-like 여부 체크
        Long checkReviewLike = likeReviewDao.checkReviewLike(reviewNoAndUserNo);

        //좋아요 몇개인지 확인
        ReviewLikeTotalCountResult reviewLikeTotalCountResult = likeReviewDao.checkLikeTotalCount(reviewNo);

        //두개를 Vo에 넣기
        reviewLikeTotalCountResult.setCheckLike(checkReviewLike);

        return reviewLikeTotalCountResult;
    }

    public LikeStatus likeOrDisLike(Long reviewNo, Long loginUserNo, LikeStatus likeStatus) {
        Map<String, Long> reviewNoAndUserNo = new HashMap<>();
        reviewNoAndUserNo.put("reviewNo", reviewNo);
        reviewNoAndUserNo.put("userNo", loginUserNo);
        reviewNoAndUserNo.put("reviewUserNo", null);

        // 좋아요를 안한경우
        if (likeStatus.equals(LikeStatus.UNLIKE)) {//0
            // review_user table like insert
            return like(reviewNoAndUserNo);
        } else {
            // review_user에서 삭제
            return dislike(reviewNoAndUserNo);
        }
    }

    //좋아요를 하는 메소드(review_user에 인서트)
    private LikeStatus like(Map<String, Long> reviewNoAndUserNo) {
        log.info("{} 번 서평 좋아요 요청", reviewNoAndUserNo.get("reviewNo"));
        //현재+1
        int reviewLikeResult = likeReviewDao.reviewLike(reviewNoAndUserNo);
        if (reviewLikeResult == 1) {
            return LikeStatus.LIKE;
        } else {
            return LikeStatus.LIKE_FAIL;
        }
    }

    //좋아요 취소하는 메소드(review_user에서 삭제)
    private LikeStatus dislike(Map<String, Long> reviewNoAndUserNo) {
        log.info("{} 번 서평 좋아요 삭제 요청", reviewNoAndUserNo.get("reviewNo"));
        int reviewDislike = likeReviewDao.reviewDislike(reviewNoAndUserNo);
        if (reviewDislike == 1) {
            return LikeStatus.UNLIKE;
        } else {
            return LikeStatus.UNLIKE_FAIL;
        }
    }

}
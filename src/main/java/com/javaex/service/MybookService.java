package com.javaex.service;

import com.javaex.dao.MybookDao;
import com.javaex.dto.mybook.*;
import com.javaex.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MybookService {

    private final MybookDao mybookDao;
    private final UserService userService;

    /*서재 접근 유저 정보*/
    public UserDto accessMybook(String nickname) {
        //결과 string, userNo, nickname, 프로필 이미지
        return userService.findByUserEmail(nickname);
    }

    /*서평 최신순 리스트 조회*/
    public List<UserReviewsResponse> getUserReviews(Long userNo) {
        log.info("getUserReviews");
        List<UserReviewDTO> userBookReviews = mybookDao.getUserReviews(userNo);
        return createReviewsResponse(userBookReviews, userNo);
    }

    /*서평 인기순 리스트 조회*/
    public List<UserReviewsResponse> getPopularReviews(Long userNo) {
        log.info("getPopularReviews");
        List<UserReviewDTO> popularReviews = mybookDao.getPopularReviews(userNo);
        return createReviewsResponse(popularReviews, userNo);
    }

    //좋아요 확인, 좋아요 몇개인지 확인하는 메소드
    public LikeCountResponse likeCount(Long reviewNo, Long userNo) {
        Map<String, Long> likeCountMap = new HashMap<>();
        likeCountMap.put("reviewNo", reviewNo);
        likeCountMap.put("userNo", userNo);

        //좋아요 여부 확인
        Long likeResultNo = mybookDao.checkLike(likeCountMap);
        //좋아요 몇개인지 확인
        LikeCountResponse likeCountResult = mybookDao.getLikeCount(reviewNo);

        //두개를 Vo에 넣기
        likeCountResult.setLikeCheck(likeResultNo);
        return likeCountResult;
    }

    private List<UserReviewsResponse> createReviewsResponse(List<UserReviewDTO> reviews, Long userNo) {
        List<UserReviewsResponse> reviewsResponseList = new ArrayList<>();
        //중복체크 및 값 set해서 List 업데이트, 지금 로그인한 유저
        for (UserReviewDTO review : reviews) {
            Long reviewNo = review.getUserNo();
            LikeStatus likeStatus = checkLike(reviewNo, userNo);
            reviewsResponseList.add(MybookFactory.of(review, likeStatus));
        }
        return reviewsResponseList;
    }

    //좋아요 여부 확인
    private LikeStatus checkLike(Long reviewNo, Long userNo) {
        Map<String, Long> checkLikeMap = new HashMap<>();
        checkLikeMap.put("reviewNo", reviewNo);
        checkLikeMap.put("userNo", userNo);

        Long resultNo = mybookDao.checkLike(checkLikeMap);
        if (resultNo == 1) {
            return LikeStatus.LIKE;
        } else {
            return LikeStatus.UNLIKE;
        }
    }

    //좋아요를 하는 메소드(review_user에 인서트)
    public LikeStatus like(Long reviewNo, Long userNo) {
        log.info("like");
        //현재+1
        LikeDTO likeDto = MybookFactory.getLikeDto(reviewNo, userNo);
        Long insertResult = mybookDao.insertLike(likeDto);
        //TODO: 예외처리하기
        if (insertResult == 1) {
            return LikeStatus.LIKE;
        } else {
            return LikeStatus.UNLIKE;
        }
    }

    //좋아요 취소하는 메소드(review_user에서 삭제)
    public LikeStatus unLike(Long reviewNo, Long userNo) {
        log.info("unLike");
        Map<String, Long> deleteLikeMap = new HashMap<>();
        deleteLikeMap.put("reviewNo", reviewNo);
        deleteLikeMap.put("userNo", userNo);
        Long deleteResult = mybookDao.deleteLike(deleteLikeMap);
        if (deleteResult == 1) {
            return LikeStatus.UNLIKE;
        } else {
            return LikeStatus.LIKE;
        }
    }

    //해당 유저의 넘버와 리뷰넘버를 주면 삭제하는 메소드
    public Long deleteReview(Long reviewNo) {
        //리뷰넘버정보를 주면 해당 리뷰를 쓴 유저 정보를 줌
        Map<String, Long> reviewNoAndUserNoMap = mybookDao.reviewByUser(reviewNo);
        log.info("review:{} by:{} ", reviewNoAndUserNoMap.get("reviewNo"), reviewNoAndUserNoMap.get("userNo"));

        //그 유저넘버가 지금 세션 유저넘버(받아온값)와 같을때 삭제
        if(reviewNoAndUserNoMap.get("reviewNo") == reviewNoAndUserNoMap.get("userNo")) {
            //삭제, 1은 로그인사용자와 삭제하려는 리뷰작성자가 같음을 의미
            Long deleteResult = mybookDao.reviewDelete(reviewNo);
            return deleteResult;
        }else {
            //삭제불가, 0은 로그인사용자와 삭제하려는 리뷰작성자가 다름을 의미
            return 0L;
        }
    }

    //해당 유저넘버, 감정태그 받으면 그 리스트만 출력
    public List<EmotionListResponse> emoList(String emoName, Long userNo){
        log.info("emoList");

        Map<String, Object> emoNameAndUserNoMap = new HashMap<>();
        emoNameAndUserNoMap.put("emoName", emoName);
        emoNameAndUserNoMap.put("userNo", userNo);

        List<EmotionListResponse> emotionListResponse = mybookDao.emoList(emoNameAndUserNoMap);
        return getEmotionList(emotionListResponse, userNo);
    }

    private List<EmotionListResponse> getEmotionList(List<EmotionListResponse> emotionListResponse, Long userNo) {
        for (EmotionListResponse emotionResponse : emotionListResponse) {
            LikeStatus likeStatus = checkLike(emotionResponse.getReviewNo(), userNo);
            emotionResponse.setLikeStatus(likeStatus);
        }
        return emotionListResponse;
    }
}

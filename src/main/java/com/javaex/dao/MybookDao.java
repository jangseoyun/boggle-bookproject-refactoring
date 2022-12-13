package com.javaex.dao;

import com.javaex.dto.mybook.EmotionListResponse;
import com.javaex.dto.mybook.LikeCountResponse;
import com.javaex.dto.mybook.LikeDTO;
import com.javaex.dto.mybook.UserReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Mapper
@Repository
public interface MybookDao {

    List<UserReviewDTO> getUserReviews(Long userNo);

    Long checkLike(Map<String, Long> reviewNoAndUserNo);

    List<UserReviewDTO> getPopularReviews(Long userNo);

    /*좋아요 개수*/
    LikeCountResponse getLikeCount(Long reviewNo);

    Long insertLike(LikeDTO likeDTO); //userNo reviewNo

    Long deleteLike(Map<String, Long> reviewNoAndUserNo);

    //리뷰넘버정보를 주면 해당 리뷰를 쓴 유저 정보를 줌
    Map<String, Long> reviewByUser(Long reviewNo);

    //리뷰넘버정보를 주면 해당 리뷰 삭제
    Long reviewDelete(Long reviewNo);

    //해당 유저넘버, 감정태그 받으면 그 리스트만 출력
    List<EmotionListResponse> emoList(Map<String, Object> emoNameAndUserNo);

}

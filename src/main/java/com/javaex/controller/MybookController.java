package com.javaex.controller;

import com.javaex.dto.mybook.EmotionListResponse;
import com.javaex.dto.mybook.LikeCountResponse;
import com.javaex.dto.mybook.LikeStatus;
import com.javaex.dto.mybook.UserReviewsResponse;
import com.javaex.dto.user.UserDto;
import com.javaex.service.MybookService;
import com.javaex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/boggle/library")
public class MybookController {
    private final MybookService mybookService;
    private final UserService userService;

    //내서재
    @GetMapping("/{nickname}")
    public ResponseEntity<UserDto> myReview(@PathVariable("nickname") String nicknameParam
            , Authentication authentication) {
        log.info("myReview");
        //로그인한 유저의 닉네임
        String email = authentication.getName();
        UserDto byUserEmail = userService.findByUserEmail(email);
        String loginNickname = byUserEmail.getNickname();

        log.info("로그인사람의 닉네임 : " + loginNickname);
        log.info("지금 서재 닉네임 : " + nicknameParam);

        //인증 닉네임, 접속한 서재 닉네임 비교
        UserDto userResult;
        if (nicknameParam.equals(loginNickname)) {//로그인한 유저 정보
            //결과 string, userNo, nickname, 프로필 이미지
            userResult = mybookService.accessMybook(loginNickname);
            //"mybook/mybook_review";

        } else {
            log.info("anotherUser");
            //결과 string, userNo, nickname, 프로필 이미지
            userResult = mybookService.accessMybook(nicknameParam);
            //"mybook/otherbook_review";
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResult);
    }

    //리스트 출력 기능
    //@ResponseBody
    @GetMapping("/{user-no}/list")
    public List<UserReviewsResponse> mybookList(@PathVariable(value = "user-no") Long userNoParam
            , Authentication authentication
            , @RequestParam("sort") String sort) {
        log.info("mybookList");
        String email = authentication.getName();
        UserDto loginUser = userService.findByUserEmail(email);

        //세션의 닉네임
        //TODO: service sort만 보내기
        if (sort.equals("latest")) {//최신순 정렬
            //로그인 유저와 접속한 서재 비교
            if (userNoParam == loginUser.getUserNo()) {//접속한 유저 == 서재 유저
                //세션아이디의 유저넘버
                Long loginUserNo = loginUser.getUserNo();

                //서평리스트출력
                //유저넘버를 주면 해당 유저가 작성한 리뷰를 불러오는 메소드
                log.info("유저넘버: {}", loginUserNo);
                List<UserReviewsResponse> userReviews = mybookService.getUserReviews(loginUserNo);
                return userReviews;
            } else {
                //다른 유저
                return mybookService.getUserReviews(userNoParam);
            }
        } else {//인기순 정렬
            //로그인 유저와 접속한 서재 비교
            if (userNoParam == loginUser.getUserNo()) {
                //세션아이디의 유저넘버
                Long loginUserNo = loginUser.getUserNo();
                log.info("유저넘버: {}", loginUserNo);

                //유저넘버를 주면 해당 유저가 작성한 리뷰를 불러오는 메소드
                List<UserReviewsResponse> popularReviews = mybookService.getPopularReviews(loginUserNo);
                return popularReviews;
            } else {
                return mybookService.getPopularReviews(userNoParam);
            }
        }
    }

    //좋아요버튼을 눌렀을때의 기능
    @PostMapping("{review-no}/like")
    public LikeStatus like(@PathVariable("review-no") Long reviewNo, Authentication authentication) {
        //세션아이디의 유저넘버
        String email = authentication.getName();
        UserDto loginUser = userService.findByUserEmail(email);
        log.info("로그인한 유저 넘버{}, 클릭한 서평{}", loginUser.getUserNo(), reviewNo);

        //해당유저가 좋아요를 했는지 안했는지, 좋아요가 몇갠지 불러오기.
        LikeCountResponse likeCountResponse = mybookService.likeCount(reviewNo, loginUser.getUserNo());

        //좋아요를 안한경우
        if (likeCountResponse.getLikeCheck() == 0) {
            //review_user table에 저장
            return mybookService.like(reviewNo, loginUser.getUserNo());
            //좋아요를 이미 한 경우
        } else {
            //review_user에서 좋아요 취소
            return mybookService.unLike(reviewNo, loginUser.getUserNo());
        }
    }


    //삭제 버튼을 눌렀을때의 기능 (작서자일 경우에만 삭제)
    @DeleteMapping("/{review-no}")
    public Long delete(@PathVariable("review-no") Long reviewNo
                        , Authentication authentication) {
        //세션아이디의 유저넘버
        String email = authentication.getName();
        log.info("로그인한 유저 넘버:{}, 클릭한 서평 넘버:{}", email, reviewNo);

        //해당 유저의 서평일 경우에만 삭제가 가능하게 하기
        Long deleteResult = mybookService.deleteReview(reviewNo);

        //값이 1일때는 삭제하려는 리뷰의 작성자와 로그인사용자가 같음을 의미
        return deleteResult;
    }

    //감정 카테고리 선택시 기능
    @GetMapping("/{emotion}")
    public ResponseEntity select(@PathVariable(value = "emotion") String emotion
                                , Authentication authentication
                                , @RequestParam("user-no") Long userNoParam) {
        //세션의 닉네임
        String email = authentication.getName();
        UserDto loginUser = userService.findByUserEmail(email);

        //세션아이디랑 지금 블로그닉네임이 같니?
        if (loginUser.getUserNo() == userNoParam) {//로그인 유저와 서재 동일
            log.info("지금 서재 유저 넘버:{}, 선택한 감정태그:{} ", loginUser.getUserNo(), emotion);

            //유저넘버, 감정태그 주면 해당유저의 서평 중 그 감정태그를 가진것만 출력해주기
            List<EmotionListResponse> emotionListResponse = mybookService.emoList(emotion, loginUser.getUserNo());
            return ResponseEntity.status(HttpStatus.OK).body(emotionListResponse);

        } else {
            log.info("지금 서재 유저 넘버:{}, 선택한 감정태그:{} ", userNoParam, emotion);

            //유저넘버, 감정태그 주면 해당유저의 서평 중 그 감정태그를 가진것만 출력해주기
            List<EmotionListResponse> emotionListResponses = mybookService.emoList(emotion, userNoParam);
            return ResponseEntity.status(HttpStatus.OK).body(emotionListResponses);
        }
    }


}
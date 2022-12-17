package com.javaex.controller;

import com.javaex.dto.likeReviews.DeleteResult;
import com.javaex.dto.likeReviews.LatestLikeReviewsDto;
import com.javaex.dto.likeReviews.ReviewLikeTotalCountResult;
import com.javaex.dto.user.UserDto;
import com.javaex.service.LikeReviewService;
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
@RequestMapping(value = "/boggle/like-review")
public class LikeReviewController {

    private final UserService userService;
    private final LikeReviewService likeReviewService;

    // 취향저격(좋아요한서평페이지)
    @GetMapping("/{nickname}")
    public ResponseEntity<List<LatestLikeReviewsDto>> groupByLikeReviews(@PathVariable(value = "nickname") String nicknameParam
            , Authentication authentication) {

        //만약 로그인한 사람이 없다면 로그인 페이지로
        if (!authentication.isAuthenticated()) {
            log.info("로그인을 해주세요");
        }

        // 세션의 닉네임
        UserDto loginUser = userService.findByUserEmail(authentication.getName());
        log.info("로그인 유저 이메일:{}, 지금 서재 닉네임:{}", loginUser.getNickname(), nicknameParam);

        // 로그인 유저, 접속 페이지 유저 확인
        if (loginUser.getNickname().equals(nicknameParam)) {
            // 로그인한 유저넘버
            Long loginUserNo = loginUser.getUserNo();
            // 해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
            List<LatestLikeReviewsDto> latestLikeReviews = likeReviewService.getLatestLikeReviews(loginUserNo);
            return ResponseEntity.status(HttpStatus.OK).body(latestLikeReviews);

        } else {//타 유저 페이지 접속
            // 지금 서재 닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드 사용
            UserDto byNickname = userService.findByNickname(nicknameParam);
            // 해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
            List<LatestLikeReviewsDto> latestLikeReviews = likeReviewService.getLatestLikeReviews(byNickname.getUserNo());
            return ResponseEntity.status(HttpStatus.OK).body(latestLikeReviews);
        }
    }

    //삭제 버튼을 눌렀을때의 기능
    @DeleteMapping("/{review-no}")//review-userNo, reviewNo
    public DeleteResult reviewDelete(@PathVariable("review-no") Long deleteReviewNo
            , Authentication authentication) {
        //로그인 유저넘버
        String email = authentication.getName();
        UserDto loginUser = userService.findByUserEmail(email);
        log.info("로그인한 유저 넘버:{}, 클릭한 서평 넘버:{}", loginUser.getUserNo(), deleteReviewNo);

        //해당 유저의 서평일 경우에만 삭제가 가능하게 하기
        DeleteResult deleteResult = likeReviewService.deleteByReviewNo(deleteReviewNo, loginUser.getUserNo());
        return deleteResult;
    }

    @GetMapping("/{review-no}")
    public LikeReviewVo like(@PathVariable("review-no") Long reviewNo //reviewNoParam 클릭한 서평 넘버, userNo
                             , Authentication authentication) {
        // 세션아이디의 유저넘버
        String email = authentication.getName();
        UserDto loginUser = userService.findByUserEmail(email);

        // 클릭한 서평 넘버
        log.info("로그인한 유저 넘버:{}, 클릭한 서평 넘버:{}", loginUser.getUserNo(), reviewNo);

        // 해당유저가 좋아요를 했는지 안했는지, 좋아요가 몇갠지 불러오기.
        ReviewLikeTotalCountResult reviewLikeTotalCountResult = likeReviewService.likeCount(loginUser.getUserNo(), reviewNo);
        log.info("좋아요 갯수:{} ", reviewLikeTotalCountResult.getLikeTotalCount());
        log.info("좋아요 여부 확인:{} ", reviewLikeTotalCountResult.getCheckLike());

        // 좋아요를 안한경우
        if (likeok.getLikecheck() == 0) {
            // review_user table에 인서트
            likeReviewService.like(checklike);
            log.info("{} 번 서평 좋아요", checklike.getReviewNo());
            return likeok;
            // 좋아요를 이미 한 경우
        } else {
            // review_user에서 삭제
            likeReviewService.dislike(checklike);
            System.out.println(checklike.getReviewNo() + "번 서평 좋아요 취소");
            return likeok;
        }
    }
}
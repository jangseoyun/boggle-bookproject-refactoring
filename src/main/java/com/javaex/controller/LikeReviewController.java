package com.javaex.controller;

import com.javaex.dto.likeReviews.LatestLikeReviewsDto;
import com.javaex.dto.user.UserDto;
import com.javaex.service.LikeReviewService;
import com.javaex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	   /*@ResponseBody
	   @RequestMapping("/delete1")
	   public int delete1(HttpSession session,
			   		   @RequestBody LikeReviewVo clickReview) {
	      
	      //세션아이디의 유저넘버
	      int userNo = ((UserVo)session.getAttribute("authUser")).getUserNo();
	      //클릭한 서평 넘버
	      int clickNo = clickReview.getReviewNo();
	      
	      System.out.println("로그인한 유저 넘버 : " + userNo);
	      System.out.println("클릭한 서평 넘버 : " + clickNo);
	      
	      LikeReviewVo delete = new LikeReviewVo(clickNo, userNo);

	      //해당 유저의 서평일 경우에만 삭제가 가능하게 하기
	      int checkuser = likeReviewService.delete(delete);
	      
	      //값이 1일때는 삭제하려는 리뷰의 작성자와 로그인사용자가 같음을 의미 
	      return checkuser;
	   }
	   

	@ResponseBody
	@RequestMapping("/like1")
	public LikeReviewVo like1(HttpSession session, @RequestBody LikeReviewVo clickReview) {

		// 세션아이디의 유저넘버
		int userNo = ((UserVo) session.getAttribute("authUser")).getUserNo();
		// 클릭한 서평 넘버
		int clickNo = clickReview.getReviewNo();

		System.out.println("로그인한 유저 넘버 : " + userNo);
		System.out.println("클릭한 서평 넘버 : " + clickNo);

		LikeReviewVo checklike = new LikeReviewVo(clickNo, userNo);

		// 해당유저가 좋아요를 했는지 안했는지, 좋아요가 몇갠지 불러오기.
		LikeReviewVo likeok = likeReviewService.likecnt(checklike);

		System.out.println("좋아요 갯수 : " + likeok.getLikecnt());
		System.out.println("좋아요 여부 확인 : " + likeok.getLikecheck());

		// 좋아요를 안한경우
		if (likeok.getLikecheck() == 0) {

			// review_user table에 인서트
			likeReviewService.like(checklike);

			System.out.println(checklike.getReviewNo() + "번 서평 좋아요");

			return likeok;

			// 좋아요를 이미 한 경우
		} else {

			// review_user에서 삭제
			likeReviewService.dislike(checklike);

			System.out.println(checklike.getReviewNo() + "번 서평 좋아요 취소");

			return likeok;
		}
	}*/
}
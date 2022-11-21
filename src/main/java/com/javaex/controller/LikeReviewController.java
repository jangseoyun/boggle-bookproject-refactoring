package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.LikeReviewService;
import com.javaex.service.UserService;
import com.javaex.vo.LikeReviewVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "")
public class LikeReviewController {

	// field
	@Autowired
	private UserService userService;
	@Autowired
	private LikeReviewService likeReviewService;

	// 취향저격(좋아요한서평페이지)
	@RequestMapping("/{nickname}/tastereview")
	public String tastereview(@PathVariable(value = "nickname") String nickname, HttpSession session, Model model) {

		if (session == null || session.getAttribute("authUser") == null
				|| session.getAttribute("authUser").equals("")) {
			System.out.println("세션만료 혹은 잘못된 접근");

			return "user/loginForm";
		}

		// 세션의 닉네임
		String yours = ((UserVo) session.getAttribute("authUser")).getNickname();
		System.out.println("로그인사람의 닉네임 : " + yours);
		System.out.println("지금 서재 닉네임 : " + nickname);

		// 세션아이디랑 지금 블로그닉네임이 같니?
		if (nickname.equals(yours)) {

			String result = "sameUser";
			System.out.println(result);

			// result 값 보내주기
			model.addAttribute("result", result);

			// 세션아이디의 유저넘버
			int userNo = ((UserVo) session.getAttribute("authUser")).getUserNo();

			// 해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
			// 해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
			List<LikeReviewVo> like1 = likeReviewService.likereview(userNo);
			model.addAttribute("like1", like1);

			// 중복체크 및 값 set해서 List 업데이트, 지금 로그인한 유저
			for (int i = 0; i < like1.size(); i++) {

				int reviewNo = like1.get(i).getReviewNo();

				// 0일시 좋아요 안 한 상태, 1일시 좋아요 한 상태
				LikeReviewVo checklike = new LikeReviewVo(reviewNo, userNo);
				int likecheck = likeReviewService.likeok(checklike);

				like1.get(i).setLikecheck(likecheck);

			}

			return "taste/review";

		} else {

			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);

			if (userService.getUser(nickname) == null) {
				System.out.println("잘못된 접근입니다");

				return "/main";
			} else {

				// 지금 서재 닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드 사용
				UserVo otherUser = userService.getUser(nickname);
				int userNo = otherUser.getUserNo();
				model.addAttribute("otherUser", otherUser);

				// 해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
				List<LikeReviewVo> like1 = likeReviewService.likereview(userNo);
				model.addAttribute("like1", like1);

				// 중복체크 및 값 set해서 List 업데이트, 지금 로그인한 유저
				for (int i = 0; i < like1.size(); i++) {

					int reviewNo = like1.get(i).getReviewNo();

					// 0일시 좋아요 안 한 상태, 1일시 좋아요 한 상태
					LikeReviewVo checklike = new LikeReviewVo(reviewNo, userNo);
					int likecheck = likeReviewService.likeok(checklike);

					like1.get(i).setLikecheck(likecheck);

				}

				return "taste/review";
			}

		}
	}
	
	   //삭제 버튼을 눌렀을때의 기능
	   @ResponseBody
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
	}
}
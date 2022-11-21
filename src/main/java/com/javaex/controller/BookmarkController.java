package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BookmarkService;
import com.javaex.service.UserService;
import com.javaex.vo.BookmarkVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "")
public class BookmarkController {

	// field
	@Autowired
	private BookmarkService bookmarkService;
	@Autowired
	private UserService userService;

	// 리스트 출력 기능
	@RequestMapping("/{nickname}/main_book")

	public String bookmarkController(@PathVariable(value = "nickname") String nickname, HttpSession session,
			Model model) {

		if (session == null || session.getAttribute("authUser") == null
				|| session.getAttribute("authUser").equals("")) {
			System.out.println("세션만료 혹은 잘못된 접근");

			return "user/loginForm";
		}
		// int userNo = ((UserVo)session.getAttribute("authUser").getUserNo();

		// session nick
		String yours = ((UserVo) session.getAttribute("authUser")).getNickname();
		System.out.println("로그인사람의 닉네임 : " + yours);
		System.out.println("지금 서재 닉네임 : " + nickname);

		// session = blog nickname
		if (nickname.equals(yours)) {

			String result = "sameUser";
			System.out.println(result);

			// result 값 보내주기
			model.addAttribute("result", result);

			// session userNo
			int userNo = ((UserVo) session.getAttribute("authUser")).getUserNo();

			System.out.println(userNo + "의 북마크");
			List<BookmarkVo> bmList = bookmarkService.getBMList(userNo);
			System.out.println(bmList);

			model.addAttribute("bmList", bmList);

		} else {

			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);


			// 지금 서재 닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드 사용
			UserVo otherUser = userService.getUser(nickname);
			int userNo = otherUser.getUserNo();
			model.addAttribute("otherUser", otherUser);

			System.out.println(userNo + "의 북마크");
			List<BookmarkVo> bmList = bookmarkService.getBMList(userNo);
			System.out.println(bmList);

			model.addAttribute("bmList", bmList);

		}
		return "taste/main-book";
	}
}
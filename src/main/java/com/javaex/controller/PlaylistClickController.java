package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.PlaylistClickService;
import com.javaex.service.UserService;
import com.javaex.vo.PlaylistClickVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "")
public class PlaylistClickController {

	// field
	@Autowired
	private PlaylistClickService playlistClickService;
	@Autowired
	private UserService userService;

	@RequestMapping("/{nickname}/playlist") // 좋아요한 플레이리스트
	public String playlist(@PathVariable(value = "nickname") String nickname, HttpSession session, Model model) {
		System.out.println("playlist");

		// 세션의 닉네임
		String yours = ((UserVo) session.getAttribute("authUser")).getNickname();
		System.out.println("로그인사람의 닉네임 : " + yours);
		System.out.println("지금 서재 닉네임 : " + nickname);

		if (nickname.equals(yours)) {

			String result = "sameUser";
			System.out.println(result);

			// result 값 보내주기
			model.addAttribute("result", result);

			// session userNo id
			int userNo = ((UserVo) session.getAttribute("authUser")).getUserNo();

			List<PlaylistClickVo> likeplayclick = playlistClickService.likelistclick(userNo);
			model.addAttribute("likeplayclick", likeplayclick);

		} else {

			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);

			UserVo otherUser = userService.getUser(nickname);
			int userNo = otherUser.getUserNo();
			model.addAttribute("otherUser", otherUser);

			List<PlaylistClickVo> likeplayclick = playlistClickService.likelistclick(userNo);
			model.addAttribute("likeplayclick", likeplayclick);

		}
		return "taste/playlist";
	}

	@RequestMapping("/{nickname}/hotplaylist") // 인기순 플레이리스트
	public String playlist1(@PathVariable(value = "nickname") String nickname,
			@ModelAttribute PlaylistClickVo playlistClickVo,

//							@RequestParam (value="userNo")int userNo, 
//							@RequestParam(value = "nickname")String nickname,
			HttpSession session, Model model) {

		String yours = ((UserVo) session.getAttribute("authUser")).getNickname();
		System.out.println("로그인사람의 닉네임 : " + yours);
		System.out.println("지금 서재 닉네임 : " + nickname);

		if (nickname.equals(yours)) {

			String result = "sameUser";
			System.out.println(result);

			// result 값 보내주기
			model.addAttribute("result", result);

			// session userNo id
			int myuserNo = ((UserVo) session.getAttribute("authUser")).getUserNo();

			List<PlaylistClickVo> popularlistclick = playlistClickService.popularlistclick();
			model.addAttribute("popularlistclick", popularlistclick);
		} else {

			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);

			UserVo otherUser = userService.getUser(nickname);
			int myuserNo = otherUser.getUserNo();
			model.addAttribute("otherUser", otherUser);

			List<PlaylistClickVo> popularlistclick = playlistClickService.popularlistclick();
			model.addAttribute("popularlistclick", popularlistclick);

		}
		return "taste/hot_playlist";
	}

	@RequestMapping("/{nickname}/writeplaylist")
	public String playlist2(@PathVariable(value = "nickname") String nickname,
			@ModelAttribute PlaylistClickVo playlistClickVo, HttpSession session, Model model) {

		String yours = ((UserVo) session.getAttribute("authUser")).getNickname();
		System.out.println("로그인사람의 닉네임 : " + yours);
		System.out.println("지금 서재 닉네임 : " + nickname);

		if (nickname.equals(yours)) {

			String result = "sameUser";
			System.out.println(result);

			// result 값 보내주기
			model.addAttribute("result", result);

			int userNo = ((UserVo) session.getAttribute("authUser")).getUserNo();

			List<PlaylistClickVo> makelistclick = playlistClickService.makelistclick(userNo);
			model.addAttribute("makelistclick", makelistclick);
		} else {
			
			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);

			UserVo otherUser = userService.getUser(nickname);
			int userNo = otherUser.getUserNo();
			model.addAttribute("otherUser", otherUser);
			
			List<PlaylistClickVo> makelistclick = playlistClickService.makelistclick(userNo);
			model.addAttribute("makelistclick", makelistclick);

		}

		return "taste/written_playlist";
	}
}
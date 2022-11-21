package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BookmarkService;
import com.javaex.service.MybookService;
import com.javaex.service.PlaylistService;
import com.javaex.service.UserService;
import com.javaex.vo.BookmarkVo;
import com.javaex.vo.MybookVo;
import com.javaex.vo.PlaylistVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "")
public class TasteController {

	// 필드
	@Autowired
	private MybookService mybookService;
	@Autowired
	private UserService userService;
	@Autowired
	private PlaylistService playlistService;
	@Autowired
	private BookmarkService bookmarkService;

	// 취향저격(main페이지)
	@RequestMapping("/{nickname}/tastemain")
	public String tastemain(@PathVariable(value = "nickname") String nickname, HttpSession session, Model model) {

		System.out.println("tastemain");
		
		if (session == null || session.getAttribute("authUser") == null || session.getAttribute("authUser").equals("")) {
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

			//해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
			List<MybookVo> like1 = mybookService.likereview(userNo);
			model.addAttribute("like1", like1);
			
			//해당유저 넘버를 주면 좋아요한 서평리스트를 출력하는 메소드+해당유저의 서평 총 갯수 출력
			List<MybookVo> likelist = mybookService.likelist(userNo);
			model.addAttribute("likelist", likelist);
			
			//해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
			List<PlaylistVo> likeplay = playlistService.likelist(userNo);
			model.addAttribute("likeplay", likeplay);
			
			//해당유저넘버를 주면 좋아요한 책 목록을 출력하는 메소드
			List<BookmarkVo> get5book = bookmarkService.get5book(userNo);
			model.addAttribute("get5book", get5book);
			
		} else {

			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);
			
			if (userService.getUser(nickname) == null) {
			   System.out.println("잘못된 접근입니다");
			   
			   return "/main";
		    }
			
			// 지금 서재 닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드 사용
			UserVo otherUser = userService.getUser(nickname);
			int userNo = otherUser.getUserNo();
			model.addAttribute("otherUser", otherUser);
			
			//해당유저 넘버를 주면 좋아요한 서평을 출력하는 메소드
			List<MybookVo> like1 = mybookService.likereview(userNo);
			model.addAttribute("like1", like1);
			
			//해당유저 넘버를 주면 좋아요한 서평리스트를 출력하는 메소드+해당유저의 서평 총 갯수 출력
			List<MybookVo> likelist = mybookService.likelist(userNo);
			model.addAttribute("likelist", likelist);
			
			//해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
			List<PlaylistVo> likeplay = playlistService.likelist(userNo);
			model.addAttribute("likeplay", likeplay);
			
			//해당유저넘버를 주면 좋아요한 책 목록을 출력하는 메소드
			List<BookmarkVo> get5book = bookmarkService.get5book(userNo);
			model.addAttribute("get5book", get5book);
		}

		return "taste/taste-main";
	}

	
	// 플레이리스트(main페이지)
	@RequestMapping("/{nickname}/like_playlist")
	public String playlistmain(@PathVariable(value = "nickname") String nickname, HttpSession session, Model model) {

		System.out.println("tastemain");

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

			//해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
			List<PlaylistVo> likeplay = playlistService.likelist(userNo);
			model.addAttribute("likeplay", likeplay);
			
			//인기있는 플레이리스트 출력하는 메소드
			List<PlaylistVo> popularlist = playlistService.popularlist();
			model.addAttribute("popularlist", popularlist);
			
			//특정 유저 넘버 주면, 해당 유저가 만든 플리 리스트 출력
			List<PlaylistVo> makelist = playlistService.makelist(userNo);
			model.addAttribute("makelist", makelist);

		} else {

			String result = nickname;
			System.out.println("anotherUser");

			// result 값 보내주기
			model.addAttribute("result", result);

			// 지금 서재 닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드 사용
			UserVo otherUser = userService.getUser(nickname);
			int userNo = otherUser.getUserNo();
			model.addAttribute("otherUser", otherUser);
			
			//해당유저 넘버를 주면 좋아요한 플레이리스트를 출력하는 메소드
			List<PlaylistVo> likeplay = playlistService.likelist(userNo);
			model.addAttribute("likeplay", likeplay);
			
			//인기있는 플레이리스트 출력하는 메소드
			List<PlaylistVo> popularlist = playlistService.popularlist();
			model.addAttribute("popularlist", popularlist);
			
			//특정 유저 넘버 주면, 해당 유저가 만든 플리 리스트 출력
			List<PlaylistVo> makelist = playlistService.makelist(userNo);
			model.addAttribute("makelist", makelist);			
			
			
		}

		return "taste/like-playlist";
	}
}

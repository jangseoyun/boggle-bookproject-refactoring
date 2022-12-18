package com.javaex.controller;

import com.javaex.dto.taste.PreviewMainResponse;
import com.javaex.dto.user.UserDto;
import com.javaex.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/boggle/preview")
public class TasteController {
    private final TasteService tasteService;
    private final UserService userService;

    // 취향저격(main페이지)
    @GetMapping("/{nickname}/main")
    public ResponseEntity<PreviewMainResponse> previewMain(@PathVariable(value = "nickname") String nicknameParam
            , Authentication authentication) {

        log.info("previewMain");
        if (!authentication.isAuthenticated()) log.info("로그인을 해주세요");

        // 세션의 닉네임
        UserDto loginUser = userService.findByUserEmail(authentication.getName());
        UserDto pageUser = userService.findByNickname(nicknameParam);
        log.info("로그인사람의 닉네임:{}, 지금 서재 닉네임:{}", loginUser.getNickname(), nicknameParam);

        // 세션아이디랑 지금 블로그닉네임이 같니?
        PreviewMainResponse previewMainResponse = tasteService.checkAccessUserAndViewResponse(pageUser, loginUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(previewMainResponse);
    }


    // 플레이리스트(main페이지)
	/*@RequestMapping("/{nickname}/like_playlist")
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
	}*/
}


package com.javaex.controller;

import com.javaex.dto.taste.PreviewMainResponse;
import com.javaex.dto.taste.PreviewPlaylistResponse;
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
    @GetMapping("/{nickname}/like-playlist")
    public ResponseEntity<PreviewPlaylistResponse> previewLikePlaylist(@PathVariable(value = "nickname") String nickname
            , Authentication authentication) {

        log.info("previewLikePlaylist");

        // 세션의 닉네임
        String email = authentication.getName();
        UserDto loginUser = userService.findByUserEmail(email);
        UserDto pageUser = userService.findByNickname(nickname);

        log.info("로그인사람의 닉네임:{}, 지금 서재 닉네임:{} ", loginUser.getNickname(), nickname);

        PreviewPlaylistResponse previewPlaylistResponse = tasteService.checkAccessUserAndPlayList(pageUser, loginUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(previewPlaylistResponse);
    }
}


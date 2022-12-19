package com.javaex.controller;

import com.javaex.dto.clickPlaylist.ClickPlayListDto;
import com.javaex.dto.playlist.LikePlaylistDto;
import com.javaex.dto.user.UserDto;
import com.javaex.service.PlaylistClickService;
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
@RequestMapping(value = "/boggle")
public class PlaylistClickController {

    private final PlaylistClickService playlistClickService;
    private final UserService userService;

    /*좋아요한 플레이리스트 폴더 목록*/
    @GetMapping("/{nickname}/folder-list")
    public ResponseEntity<List<LikePlaylistDto>> likePlayList(@PathVariable(value = "nickname") String nicknameParam
            , Authentication authentication) {
        UserDto loginUser = userService.findByUserEmail(authentication.getName());
        log.info("likePlayList => 로그인사람의 닉네임:{}, 지금 서재 닉네임:{}", loginUser.getNickname(), nicknameParam);

        //로그인유저 == 접근 페이지 유저 체크
        List<LikePlaylistDto> likePlayListDtoList;
        if (nicknameParam.equals(loginUser.getNickname())) {
            likePlayListDtoList = playlistClickService.getLikePlayList(loginUser.getUserNo());
        } else {
            UserDto requestUser = userService.findByNickname(nicknameParam);
            likePlayListDtoList = playlistClickService.getLikePlayList(requestUser.getUserNo());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(likePlayListDtoList);
    }

    /*인기순 플레이리스트 폴더 목록*/
    @GetMapping("/hot-playlist")
    public ResponseEntity<List<ClickPlayListDto>> popularPlayList(@RequestParam("nickname") String nicknameParam,
                                                                  Authentication authentication) {

        UserDto loginUser = userService.findByUserEmail(authentication.getName());
        log.info("likePlayList => 로그인사람의 닉네임:{}, 지금 서재 닉네임:{}", loginUser.getNickname(), nicknameParam);

        List<ClickPlayListDto> popularPlayList = playlistClickService.popularPlayList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(popularPlayList);
    }

    /*특정 유저의 플레이리스트*/
	@GetMapping("/maker-playlist")
	public ResponseEntity<List<ClickPlayListDto>> playListByUser(@RequestParam("nickname") String nicknameParam) {

        UserDto pageUser = userService.findByNickname(nicknameParam);
        log.info("likePlayList => 지금 페이지 닉네임:{}", nicknameParam);

        List<ClickPlayListDto> playListByUser = playlistClickService.playListByUser(pageUser.getUserNo());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(playListByUser);
	}
}
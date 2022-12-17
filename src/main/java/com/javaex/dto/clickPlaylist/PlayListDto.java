package com.javaex.dto.clickPlaylist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlayListDto {
    private Long likeUserNo;
    private Long playlistNo;
    private String playlistName;
    private Long emoNo;
    private Long writeUserNo;
    private String nickname;
}

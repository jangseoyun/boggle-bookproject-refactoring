package com.javaex.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikePlaylistDto {
    private Long likeUserNo;
    private Long playlistNo;
    private String playlistDate;
    private String playlistName;
    private Long emoNo;
    private Long userNo;
    private String nickname;
}

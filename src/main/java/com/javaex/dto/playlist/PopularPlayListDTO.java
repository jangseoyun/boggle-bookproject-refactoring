package com.javaex.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PopularPlayListDTO {
    private Long likeUserNo;
    private Long playlistNo;
    private String playlistName;
    private Long emotionNo;
    private Long userNo;
    private String nickname;
}

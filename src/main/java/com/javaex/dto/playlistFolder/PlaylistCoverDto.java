package com.javaex.dto.playlistFolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistCoverDto {

    private Long playlistNo;
    private Long userNo;
    private String playlistName;
    private String nickname;

}

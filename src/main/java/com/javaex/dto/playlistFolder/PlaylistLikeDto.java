package com.javaex.dto.playlistFolder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistLikeDto {
    private Long userPlaylistNo;
    private Long playlistNo;
    private Long userNo;
}

package com.javaex.dto.playlistFolder;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PlaylistFolderResponse {

    private boolean prev;
    private boolean next;
    private int startPageBtnNo;
    private int endPageBtnNo;
    private List<PlaylistFolderVo> playlistFolderList;
    private PlaylistCoverDto playlistCover;

}

package com.javaex.dto.playlistFolder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaylistFolderSearchDto {
    private Long reviewNo;
    private Long bookNo;
    private Long playlistNo;
    private String reviewContent;
    private String emoName;
    private String bookTitle;
}

package com.javaex.dto.bookmark;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PreviewBookmarkDTO {
    private Long bookNo;
    private String bookTitle;
    private Long userNo;
    private String bookUrl;
    private String coverUrl;
    private String bookmarkDate;
}

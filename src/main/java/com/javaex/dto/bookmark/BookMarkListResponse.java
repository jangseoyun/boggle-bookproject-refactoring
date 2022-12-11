package com.javaex.dto.bookmark;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkListResponse {
    private Long userNo;
    private String email;
    private Long bookNo;
    private String bookTitle;
    private String bookUrl;
    private String coverUrl;
    private String author;
    private String bookmarkDate;
}


package com.javaex.dto.bookdetail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDetailInfo {
    private String bookNo;
    private String bookTitle;
    private String author;
    private String bookUrl;
    private String coverUrl;
}

package com.javaex.dto.reviewwrite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewModifyRequest {
    private Long bookNo;
    private String bookTitle;
    private String author;
    private String bookURL;
    private Long genreNo;
    private String coverURL;
    private Long userNo;
    private Long styleNo;
    private String reviewContent;
    private String genreName;
    private Long reviewNo;
}
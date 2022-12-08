package com.javaex.dto.reviewwrite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewAddResponse {
    private Long userNo;
    private Long reviewNo;
    private String writerNickname;
    private String bookTitle;
    private String reviewContent;
}

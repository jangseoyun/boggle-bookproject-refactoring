package com.javaex.dto.mybook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReviewDTO {
    private Long bookNo;
    private String bookTitle;
    private Long userNo;
    private Long reviewNo;
    private String reviewContent;
    private String reviewDate;
    private Long styleNo;
    private String emoName;
    private Long likecnt;
}

package com.javaex.dto.bookdetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookReviewDto {
    private int rn;
    private String bookNo;
    private String bookTitle;
    private int userNo;
    private String nickname;
    private int reviewNo;
    private String emoName;
    private String reviewDate;
    private String reviewContent;
    private int likecnt;
    private int styleNo;
}

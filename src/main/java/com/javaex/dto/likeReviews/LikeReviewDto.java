package com.javaex.dto.likeReviews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikeReviewDto {
    private Long reviewNo;
    private String bookTitle;
    private Long bookNo;
    private Long userNo;
    private String nickname;
    private String reviewContent;
    private Long styleNo;
    private String emoName;
    private int likeCnt;
    private String reviewDate;
}

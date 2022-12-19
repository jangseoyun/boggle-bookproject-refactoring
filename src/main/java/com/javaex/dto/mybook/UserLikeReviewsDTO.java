package com.javaex.dto.mybook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLikeReviewsDTO {
    private Long reviewNo;
    private String reviewLikeDate;
    private String reviewContent;
    private int likeCnt;
    private String reviewDate;

    private Long bookNo;
    private String bookTitle;

    private Long userNo;
    private String nickname;
    private String userProfile;

    private Long styleNo;
    private String emoName;
}

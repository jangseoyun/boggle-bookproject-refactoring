package com.javaex.dto.mybook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewsResponse {
    private Long bookNo;
    private String bookTitle;
    private Long userNo;
    private Long reviewNo;
    private String reviewContent;
    private String reviewDate;
    private Long styleNo;
    private String emoName;
    private String likeStatus;
}

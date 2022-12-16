package com.javaex.dto.likeReviews;

import com.javaex.dto.mybook.LikeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LatestLikeReviewsDto {
    private Long userNo;
    private String nickname;
    private Long likeCnt;
    private LikeStatus likeStatus;

    private Long reviewNo;
    private String reviewContent;
    private String reviewDate;
    private String reviewLikeDate;

    private Long bookNo;
    private String bookTitle;

    private Long styleNo;
    private String emoName;

    public void setLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}

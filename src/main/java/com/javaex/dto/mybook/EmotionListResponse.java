package com.javaex.dto.mybook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmotionListResponse {
    private Long reviewNo;
    private Long likecnt;
    private Long styleNo;
    private Long emoNo;
    private String emoName;
    private Long bookNo;
    private String bookTitle;
    private Long userNo;
    private String reviewContent;
    private String reviewDate;
    private String nickname;
    private LikeStatus likeStatus;

    public void setLikeStatus(LikeStatus likeStatus) {
        this.likeStatus = likeStatus;
    }
}

package com.javaex.dto.likeReviews;

import com.javaex.dto.mybook.LikeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewLikeTotalCountResult {
    private Long reviewNo;
    private Long userNo;
    private String nickname;
    private int likeTotalCount;
    private LikeStatus checkLike;

    public void setCheckLike(Long checkLikeResult) {
        if (checkLikeResult == 1) {
            this.checkLike = LikeStatus.LIKE;
        } else {
            this.checkLike = LikeStatus.UNLIKE;
        }
    }
}
package com.javaex.dto.likeReviews;

import com.javaex.dto.mybook.LikeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewLikeTotalCountResult {
    private Long reviewNo;
    private Long reviewByUserNo;
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
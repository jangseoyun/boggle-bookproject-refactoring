package com.javaex.dto.mybook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikeDTO {
    private Long reviewUserNo;
    private Long reviewNo;
    private Long userNo;
    private String reviewLikeDate;

    public LikeDTO(Long reviewNo, Long userNo) {
        this.reviewNo = reviewNo;
        this.userNo = userNo;
    }
}

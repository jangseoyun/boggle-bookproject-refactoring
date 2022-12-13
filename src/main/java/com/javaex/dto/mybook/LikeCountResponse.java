package com.javaex.dto.mybook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikeCountResponse {
    private Long reviewNo;
    private Long userNo;
    private String nickname;
    private Long likeCnt;
    private Long likeCheck;

    public void setLikeCheck(Long likeResultNo) {
        this.likeCheck = likeResultNo;
    }
}

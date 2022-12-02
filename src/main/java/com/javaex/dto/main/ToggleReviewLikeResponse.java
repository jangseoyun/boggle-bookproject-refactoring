package com.javaex.dto.main;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToggleReviewLikeResponse {
    private Long resultCode;
    private String message;

    public ToggleReviewLikeResponse(Long resultCode) {
        this.resultCode = resultCode;
        this.message = setMesagge(resultCode);
    }

    private String setMesagge(Long resultCode) {
        if (resultCode == 0) {
            message = "좋아요";
        } else {
            message = "좋아요 취소";
        }

        return message;
    }
}

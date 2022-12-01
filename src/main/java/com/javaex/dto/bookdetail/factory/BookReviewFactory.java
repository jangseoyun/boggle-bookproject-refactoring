package com.javaex.dto.bookdetail.factory;

import com.javaex.dto.bookdetail.ReviewDeleteResponse;

public class BookReviewFactory {
    public static ReviewDeleteResponse createDeleteResponse(int deleteResult) {
        return new ReviewDeleteResponse(setMessage(deleteResult));
    }

    private static String setMessage(int deleteResult) {
        if (deleteResult == 1) {
            return "서평이 삭제 되었습니다";
        } else {
            return "다시 시도해 주세요";
        }
    }
}

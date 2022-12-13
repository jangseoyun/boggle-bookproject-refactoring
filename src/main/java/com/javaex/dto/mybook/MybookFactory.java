package com.javaex.dto.mybook;

public class MybookFactory {
    public static UserReviewsResponse of(UserReviewDTO setUserReview, LikeStatus likeStatus) {
        return UserReviewsResponse.builder()
                .bookNo(setUserReview.getBookNo())
                .bookTitle(setUserReview.getBookTitle())
                .userNo(setUserReview.getUserNo())
                .reviewNo(setUserReview.getReviewNo())
                .reviewContent(setUserReview.getReviewContent())
                .reviewDate(setUserReview.getReviewDate())
                .styleNo(setUserReview.getStyleNo())
                .emoName(setUserReview.getEmoName())
                .likeStatus(likeStatus.name())
                .build();
    }

    public static LikeDTO getLikeDto(Long reviewNo, Long userNo) {
        return new LikeDTO(reviewNo, userNo);
    }
}

package com.javaex.dto.bookdetail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDetailResponse {
    private BookDetailInfo bookInfo; //해당 책 정보
    private int bookReviewCount; //해당 책 작성된 서평 수
}

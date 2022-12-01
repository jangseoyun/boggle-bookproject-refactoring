package com.javaex.dto.bookdetail;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookReviewResponse<T> {
    private List<T> bookReviews;
}

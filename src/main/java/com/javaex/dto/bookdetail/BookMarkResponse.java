package com.javaex.dto.bookdetail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookMarkResponse {
    private String bookNo;
    private boolean markResult;
    private String message;
}

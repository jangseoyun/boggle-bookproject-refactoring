package com.javaex.dto.bookdetail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookMarkRequest {
    private String userNo;
    private String bookNo;
    private String markStatus; //todo: 검증 필요
}

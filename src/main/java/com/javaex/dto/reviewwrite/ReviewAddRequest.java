package com.javaex.dto.reviewwrite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewAddRequest {
    private Long genreNo;
    private String genreName;

    private Long bookNo;
    private String bookTitle;
    private String author;
    private String bookURL;
    private String coverURL;

    private Long reviewNo;
    private Long userNo;
    private Long styleNo;
    private String reviewContent;
    private LocalDateTime reviewDate;
}

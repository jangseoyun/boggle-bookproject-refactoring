package com.javaex.dto.reviewwrite;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookDto{
    private Long bookNo;
    private String bookTitle;
    private String author;
    private String bookUrl;
    private Long genreNo;
    private String coverUrl;

    public BookDto (ReviewModifyRequest reviewModifyRequest) {
        this.bookTitle = reviewModifyRequest.getBookTitle();
        this.author = reviewModifyRequest.getAuthor();
        this.bookUrl = reviewModifyRequest.getBookURL();
        this.genreNo = reviewModifyRequest.getGenreNo();
        this.coverUrl = reviewModifyRequest.getCoverURL();
    }

    public BookDto(ReviewAddRequest reviewAddRequest) {
        this.bookTitle = reviewAddRequest.getBookTitle();
        this.author = reviewAddRequest.getAuthor();
        this.bookUrl = reviewAddRequest.getBookURL();
        this.genreNo = reviewAddRequest.getGenreNo();
        this.coverUrl = reviewAddRequest.getCoverURL();
    }
}

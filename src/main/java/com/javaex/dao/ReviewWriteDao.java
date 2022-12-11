package com.javaex.dao;

import com.javaex.dto.reviewwrite.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Lazy
@Mapper
@Repository
public interface ReviewWriteDao {

    int getReviewTotalCnt(long isbn);

    List<StyleDto> getStyle(Long emoNo);

    int checkGenre(Long genreNo);

    void addGenre(String genreName);

    int checkBook(Long bookNo);

    int findByBookTitle(String bookTitle);

    int addBook(BookDto bookDto);

    int addReview(ReviewAddRequest reviewAddRequest);

    ReviewAddResponse selectReviewOne(Long ReviewNo);

    Map<String, Object> getBookInfo(String bookTitle);

    Map<String, Object> getPrevReviewInfo(Long reviewNo);

    int checkReviewWriter(Map<String, Long> reviewWriterMap);

    int checkBookUpdate(ReviewModifyRequest reviewModifyRequest);

    int modifyReview(ReviewModifyRequest reviewModifyRequest);

}

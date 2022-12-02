package com.javaex.dto.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MainReviewByEmoRequest {
    private Long playlistNo;
    private Long userNo;
    private Long emoNo;
}

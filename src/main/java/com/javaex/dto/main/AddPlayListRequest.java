package com.javaex.dto.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddPlayListRequest {
    private Long userNo;
    private Long emoNo;
    private String playlistName;
    private Long playlistNo;
}

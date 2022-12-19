package com.javaex.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MusicDTO {
    private int musicNo;
    private int emoNo;
    private String musicTitle;
    private String artist;
    private String musicPath;

    public void setEmoNo(int emoNo) {
        this.emoNo = emoNo;
    }

}

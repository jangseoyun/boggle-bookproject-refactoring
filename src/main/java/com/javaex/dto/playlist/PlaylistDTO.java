package com.javaex.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private int playlistNo;
    private int userNo;
    private String nickname;
    private String playlistDate;
    private String playlistName;
    private int emoNo;
    private int likeuser;
    private String emoName;

    public void setPlaylistNo(int playlistNo) {
        this.playlistNo = playlistNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public void setEmoNo(int emoNo) {
        this.emoNo = emoNo;
    }

    public void setEmoName(String emoName) {
        this.emoName = emoName;
    }

}

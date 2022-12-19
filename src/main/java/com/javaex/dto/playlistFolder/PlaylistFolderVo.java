package com.javaex.dto.playlistFolder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PlaylistFolderVo {

    //필드
    private int playlistNo;
    private String playlistName;
    private String playlistDate;

    private int reviewNo;
    private String reviewContent;
    private String reviewDate;

    private String nickname;
    private int userNo;

    private String bookNo;
    private String bookTitle;

    private int styleNo;
    private String emoName;

    private int rn;
    private int likecnt;


    //생성자
    public PlaylistFolderVo() {}

    public PlaylistFolderVo(int playlistNo, String playlistName) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
    }

    public PlaylistFolderVo(int playlistNo, String playlistName, String nickname) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
        this.nickname = nickname;
    }



    public PlaylistFolderVo(int playlistNo, String playlistName, String nickname, int userNo) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
        this.nickname = nickname;
        this.userNo = userNo;
    }

    public PlaylistFolderVo(int playlistNo, int reviewNo, String reviewContent, String bookNo, String bookTitle,
                            String emoName) {
        super();
        this.playlistNo = playlistNo;
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.emoName = emoName;
    }

    public PlaylistFolderVo(int playlistNo, int reviewNo, String reviewContent, String reviewDate, int userNo,
                            String bookNo, String bookTitle, int styleNo, String emoName, int rn) {
        super();
        this.playlistNo = playlistNo;
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.styleNo = styleNo;
        this.emoName = emoName;
        this.rn = rn;
    }

    public PlaylistFolderVo(int playlistNo, String playlistName, int reviewNo, String reviewContent, String reviewDate,
                            String nickname, int userNo, String bookNo, String bookTitle, int styleNo, String emoName) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.nickname = nickname;
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.styleNo = styleNo;
        this.emoName = emoName;
    }


    public PlaylistFolderVo(int playlistNo, String playlistName, int reviewNo, String reviewContent, String reviewDate,
                            String nickname, int userNo, String bookNo, String bookTitle, int styleNo, String emoName, int rn) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.nickname = nickname;
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.styleNo = styleNo;
        this.emoName = emoName;
        this.rn = rn;
    }

    public PlaylistFolderVo(int playlistNo, String playlistName, String playlistDate, int reviewNo,
                            String reviewContent, String reviewDate, String nickname, int userNo, String bookNo, String bookTitle,
                            int styleNo, String emoName, int rn) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
        this.playlistDate = playlistDate;
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.nickname = nickname;
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.styleNo = styleNo;
        this.emoName = emoName;
        this.rn = rn;
    }

    public PlaylistFolderVo(int playlistNo, String playlistName, String playlistDate, int reviewNo,
                            String reviewContent, String reviewDate, String nickname, int userNo, String bookNo, String bookTitle,
                            int styleNo, String emoName, int rn, int likecnt) {
        super();
        this.playlistNo = playlistNo;
        this.playlistName = playlistName;
        this.playlistDate = playlistDate;
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.nickname = nickname;
        this.userNo = userNo;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.styleNo = styleNo;
        this.emoName = emoName;
        this.rn = rn;
        this.likecnt = likecnt;
    }

    public void setPlaylistNo(int playlistNo) {
        this.playlistNo = playlistNo;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }


    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }


    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }


    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }


    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }


    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }


    public void setStyleNo(int styleNo) {
        this.styleNo = styleNo;
    }


    public void setEmoName(String emoName) {
        this.emoName = emoName;
    }

    public void setLikecnt(int likecnt) {
        this.likecnt = likecnt;
    }
}

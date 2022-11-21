package com.javaex.vo;

public class PlaylistVo {
	
	private int playlistNo;
	private int userNo;
	private String nickname;
	private String playlistDate;
	private String playlistName;
	private int emoNo;
	private int likeuser;
	private String emoName;
	
	public PlaylistVo() {}

	public PlaylistVo(int playlistNo, int userNo, String nickname, String playlistDate, String playlistName, int emoNo,
			int likeuser, String emoName) {
		super();
		this.playlistNo = playlistNo;
		this.userNo = userNo;
		this.nickname = nickname;
		this.playlistDate = playlistDate;
		this.playlistName = playlistName;
		this.emoNo = emoNo;
		this.likeuser = likeuser;
		this.emoName = emoName;
	}

	public int getPlaylistNo() {
		return playlistNo;
	}

	public void setPlaylistNo(int playlistNo) {
		this.playlistNo = playlistNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPlaylistDate() {
		return playlistDate;
	}

	public void setPlaylistDate(String playlistDate) {
		this.playlistDate = playlistDate;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public int getEmoNo() {
		return emoNo;
	}

	public void setEmoNo(int emoNo) {
		this.emoNo = emoNo;
	}

	public int getLikeuser() {
		return likeuser;
	}

	public void setLikeuser(int likeuser) {
		this.likeuser = likeuser;
	}

	public String getEmoName() {
		return emoName;
	}

	public void setEmoName(String emoName) {
		this.emoName = emoName;
	}

	@Override
	public String toString() {
		return "PlaylistVo [playlistNo=" + playlistNo + ", userNo=" + userNo + ", nickname=" + nickname
				+ ", playlistDate=" + playlistDate + ", playlistName=" + playlistName + ", emoNo=" + emoNo
				+ ", likeuser=" + likeuser + ", emoName=" + emoName + "]";
	}
	
	
}

package com.javaex.vo;

public class MusicVo {
	
	private int musicNo;
	private int emoNo;
	private String musicTitle;
	private String artist;
	private String musicPath;
	
	
	public MusicVo() {}
	public MusicVo(int musicNo, int emoNo, String musicTitle, String artist, String musicPath) {
		super();
		this.musicNo = musicNo;
		this.emoNo = emoNo;
		this.musicTitle = musicTitle;
		this.artist = artist;
		this.musicPath = musicPath;
	}
	
	
	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	public int getEmoNo() {
		return emoNo;
	}
	public void setEmoNo(int emoNo) {
		this.emoNo = emoNo;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getMusicPath() {
		return musicPath;
	}
	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}
	
	
	
	@Override
	public String toString() {
		return "MusicVo [musicNo=" + musicNo + ", emoNo=" + emoNo + ", musicTitle=" + musicTitle + ", artist=" + artist
				+ ", musicPath=" + musicPath + "]";
	}
	
}

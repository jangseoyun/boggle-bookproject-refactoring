package com.javaex.vo;

public class StyleVo {
	
	private int styleNo;
	private int emoNo;
	private String styleName;
	private String emoName;
	private String imgurl;
	private String videourl;
	
	
	public StyleVo() {}
	public StyleVo(int styleNo, int emoNo, String styleName, String emoName) {
		super();
		this.styleNo = styleNo;
		this.emoNo = emoNo;
		this.styleName = styleName;
		this.emoName = emoName;
	}
	public StyleVo(int styleNo, int emoNo, String styleName, String emoName, String imgurl, String videourl) {
		super();
		this.styleNo = styleNo;
		this.emoNo = emoNo;
		this.styleName = styleName;
		this.emoName = emoName;
		this.imgurl = imgurl;
		this.videourl = videourl;
	}



	
	public int getStyleNo() {
		return styleNo;
	}
	public void setStyleNo(int styleNo) {
		this.styleNo = styleNo;
	}
	public int getEmoNo() {
		return emoNo;
	}
	public void setEmoNo(int emoNo) {
		this.emoNo = emoNo;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public String getEmoName() {
		return emoName;
	}
	public void setEmoName(String emoName) {
		this.emoName = emoName;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getVideourl() {
		return videourl;
	}
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	
	
	
	
	@Override
	public String toString() {
		return "StyleVo [styleNo=" + styleNo + ", emoNo=" + emoNo + ", styleName=" + styleName + ", emoName=" + emoName
				+ ", imgurl=" + imgurl + ", videourl=" + videourl + "]";
	}
	
}

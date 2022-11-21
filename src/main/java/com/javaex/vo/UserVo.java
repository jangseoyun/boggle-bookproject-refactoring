package com.javaex.vo;

public class UserVo {

	private int userNo;
	private String userName;
	private String nickname;
	private String email;
	private String password;
	private String userProfile;
	private String joinDate;


	public UserVo() {}
	public UserVo(int userNo, String userName, String nickname) {
		this.userNo = userNo;
		this.userName = userName;
		this.nickname = nickname;
	}
	public UserVo(int userNo, String userName, String nickname, String email, String password, String userProfile,
			String joinDate) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.userProfile = userProfile;
		this.joinDate = joinDate;
	}


	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", userName=" + userName + ", nickname=" + nickname + ", email=" + email
				+ ", password=" + password + ", userProfile=" + userProfile + ", joinDate=" + joinDate + "]";
	}


}

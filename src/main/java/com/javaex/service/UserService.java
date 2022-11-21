package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Repository
public class UserService {
	
	//필드
	@Autowired
	private UserDao userDao;
	
	
	//로그인, 입력값 > 넘버, 이름 돌려주는 메소드
	public UserVo login(UserVo userVo) {
		System.out.println("UserService.login()");
		
		UserVo authUser = userDao.checkUser(userVo);
		
		return authUser;
	}
	
	//유저닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드
	public UserVo getUser(String nickname) {
		System.out.println("UserService.getUser()");
		
		UserVo otherUser = userDao.getUser(nickname);
		
		return otherUser;
	}
	
	//파라미터값 넣은 userVo 인서트
	public void insert(UserVo userVo) {
		System.out.println("UserService.insert()");
		
		userDao.insert(userVo);
	}
	
	//닉네임체크
	public int nickcheck(String nickname) {
		System.out.println("UserService.nickcheck()");
		
		int cnt = userDao.nickcheck(nickname);
		
		return cnt;
	}
}

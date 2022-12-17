package com.javaex.dao;

import com.javaex.dto.user.JoinDto;
import com.javaex.dto.user.LoginDto;
import com.javaex.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
@Lazy
@Mapper
@Repository
public interface UserDao {

	//이메일 존재 체크
	JoinDto selectUser(String email);
	//회원가입
	int join(JoinDto joinRequest);
	//로그인
	LoginDto login(String email);
	//단일 유저 조회
	UserDto findByUserEmail(String email);

	UserDto findByNickname(String nickname);
}

package com.javaex.dao;

import com.javaex.dto.user.JoinDto;
import com.javaex.dto.user.LoginDto;
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

	//닉네임체크
	/*public int nickcheck(String nickname) {
		System.out.println("UserService.nickcheck()");

		int cnt = sqlSession.selectOne("user.nickcheck",nickname);

		return cnt;
	}*/

}

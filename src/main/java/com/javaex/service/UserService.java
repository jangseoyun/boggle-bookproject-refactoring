package com.javaex.service;

import com.javaex.dao.UserDao;
import com.javaex.dto.user.*;
import com.javaex.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder encoder;
    @Value("${jwt.token.secret}")
    private String secretKey;
    private long expireTime = 1000 * 60 * 60;

    public UserResponse join(JoinDto joinRequest) {
        //아이디 존재 확인
        JoinDto getUser = userDao.selectUser(joinRequest.getEmail());
        log.info("getUser:{}", getUser);
        if (getUser == null) {
            String passwordEncode = encoder.encode(joinRequest.getPassword());
            JoinDto encodeJoinDto = new JoinDto(passwordEncode, joinRequest);
            int joinUser = userDao.join(encodeJoinDto);
            return UserResponse.success(encodeJoinDto);//TODO: 아이디까지 가지고 오려면 다시 find 해야함
        } else {
            return UserResponse.error("이미 존재하는 이메일 입니다");
        }
    }

    //로그인
    public String login(LoginRequest loginRequest) {
        LoginDto userLogin = userDao.login(loginRequest.getEmail());
        log.info("getUser:{}", userLogin);

        if (userLogin == null) {
            new NotFoundException("가입된 회원이 아닙니다. 다시 시도해 주세요");
        }

        //비밀번호 일치 확인
        if (!encoder.matches(loginRequest.getPassword(), userLogin.getPassword())) {
            new InvalidKeyException("비밀번호를 다시 입력해 주새요");
        }

        //정상 로그인시 토큰 발행
        return JwtUtil.createToken(userLogin.getEmail(), secretKey, expireTime);
    }

    //단일 유저 이메일 조회
    public UserDto findByUserEmail(String email) {
        return userDao.findByUserEmail(email);
    }
}

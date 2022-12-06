package com.javaex.service;

import com.javaex.dao.UserDao;
import com.javaex.dto.user.JoinDto;
import com.javaex.dto.user.JoinResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder encoder;

    public JoinResponse join(JoinDto joinRequest) {
        //아이디 존재 확인
        JoinDto getUser = userDao.selectUser(joinRequest.getEmail());
        log.info("getUser:{}", getUser);
        if (getUser == null) {
            String passwordEncode = encoder.encode(joinRequest.getPassword());
            JoinDto encodeJoinDto = new JoinDto(passwordEncode, joinRequest);
            int joinUser = userDao.join(encodeJoinDto);
            return JoinResponse.success(encodeJoinDto);//TODO: 아이디까지 가지고 오려면 다시 find 해야함
        } else {
            return JoinResponse.error("이미 존재하는 이메일 입니다");
        }
    }

    //유저닉네임을 주면 유저넘버, 닉네임, 프로필이미지를 주는 메소드
    /*public UserVo getUser(String nickname) {
        log.info("getUser()");
        UserVo otherUser = userDao.getUser(nickname);
        return otherUser;
    }

    //파라미터값 넣은 userVo 인서트
    public void insert(UserVo userVo) {
        log.info("insert()");
        userDao.insert(userVo);
    }

    //닉네임체크
    public int nickcheck(String nickname) {
        log.info("nickcheck()");
        int cnt = userDao.nickcheck(nickname);
        return cnt;
    }*/
}

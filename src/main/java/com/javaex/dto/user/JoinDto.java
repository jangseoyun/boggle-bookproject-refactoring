package com.javaex.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {
    private Long userNo;
    private String userName;
    private String nickname;
    private String email;
    private String password;
    private String userProfile;
    private String joinDate;

    public JoinDto(String encodePassword, JoinDto joinRequest) {
        this.userNo = userNo;
        this.userName = joinRequest.getUserName();
        this.nickname = joinRequest.getNickname();
        this.email = joinRequest.getEmail();
        this.password = encodePassword;
        this.userProfile = joinRequest.getUserProfile();
        this.joinDate = joinDate;
    }
}

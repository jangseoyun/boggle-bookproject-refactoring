package com.javaex.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String nickname;
    private String password;
    private Long userNo;
    private String userProfile;
}

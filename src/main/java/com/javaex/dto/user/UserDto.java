package com.javaex.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userNo;
    private String email;
    private String username;
    private String nickname;
    private String userProfile;
    private String role;
}

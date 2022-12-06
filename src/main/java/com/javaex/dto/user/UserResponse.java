package com.javaex.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse<T> {
    private String resultCode;
    private T result;

    public static UserResponse<Void> error(String resultCode) {
        return new UserResponse(resultCode, null);
    }

    public static <T> UserResponse<T> success(T result) {
        return new UserResponse("SUCCESS", result);
    }
}

package com.javaex.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinResponse<T> {
    private String resultCode;
    private T result;

    public static JoinResponse<Void> error(String resultCode) {
        return new JoinResponse(resultCode, null);
    }

    public static <T> JoinResponse<T> success(T result) {
        return new JoinResponse("SUCCESS", result);
    }
}

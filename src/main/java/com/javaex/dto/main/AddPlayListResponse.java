package com.javaex.dto.main;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class AddPlayListResponse {
    private int addResultCode;
    private String addResult;

    public AddPlayListResponse(int addResultCode) {
        this.addResultCode = addResultCode;
        this.addResult = addResult(addResultCode);
    }

    private String addResult(int addResultCode) {
        if (addResultCode == 1) {
            return addResult = "성공적으로 플레이리스트에 추가되었습니다";
        } else {
            return "다시 시도해 주세요";
        }
    }
}

package com.javaex.dto.reviewwrite;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class EmotionStyleResponse {
    private List<StyleDto> emotionListResult;
}

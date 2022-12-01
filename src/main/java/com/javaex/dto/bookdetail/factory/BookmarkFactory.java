package com.javaex.dto.bookdetail.factory;

import com.javaex.dto.bookdetail.BookMarkResponse;

public class BookmarkFactory {
    public static BookMarkResponse createResponse(int result, String bookNo) {
        return new BookMarkResponse(bookNo, setMarkResult(result),setMessage(result));
    }

    private static String setMessage(int result) {
        if (result == 1) {
            return "요청하신 북마크 기능을 성공적으로 마쳤습니다";
        }
        return "정상적으로 처리하지 못했습니다. 다시 시도해 주세요";
    }

    private static boolean setMarkResult(int result) {
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}

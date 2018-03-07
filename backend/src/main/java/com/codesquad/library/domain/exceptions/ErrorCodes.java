package com.codesquad.library.domain.exceptions;

import lombok.Getter;

import java.util.Arrays;

import static com.codesquad.library.domain.exceptions.ErrorCodes.NoCodeFoundException.STD_ERROR_MSG;

@Getter
public enum ErrorCodes {

    NOT_FOUND(10, "ITEM NOT FOUND"),
    NOT_MATCH(11, "ITEM REQUESTED DOES NOT MATCH"),
    INTERNAL_ERROR(20, "INTERNAL ERROR OCCURRED");

    public int code;
    public String message;

    ErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCodes findByCode(int code) {
        return Arrays.stream(ErrorCodes.values()).filter(c -> c.isMatchingCode(code)).findFirst().orElseThrow(() -> new NoCodeFoundException(STD_ERROR_MSG));
    }

    private boolean isMatchingCode(int code) {
        return code == this.code;
    }

    static class NoCodeFoundException extends RuntimeException {

        public static final String STD_ERROR_MSG = "조건에 맞는 코드가 검색되지 않았습니다.";

        NoCodeFoundException(String message) {
            super(message);
        }
    }
}

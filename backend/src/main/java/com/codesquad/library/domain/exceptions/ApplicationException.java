package com.codesquad.library.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

@Getter
public class ApplicationException extends RuntimeException {

    private ErrorCodes code;
    private HttpStatus status;
    private String message;

    public ApplicationException(String message) {
        super(message);
        this.code = ErrorCodes.INTERNAL_ERROR;
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = "unexpected internal error occurred.";
    }

    public ApplicationException(ErrorCodes code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
        this.message = message;
    }

}

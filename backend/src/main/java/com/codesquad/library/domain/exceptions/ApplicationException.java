package com.codesquad.library.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {

    private ErrorCodes code;
    private HttpStatus status;
    private String message;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(ErrorCodes code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
        this.message = message;
    }
}

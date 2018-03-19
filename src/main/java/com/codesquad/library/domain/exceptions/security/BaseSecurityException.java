package com.codesquad.library.domain.exceptions.security;

import com.codesquad.library.domain.exceptions.ApplicationException;
import com.codesquad.library.domain.exceptions.ErrorCodes;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseSecurityException extends ApplicationException{

    private ErrorCodes code = ErrorCodes.SECURITY_ERROR;
    private HttpStatus status = HttpStatus.UNAUTHORIZED;
    private String message;

    public BaseSecurityException(ErrorCodes code, HttpStatus status, String message) {
        super(code, status, message);
        this.code = code;
        this.status = status;
        this.message = message;
    }
}

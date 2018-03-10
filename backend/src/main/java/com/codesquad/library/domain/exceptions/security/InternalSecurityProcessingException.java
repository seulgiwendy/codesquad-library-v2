package com.codesquad.library.domain.exceptions.security;

import com.codesquad.library.domain.exceptions.ErrorCodes;
import org.springframework.http.HttpStatus;

public class InternalSecurityProcessingException extends BaseSecurityException {

    public InternalSecurityProcessingException(ErrorCodes code, HttpStatus status, String message) {
        super(code, status, message);
    }
}

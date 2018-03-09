package com.codesquad.library.security.filters;

import com.codesquad.library.dtos.security.FormLoginDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormLoginFilter extends AbstractAuthenticationProcessingFilter {

    private static final Logger log = LoggerFactory.getLogger(FormLoginFilter.class);

    private AuthenticationManager authenticationManager;

    public FormLoginFilter(String defaultFilterProcessingUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessingUrl);
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        FormLoginDocument document = null;

        try {
            document = new ObjectMapper().readValue(httpServletRequest.getInputStream(), FormLoginDocument.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(document, document.getPassword(), null));
    }
}

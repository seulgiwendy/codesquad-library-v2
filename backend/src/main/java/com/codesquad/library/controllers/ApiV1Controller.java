package com.codesquad.library.controllers;

import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.utils.JwtParsingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class ApiV1Controller {

    @Autowired
    private JwtParsingUtils parsingUtils;

    @GetMapping("/userinfo")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Member getUserinfo(OAuth2Authentication authentication) {
        return parsingUtils.getLoggedInMember(authentication);
    }
}

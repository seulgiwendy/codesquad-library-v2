package com.codesquad.library.domain.authentication;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Arrays;

public class ActiveUser extends User {

    private final Member member;

    public ActiveUser(Member member) {
        super(member.getLoginEmail(), member.getPassword(), Arrays.asList(new SimpleGrantedAuthority(member.getRoles().getRole())));
        this.member = member;
    }
}

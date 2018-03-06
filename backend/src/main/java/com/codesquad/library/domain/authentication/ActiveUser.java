package com.codesquad.library.domain.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;

public class ActiveUser extends User {

    public ActiveUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public ActiveUser(Member member) {
        super(member.getLoginEmail(), member.getPassword(), Arrays.asList(new SimpleGrantedAuthority(member.getRoles().getRole())));
    }
}

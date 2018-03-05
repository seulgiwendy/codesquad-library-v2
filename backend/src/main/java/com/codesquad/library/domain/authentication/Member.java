package com.codesquad.library.domain.authentication;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
public class Member {

    @Id
    @GeneratedValue
    private long userId;

    @Email
    @NotNull
    private String loginEmail;

    @NotNull
    private String password;
}

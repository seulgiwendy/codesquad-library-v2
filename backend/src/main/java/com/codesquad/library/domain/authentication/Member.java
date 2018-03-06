package com.codesquad.library.domain.authentication;

import com.codesquad.library.domain.Book;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Member {

    @Getter
    public enum MemberRoles {
        ADMIN("ADMIN"), USER("USER");

        private String role;

        MemberRoles(String role) {
            this.role = role;
        }
    }

    @Id
    @GeneratedValue
    private long userId;

    @Email
    @NotNull
    private String loginEmail;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private MemberRoles roles;

    @Column(name = "SLACK_ID")
    private String slackId;

    @Column(name = "REAL_NAME")
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Book> lendedBooks = Lists.newArrayList();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return userId == member.userId &&
                Objects.equal(loginEmail, member.loginEmail) &&
                Objects.equal(password, member.password) &&
                Objects.equal(slackId, member.slackId) &&
                Objects.equal(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, loginEmail, password, slackId, name);
    }
}

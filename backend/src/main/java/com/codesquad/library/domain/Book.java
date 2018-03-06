package com.codesquad.library.domain;

import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.constraints.LongerThan;
import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = "member")
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private long id;

    @NotNull
    private String title;

    @LongerThan(message = "설명은 30자 이상이여야 합니다.", length = 30)
    @Column(name = "BOOK_DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "RENT_MEMBER_ID")
    private Member member;

    private boolean isPossessed;

    @Column(name = "BOOK_ISBN")
    private int isbn;

    @Column(name = "LAST_RENT_DATE")
    private LocalDateTime lastRentDate;

    @Column(name = "RENT_ELAPSED_DATE")
    private int elapsedDate;

    public void setPossessed(Member member) {
        this.isPossessed = true;
        this.lastRentDate = LocalDateTime.now();
        this.member = member;
        if(member.getLendedBooks() == null) {
            member.setLendedBooks(Lists.newArrayList());
        }
        member.getLendedBooks().add(this);
    }
}

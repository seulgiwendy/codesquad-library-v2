package com.codesquad.library.domain;

import com.codesquad.library.domain.authentication.Member;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "REVIEW_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Size(max = 300, message = "서평은 300자를 초과할 수 없습니다.")
    @Nullable
    @Column(name = "REVIEW_CONTENT", columnDefinition = "TEXT NULL")
    private String content;

}

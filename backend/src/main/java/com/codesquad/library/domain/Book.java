package com.codesquad.library.domain;

import com.codesquad.library.domain.constraints.LongerThan;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
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


}

package com.codesquad.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "AUTHOR_ID")
    private long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

}

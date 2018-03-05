package com.codesquad.library.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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

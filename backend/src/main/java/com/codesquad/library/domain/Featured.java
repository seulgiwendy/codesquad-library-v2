package com.codesquad.library.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class Featured extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "FEATURED_ID")
    private long id;

    @OneToMany
    private List<Book> books;

    private String title;

}

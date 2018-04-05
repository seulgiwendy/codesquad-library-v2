package com.codesquad.library.domain;

import com.codesquad.library.dtos.model.featured.NewFeaturedDocument;
import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class Featured extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "FEATURED_ID")
    private long id;

    @OneToMany(mappedBy = "featured", cascade = CascadeType.ALL)
    private List<Book> books;

    @Column(name = "FEATURED_TEXT_CONTENT", columnDefinition = "VARCHAR(200)")
    private String content;

    @Column(name = "FEATURED_UID")
    private String featureCode;

    private String title;

    public void addBook(Book book) {
        if (this.books == null) {
            this.books = Lists.newArrayList();
        }

        this.books.add(book);

        book.setFeatured(this);
    }

    public void setBooks(List<Book> books) {
        this.books = books;

        books.stream().forEach(b -> b.setFeatured(this));
    }

    public static Featured getObjectByDocument(NewFeaturedDocument document) {
        return Featured.builder()
                .title(document.getTitle())
                .content(document.getContent())
                .build();
    }

    public long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getContent() {
        return content;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public String getTitle() {
        return title;
    }
}

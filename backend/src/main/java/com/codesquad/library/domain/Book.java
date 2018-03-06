package com.codesquad.library.domain;

import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.constraints.LongerThan;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = Lists.newArrayList();

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @ManyToOne(cascade = CascadeType.MERGE)
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

        if(this.member != null) {
            this.member.getLendedBooks().remove(this);
        }

        this.member = member;
        if(member.getLendedBooks() == null) {
            member.setLendedBooks(Lists.newArrayList());
        }

        member.getLendedBooks().add(this);
    }

    public void returnBook(Member member) {
        if(member.equals(this.member)) {
            this.member = null;
            this.isPossessed = false;
            this.elapsedDate = 0;
            member.getLendedBooks().remove(this);
        }
    }

    public void addReview(Review review) {
        if (this.reviews == null) {
            this.reviews = Lists.newArrayList();
        }

        this.reviews.add(review);
        review.setBook(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equal(title, book.title) &&
                Objects.equal(description, book.description) &&
                Objects.equal(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, description, author);
    }
}

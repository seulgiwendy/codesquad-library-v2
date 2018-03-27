package com.codesquad.library.domain;

import lombok.Getter;

@Getter
public enum BookSearchCriteria {

    TITLE("제목"),
    AUTHOR("저자"),
    ISBN("ISBN");

    public String canonicalCategory;

    BookSearchCriteria(String canonicalCategory) {
        this.canonicalCategory = canonicalCategory;
    }
}

package com.codesquad.library.domain;

import com.codesquad.library.domain.exceptions.model.NoCategoryMatchingException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum BookSearchCriteria {

    TITLE("제목"),
    AUTHOR("저자"),
    ISBN("ISBN");

    public String canonicalCategory;

    private boolean isCorrectLabel(String label) {
        return label.equalsIgnoreCase(this.name());
    }

    public static BookSearchCriteria findByLabel(String label) {
        return Arrays.stream(BookSearchCriteria.values()).filter(c -> c.isCorrectLabel(label)).findFirst().orElseThrow(() -> new NoCategoryMatchingException("올바른 검색기준이 아닙니다."));
    }

    BookSearchCriteria(String canonicalCategory) {
        this.canonicalCategory = canonicalCategory;
    }
}

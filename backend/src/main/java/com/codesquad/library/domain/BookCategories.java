package com.codesquad.library.domain;

import com.codesquad.library.domain.exceptions.model.NoCategoryMatchingException;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum BookCategories {

    SOFTWARE_ENGINEERING(0, "소프트웨어공학"),
    JAVA(1, "자바"),
    SWIFT(2, "스위프트"),
    JAVASCRIPT(3, "자바스크립트"),
    DATABASE(4, "데이터베이스"),
    HTML_CSS(5, "HTML, CSS, 마크업"),
    DEVELOPMENT_METHODOLOGIES(6, "개발방법론(xDD)"),
    HUMAN_COMPUTER_INTERACTION(7, "유저인터페이스, HCI"),
    GENERAL(8, "일반"),
    BUSINESS(9, "경영, 창업");

    private int code;

    @JsonValue
    private String label;

    BookCategories(int code, String label) {
        this.code = code;
        this.label = label;
    }

    private boolean isMatchingLabel(String label) {
        return label.equals(this.label);
    }

    public static BookCategories findByLabel(String label) {
        return Arrays.stream(BookCategories.values()).filter(c -> c.isMatchingLabel(label)).findFirst().orElseThrow(() -> new NoCategoryMatchingException());
    }
}

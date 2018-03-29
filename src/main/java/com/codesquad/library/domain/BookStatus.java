package com.codesquad.library.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

@Getter
public enum BookStatus {
    RENT_AVAILABLE("대여가능", Glyphicons.OK),
    RENT_OCCUPIED("대여중", Glyphicons.NOT_AVAILABLE),
    CATEGORIES("상세정보", Glyphicons.DETAILS);

    private String code;
    private Glyphicons glyphicons;

    BookStatus(String code, Glyphicons glyphicons) {
        this.code = code;
        this.glyphicons = glyphicons;
    }

    public static List<BookStatus> generateStatus(Book book) {
        List<BookStatus> statuses = Lists.newArrayList();

        if(book.isPossessed()) {
            statuses.add(BookStatus.RENT_OCCUPIED);
        }
        statuses.add(BookStatus.RENT_AVAILABLE);

        return statuses;
    }

    enum Glyphicons {
        OK("OK"),
        NOT_AVAILABLE("REMOVE"),
        DETAILS("SEARCH"),
        CATEGORY("TAG");

        @JsonValue
        private String tag;

        Glyphicons(String tag) {
            this.tag = tag;
        }

    }
}



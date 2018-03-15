package com.codesquad.library.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum BookLocations {

    FRONT_DOOR_SIDE("문옆 책장"), FRONTEND_GROUP_SIDE("프론트엔드반 옆 책장"), BACKEND_SIDE("백엔드방 뒤 책장");

    @JsonValue
    private String canonicalLocation;

    BookLocations(String canonicalLocation) {
        this.canonicalLocation = canonicalLocation;
    }
}

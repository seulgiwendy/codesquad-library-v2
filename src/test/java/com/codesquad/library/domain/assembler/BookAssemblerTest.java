/*
 * Copyright (c) wheejuni tech 2018.
 *
 * Proudly developed by Hwi Jun Jeong,
 * Inspired by Bomee, the smartest puppy of the Galaxy.
 *
 * me@wheejuni.com
 * https://github.com/seulgiwendy
 */

package com.codesquad.library.domain.assembler;

import com.codesquad.library.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BookAssemblerTest {
    private static final Logger log = LoggerFactory.getLogger(BookAssemblerTest.class);

    private BookAssembler bookAssembler = new BookAssembler();
    private Book book;

    @Before
    public void setUp() {
        this.book = Book.builder()
                .description("sadjflksajdf;lkajsdklfjsalk;dfjklasdjfklsajdfkl;")
                .title("sdjfkl;")
                .author(Author.builder().name("이말년").build())
                .isbn("asdfjaskldjflas1213")
                .bookCategories(BookCategories.BUSINESS)
                .bookLocations(BookLocations.BACKEND_SIDE)
                .reviews(Arrays.asList(Review.builder().title("asdfasdf").content("aslkdjflkas;df").score(3.5F).build(),
                Review.builder().title("asdfjksd").content("asdfasdfasdfasd").score(4.0F).build()))
                .build();
    }

    @Test
    public void ASSEMBLER_DOCUMENT_WRITE_TEST() throws JsonProcessingException{
        log.debug(new ObjectMapper().writeValueAsString(bookAssembler.writeBookDocument(this.book)));
    }

}
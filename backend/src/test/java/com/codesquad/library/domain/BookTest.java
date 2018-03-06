package com.codesquad.library.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.validation.Validator;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookTest {

    private static final Logger log = LoggerFactory.getLogger(BookTest.class);

    @Autowired
    private Validator validator;

    private Book book;

    @Before
    public void setUp() {
        this.book = Book.builder()
                .title("이말년씨리즈")
                .description("이말년 씨리즈~")
                .build();
    }

    @Test
    public void BEAN_VALIDATION_TEST() {
        log.debug(validator.validate(book).stream().findFirst().get().getMessage());
        assertTrue(validator.validate(book).stream().findFirst().isPresent());
    }


}
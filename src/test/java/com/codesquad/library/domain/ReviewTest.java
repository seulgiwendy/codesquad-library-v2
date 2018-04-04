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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReviewTest {

    private static final Logger log = LoggerFactory.getLogger(ReviewTest.class);

    @Autowired
    private Validator validator;

    private Review review;

    @Before
    public void setUp() {
        this.review = Review.builder().score(1.3F).content("asdjf").title("재밌던 것 같아요").build();

    }

    @Test
    public void CONSTRAINT_TEST() {
        validator.validate(this.review).stream().forEach(v -> log.debug(v.getMessage()));

        assertThat(validator.validate(this.review).size(), is(1));
    }

}
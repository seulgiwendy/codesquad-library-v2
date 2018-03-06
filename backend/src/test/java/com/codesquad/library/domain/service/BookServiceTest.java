package com.codesquad.library.domain.service;

import com.codesquad.library.domain.Book;
import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.repositories.BookRepository;
import com.codesquad.library.domain.repositories.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    private Book book;
    private Member member;

    @Before
    public void setUp() {
        this.book = Book.builder()
                .description("지상 최강의 만화책! 삼류 스트리머 침착맨과 구분되는 킹갓말년의 컴백작! 이말년 씨~리~즈~!!!")
                .title("이말년씨리즈")
                .build();

        this.member = Member.builder()
                .loginEmail("lemon@codesquad.kr")
                .password("1234")
                .name("양희정")
                .build();

        this.book = bookRepository.save(this.book);
        this.member = memberRepository.save(this.member);
    }

    @Test
    @Transactional
    public void RENT_BY_SERVICE_CLASS() {
        this.bookService.borrowBookbyBookid(this.member, 1L);

        assertThat(bookRepository.findByTitle("이말년씨리즈").get().getMember(), is(this.member));

        this.bookService.returnBookbyBookId(this.member, 1L);
        assertNull(bookRepository.findByTitle("이말년씨리즈").get().getMember());

        assertThat(bookRepository.findByTitle("이말년씨리즈").get().isPossessed(), is(false));
    }


}
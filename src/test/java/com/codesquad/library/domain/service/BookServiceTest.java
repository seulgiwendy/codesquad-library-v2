package com.codesquad.library.domain.service;

import com.codesquad.library.domain.Author;
import com.codesquad.library.domain.Book;
import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.repositories.BookRepository;
import com.codesquad.library.domain.repositories.MemberRepository;
import com.codesquad.library.domain.service.book.BookService;
import com.codesquad.library.dtos.model.book.NewBookDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTest {

    private static final Logger log = LoggerFactory.getLogger(BookServiceTest.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    private NewBookDocument newBookDocument;
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

        this.book.setAuthor(Author.builder().name("이말년").build());

        this.book = bookRepository.save(this.book);
        this.member = memberRepository.save(this.member);
        this.newBookDocument = new NewBookDocument("이말년 수필", "이말년", "지상 최강의 만화책! 삼류 스트리머 침착맨과 구분되는 킹갓말년의 컴백작! 이말년 씨~리~즈~!!!", "82101089", null, null);
    }

    @After
    public void flushDatabase() {
        this.bookRepository.deleteAll();
    }

    @Test
    public void RENT_BY_SERVICE_CLASS() {
        this.bookService.borrowBookByTitle(this.member, "이말년씨리즈");

        assertThat(bookRepository.findByTitle("이말년씨리즈").get().getMember(), is(this.member));

    }

    @Test
    @Transactional
    public void ADD_BOOK_BY_DTO() {
        this.bookService.addBook(this.newBookDocument);
        Optional<Book> targetBook = bookRepository.findByTitle("이말년 수필");


        assertThat(targetBook.isPresent(), is(true));
        assertThat(targetBook.get().getAuthor().getName(), is("이말년"));

    }

    @Test
    public void GET_ALL_BOOKS_DTO() throws Exception {
        log.debug(new ObjectMapper().writeValueAsString(this.bookService.getAllBooks()));
    }


}
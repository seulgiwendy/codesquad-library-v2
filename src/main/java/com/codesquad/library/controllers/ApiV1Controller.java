package com.codesquad.library.controllers;

import com.codesquad.library.domain.Book;
import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.service.BookService;
import com.codesquad.library.domain.service.IsbnBookSearchService;
import com.codesquad.library.dtos.model.book.BookSearchDocument;
import com.codesquad.library.utils.JwtParsingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class ApiV1Controller {

    @Autowired
    private JwtParsingUtils parsingUtils;

    @Autowired
    private BookService bookService;

    @Autowired
    private IsbnBookSearchService searchService;

    @GetMapping("/userinfo")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Member getUserinfo(OAuth2Authentication authentication) {
        return parsingUtils.getLoggedInMember(authentication);
    }

    @PostMapping("/book")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Book newBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/newbook/{isbn}")
    @CrossOrigin
    public BookSearchDocument searchIsbn(@PathVariable long isbn) {
        return searchService.getBookInfo(isbn);
    }
}

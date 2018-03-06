package com.codesquad.library.domain.service;

import com.codesquad.library.domain.Book;
import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book borrowBook(Member member, Book book) {
        book.setPossessed(member);

        return bookRepository.save(book);
    }

    public Book borrowBookbyBookid(Member member, long bookId) {
        Book book = bookRepository.findById(bookId).get();

        book.setPossessed(member);

        return book;
    }

}

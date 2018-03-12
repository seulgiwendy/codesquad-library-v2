package com.codesquad.library.domain.service;

import com.codesquad.library.domain.Author;
import com.codesquad.library.domain.Book;
import com.codesquad.library.domain.authentication.Member;
import com.codesquad.library.domain.exceptions.model.NoBookExistsException;
import com.codesquad.library.domain.repositories.AuthorRepository;
import com.codesquad.library.domain.repositories.BookRepository;
import com.codesquad.library.dtos.model.NewBookDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book borrowBook(Member member, Book book) {
        book.setPossessed(member);

        return bookRepository.save(book);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book addBook(NewBookDocument document) {
        Book book = Book.builder()
                .title(document.getTitle())
                .description(document.getDescription())
                .isbn(Integer.parseInt(document.getIsbn()))
                .build();

        Author author = authorRepository.findByName(document.getAuthor()).orElse(
                Author.builder()
                .name(document.getAuthor())
                .build()
        );

        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public Book borrowBookbyBookid(Member member, long bookId) {
        Book book = bookRepository.findById(bookId).get();

        book.setPossessed(member);

        return book;
    }

    public Book borrowBookByTitle(Member member, String bookTitle) {
        Book book = bookRepository.findByTitle(bookTitle).orElseThrow(() -> new NoBookExistsException("제목으로 검색된 책이 없습니다."));

        book.setPossessed(member);
        return book;
    }

    public Book returnBookbyBookId(Member member, long bookId) {
        Book book = bookRepository.findById(bookId).get();

        //TODO throws an exception if lender - requested member does not match.
        book.returnBook(member);
        return book;
    }

}

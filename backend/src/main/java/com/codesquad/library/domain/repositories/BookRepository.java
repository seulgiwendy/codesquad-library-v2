package com.codesquad.library.domain.repositories;

import com.codesquad.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findByTitle(String title);
}

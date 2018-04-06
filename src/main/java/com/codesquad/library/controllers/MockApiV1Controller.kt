package com.codesquad.library.controllers

import com.codesquad.library.domain.service.book.BookSearchService
import com.codesquad.library.domain.service.book.BookService
import com.codesquad.library.domain.service.FeaturedService
import com.codesquad.library.dtos.model.book.BookDocument
import com.codesquad.library.dtos.model.book.BookQueryDocument
import com.codesquad.library.dtos.model.book.SearchInfoDocument
import com.codesquad.library.dtos.model.featured.FeaturedDocument
import com.codesquad.library.dtos.model.tag.NewTagDocument
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/test/")
@RestController
class MockApiV1Controller constructor(private val bookService: BookService, private val bookSearchService: BookSearchService) {

    @Autowired
    lateinit var featuredService: FeaturedService

    @PostMapping("/search")
    fun getMockSearchResult(@RequestBody query: BookQueryDocument) : List<BookDocument> {
        return bookSearchService.search(query)
    }

    @GetMapping("/search")
    fun getSearchInfo() : SearchInfoDocument {
        return bookSearchService.getSearchInfo()
    }

    @GetMapping("/books/{id}")
    fun getBookInfo(@PathVariable id: Long) : BookDocument {
        return bookService.searchBookById(id)
    }

    @GetMapping("/featured/{code}")
    fun getFeatured(@PathVariable code: String) : FeaturedDocument {
        return featuredService.getFeatured(code);
    }

    @PostMapping("/tags")
    fun sendFeatured(@RequestBody document: NewTagDocument) {

    }

}
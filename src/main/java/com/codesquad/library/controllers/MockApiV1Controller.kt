package com.codesquad.library.controllers

import com.codesquad.library.domain.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/test/")
@RestController
class MockApiV1Controller constructor(private val bookService: BookService) {

    @GetMapping("/search")
    fun getMockSearchResult() {
        TODO("implement bookservice test query service first.")
    }
}
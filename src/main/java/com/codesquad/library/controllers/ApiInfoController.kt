package com.codesquad.library.controllers

import com.codesquad.library.domain.BookCategories
import com.codesquad.library.domain.BookLocations
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/info")
@RestController
@CrossOrigin
class ApiInfoController {

    @GetMapping("/categories")
    fun getCategories(): List<BookCategories> {
        return BookCategories.values().asList();
    }

    @GetMapping("/locations")
    fun getLocations(): List<BookLocations> {
        return BookLocations.values().asList();
    }
}
package com.codesquad.library.dtos.model.book

import com.codesquad.library.domain.BookSearchCriteria

data class BookQueryDocument(
        val criteria: BookSearchCriteria? = null,
        val query: String = ""
)
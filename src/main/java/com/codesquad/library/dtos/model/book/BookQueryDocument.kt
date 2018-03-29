package com.codesquad.library.dtos.model.book

import com.codesquad.library.domain.BookSearchCriteria

data class BookQueryDocument(
        val criteria: String = "",
        val query: String = ""
) {
    fun getCriteria() : BookSearchCriteria {
        return BookSearchCriteria.findByLabel(this.criteria)
    }
}
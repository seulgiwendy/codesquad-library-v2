package com.codesquad.library.dtos.model.book

import com.codesquad.library.domain.Author
import com.codesquad.library.domain.BookStatus
import com.codesquad.library.dtos.model.review.ReviewDocument

data class BookDocument(
        val type: String = "book",
        val bookId: Long,
        val title: String,
        val description: String,
        val reviews: List<ReviewDocument>,
        val author: Author,
        val possessed: Boolean,
        val seriesNumber: Int,
        val status: BookStatus? = null
)
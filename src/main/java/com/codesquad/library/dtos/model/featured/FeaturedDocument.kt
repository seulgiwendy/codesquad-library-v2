/*
 * Copyright (c) wheejuni tech 2018.
 *
 * Proudly developed by Hwi Jun Jeong,
 * Inspired by Bomee, the smartest puppy of the Galaxy.
 *
 * me@wheejuni.com
 * https://github.com/seulgiwendy
 */

package com.codesquad.library.dtos.model.featured

import com.codesquad.library.dtos.model.book.BookDocument
import com.fasterxml.jackson.annotation.JsonProperty

data class FeaturedDocument(
        val title: String? = "",
        val content: String? = "",

        @field:JsonProperty("featuredBooks")
        val books: List<BookDocument>
)
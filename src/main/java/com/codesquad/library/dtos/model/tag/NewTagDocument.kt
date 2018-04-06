/*
 * Copyright (c) wheejuni tech 2018.
 *
 * Proudly developed by Hwi Jun Jeong,
 * Inspired by Bomee, the smartest puppy of the Galaxy.
 *
 * me@wheejuni.com
 * https://github.com/seulgiwendy
 */

package com.codesquad.library.dtos.model.tag

import com.codesquad.library.domain.Tag
import com.fasterxml.jackson.annotation.JsonProperty

data class NewTagDocument(
        @field:JsonProperty("tagTitle")
        val title: String,

        @field:JsonProperty("bookId")
        val id: Long) {

    fun generateTag() : Tag {
        return Tag(name = this.title)
    }
}
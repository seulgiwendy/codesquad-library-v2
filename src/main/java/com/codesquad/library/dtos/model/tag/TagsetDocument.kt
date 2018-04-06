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

import com.codesquad.library.domain.TagSet
import com.fasterxml.jackson.annotation.JsonProperty

data class TagsetDocument(
        @field:JsonProperty("tagTitle")
        val title: String,

        @field:JsonProperty("tagsetId")
        val id: Long) {

    companion object {
        fun writeDocument(tagSet: TagSet) : TagsetDocument {
            return TagsetDocument(title = tagSet.tag!!.name!!, id = tagSet.id)
        }
    }
}
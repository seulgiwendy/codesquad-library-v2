package com.codesquad.library.dtos.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NewArticleDocument(
        @JsonProperty(value = "TITLE_ARTICLE") val title: String = "",
        val content: String = "",
        val urgent: Boolean = false)

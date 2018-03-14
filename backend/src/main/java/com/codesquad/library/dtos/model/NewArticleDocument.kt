package com.codesquad.library.dtos.model

data class NewArticleDocument(
        val title: String = "",
        val content: String = "",
        val urgent: Boolean = false
)
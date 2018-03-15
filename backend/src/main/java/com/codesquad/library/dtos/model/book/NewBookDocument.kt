package com.codesquad.library.dtos.model.book

data class NewBookDocument(
        val title : String = "",
        val author : String = "",
        val description : String = "",
        val isbn : String = "",
        val category : String? = "",
        val location : String? = ""
)
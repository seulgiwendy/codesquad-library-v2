package com.codesquad.library.dtos.model

data class NewBookDocument(
        val title : String = "",
        val author : String = "",
        val description : String = "",
        val isbn : String = ""
)
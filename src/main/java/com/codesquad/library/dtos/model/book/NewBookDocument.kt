package com.codesquad.library.dtos.model.book

import com.fasterxml.jackson.annotation.JsonProperty

data class NewBookDocument(

        @field:JsonProperty("booktitle")val title : String = "",
        val author : String = "",
        val description : String = "",
        val isbn : String = "",
        val category : String? = "",
        val location : String? = ""
)
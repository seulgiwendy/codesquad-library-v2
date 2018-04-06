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

import com.codesquad.library.domain.Featured
import com.fasterxml.jackson.annotation.JsonProperty

data class FeaturedLinkDocument(
        @field:JsonProperty("featuredTitle")
        val title: String,

        @field:JsonProperty("featuredHref")
        val link: String) {

    companion object {
        fun generateDocument(featured: Featured?) : FeaturedLinkDocument {

            if (featured == null) {
                return FeaturedLinkDocument(title = "없음", link = "undefined")
            }

            return FeaturedLinkDocument(title = featured.title, link = featured.featureCode)
        }
    }
}
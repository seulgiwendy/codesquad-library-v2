/*
 * Copyright (c) wheejuni tech 2018.
 *
 * Proudly developed by Hwi Jun Jeong,
 * Inspired by Bomee, the smartest puppy of the Galaxy.
 *
 * me@wheejuni.com
 * https://github.com/seulgiwendy
 */

package com.codesquad.library.domain.service

import com.codesquad.library.domain.Featured
import com.codesquad.library.domain.assembler.BookAssembler
import com.codesquad.library.domain.exceptions.model.NoFeaturedItemException
import com.codesquad.library.domain.repositories.FeaturedRepository
import com.codesquad.library.dtos.model.featured.FeaturedDocument
import org.springframework.stereotype.Service

@Service
open class FeaturedService constructor(val bookAssembler: BookAssembler, val featuredRepository: FeaturedRepository) {

    open fun getFeatured(featuredCode: String): FeaturedDocument {
        var featuredItem: Featured = featuredRepository.findByFeatureCode(featuredCode).orElseThrow { NoFeaturedItemException("제목에 맞는 Featured 항목이 없습니다.") }

        return FeaturedDocument(title = featuredItem.title, content = featuredItem.content, books = featuredItem.books.map { b -> b.generateDocument() })
    }

}
/*
 * Copyright (c) wheejuni tech 2018.
 *
 * Proudly developed by Hwi Jun Jeong,
 * Inspired by Bomee, the smartest puppy of the Galaxy.
 *
 * me@wheejuni.com
 * https://github.com/seulgiwendy
 */

package com.codesquad.library.domain.repositories

import com.codesquad.library.domain.Tag
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TagRepository : CrudRepository<Tag, Long> {

    open fun findByName(name: String) : Optional<Tag>
}
/*
 * Copyright (c) wheejuni tech 2018.
 *
 * Proudly developed by Hwi Jun Jeong,
 * Inspired by Bomee, the smartest puppy of the Galaxy.
 *
 * me@wheejuni.com
 * https://github.com/seulgiwendy
 */

package com.codesquad.library.domain

import javax.persistence.*

@Entity
@Table(name = "TAG")
data class Tag(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "TAG_ID")
        val id: Long? = null,

        val name: String? = null,

        @OneToMany(mappedBy = "tag", cascade = [CascadeType.ALL])
        var tagsets: MutableList<TagSet>)
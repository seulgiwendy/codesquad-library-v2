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

        @ManyToMany(mappedBy = "tags")
        var books: MutableList<Book>? = null)
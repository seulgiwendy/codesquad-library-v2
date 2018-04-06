package com.codesquad.library.domain

import javax.persistence.*

@Entity
@Table(name = "TAG_SET")
data class TagSet(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "TAGSET_ID")
        val id: Long = 0,

        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "BOOK_ID")
        var book: Book? = null,

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "TAG_ID")
        var tag: Tag? = null)
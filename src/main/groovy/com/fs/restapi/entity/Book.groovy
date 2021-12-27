package com.fs.restapi.entity

import javax.persistence.*

@Entity
@Table(name = "books") class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id
    @com.sun.istack.NotNull @Column(nullable = false) String name
    @com.sun.istack.NotNull @Column(nullable = false) String isbn
    @com.sun.istack.NotNull @Column(nullable = false) Integer category_id
}
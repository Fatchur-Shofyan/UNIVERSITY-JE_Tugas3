package com.fs.restapi.entity

import javax.persistence.*

@Entity
@Table(name = "categories") class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id
    @com.sun.istack.NotNull @Column(nullable = false) String name
}
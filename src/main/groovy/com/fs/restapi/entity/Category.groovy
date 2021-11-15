package com.fs.restapi.entity


import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.persistence.Column

@Entity
@Table(name = "categories") class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id
    @com.sun.istack.NotNull @Column(nullable = false) String name
}
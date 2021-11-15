package com.fs.Tugas3.entity

import javax.persistence.*
//import javax.persistence.Id
//import javax.persistence.GeneratedValue
//import javax.persistence.Table
//import javax.persistence.GenerationType
//import javax.persistence.Column
import javax.validation.constraints.NotNull

 @Entity
 @Table(name = "categories") class Category {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id
 @NotNull @Column(nullable = false) String name
 }
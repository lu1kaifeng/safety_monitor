package top.lu1kaifeng.playground.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val title: String
)

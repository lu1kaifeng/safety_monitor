package top.lu1kaifeng.playground.entity

import java.security.Principal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?, val userName: String, val password: String
)

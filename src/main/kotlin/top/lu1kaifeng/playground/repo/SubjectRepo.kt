package top.lu1kaifeng.playground.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import top.lu1kaifeng.playground.entity.Subject

@Repository
interface SubjectRepo : JpaRepository<Subject, Long> {
    fun findByUserNameAndPassword(userName: String, password: String): Subject?
}
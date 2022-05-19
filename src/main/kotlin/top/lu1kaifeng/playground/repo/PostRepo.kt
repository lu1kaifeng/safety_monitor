package top.lu1kaifeng.playground.repo

import org.springframework.data.jpa.repository.JpaRepository
import top.lu1kaifeng.playground.entity.Post

interface PostRepo : JpaRepository<Post, Long>
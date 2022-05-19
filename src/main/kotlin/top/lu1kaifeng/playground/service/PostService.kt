package top.lu1kaifeng.playground.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import top.lu1kaifeng.playground.entity.Post
import top.lu1kaifeng.playground.repo.PostRepo

@Service
class PostService constructor(private val postRepo: PostRepo) {
    fun getPostPage(page: Int, len: Int): Page<Post> {
        return postRepo.findAll(Pageable.ofSize(len).withPage(page))
    }
}
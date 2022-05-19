package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.entity.Post
import top.lu1kaifeng.playground.service.PostService


@RestController
class PostController @Autowired constructor(
    val postService: PostService
) : BaseSecuredController() {
    @PostMapping("/post/page")
    fun getPostPage(@RequestParam page: Int, @RequestParam len: Int): Page<Post> {
        return postService.getPostPage(page, len)
    }
}
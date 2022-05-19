package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.service.SubjectService

@RestController
class SubjectController @Autowired constructor(

    val subjectService: SubjectService
) : BaseSecuredController() {
    @PostMapping("/login")
    fun getPostPage(@RequestParam userName: String, @RequestParam password: String): String =
        subjectService.tokenCreate(userName, password)
}
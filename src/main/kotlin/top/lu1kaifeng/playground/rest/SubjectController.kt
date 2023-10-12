package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import top.lu1kaifeng.playground.service.SubjectService

@RestController
class SubjectController @Autowired constructor(

    val subjectService: SubjectService
) : BaseSecuredController() {
    @GetMapping("/login", produces = ["text/plain"])
    fun login(@RequestParam userName: String, @RequestParam password: String): String =
        subjectService.tokenCreate(userName, password)
}
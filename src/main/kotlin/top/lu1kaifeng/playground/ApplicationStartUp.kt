package top.lu1kaifeng.playground

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent

import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import top.lu1kaifeng.playground.entity.Post
import top.lu1kaifeng.playground.entity.Subject
import top.lu1kaifeng.playground.repo.PostRepo
import top.lu1kaifeng.playground.repo.SubjectRepo


@Component
class ApplicationStartUp @Autowired constructor(val subjectRepo: SubjectRepo, val postRepo: PostRepo) :
    ApplicationListener<ApplicationReadyEvent?> {
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        subjectRepo.save(Subject(null, "admin", "admin"))
        postRepo.save(Post(null, "asdas"))
        // here your code ...
        return
    }
}
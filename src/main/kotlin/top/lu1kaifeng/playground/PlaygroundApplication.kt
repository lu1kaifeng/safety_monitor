package top.lu1kaifeng.playground

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class PlaygroundApplication

fun main(args: Array<String>) {
    runApplication<PlaygroundApplication>(*args)
}

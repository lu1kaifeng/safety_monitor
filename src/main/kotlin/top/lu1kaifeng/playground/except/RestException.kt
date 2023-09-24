package top.lu1kaifeng.playground.except

import org.springframework.http.HttpStatus


open class RestException( val body: Any, val status: HttpStatus): RuntimeException()
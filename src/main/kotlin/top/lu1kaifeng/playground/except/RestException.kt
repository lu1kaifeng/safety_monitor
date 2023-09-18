package top.lu1kaifeng.playground.except

import org.springframework.http.HttpStatus

abstract class BaseRestException : RuntimeException() {
    interface ExceptionResponseBody

    abstract val body: ExceptionResponseBody
    abstract val status: HttpStatus
}

open class RestException(override val body: ExceptionResponseBody, override val status: HttpStatus) :
    BaseRestException()
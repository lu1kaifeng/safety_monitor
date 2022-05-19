package xyz.luchengeng.info.except

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import top.lu1kaifeng.playground.except.RestException

class NotAuthorizedException(message: String) : RestException(object : ExceptionResponseBody{},HttpStatus.FORBIDDEN)
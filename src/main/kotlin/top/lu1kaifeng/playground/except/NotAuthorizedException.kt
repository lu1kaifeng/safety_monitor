package xyz.luchengeng.info.except

import org.springframework.http.HttpStatus
import top.lu1kaifeng.playground.except.RestException

class NotAuthorizedException(message: String) : RestException(object : ExceptionResponseBody {}, HttpStatus.FORBIDDEN)
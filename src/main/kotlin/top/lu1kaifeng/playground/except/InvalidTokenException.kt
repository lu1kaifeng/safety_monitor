package top.lu1kaifeng.playground.except

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class InvalidTokenException : RestException(object : ExceptionResponseBody{},HttpStatus.UNAUTHORIZED)
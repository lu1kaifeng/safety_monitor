package top.lu1kaifeng.playground.except

import org.springframework.http.HttpStatus

class InvalidTokenException : RestException(object  {}, HttpStatus.UNAUTHORIZED)
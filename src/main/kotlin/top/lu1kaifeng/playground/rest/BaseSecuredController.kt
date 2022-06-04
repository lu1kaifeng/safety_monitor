package top.lu1kaifeng.playground.rest

import org.springframework.beans.factory.annotation.Autowired

abstract class BaseSecuredController(

) {
    @Autowired
    protected lateinit var securityContext: SecurityContext
}
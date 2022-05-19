package top.lu1kaifeng.playground.rest

import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope
import top.lu1kaifeng.playground.entity.Subject
import top.lu1kaifeng.playground.except.InvalidTokenException
import top.lu1kaifeng.playground.service.SubjectService
import xyz.luchengeng.info.except.NotAuthorizedException
import javax.servlet.http.HttpServletRequest

@Component
@RequestScope
class SecurityContext(request: HttpServletRequest, private val subjectService: SubjectService) {
    private val _token: DecodedJWT? = subjectService.authenticationFunction(request.getHeader("Authorization"))
    val loggedIn by lazy {
        _token !== null
    }

    val subject: Subject by lazy {
        if (_token !== null)
            subjectService.findByIdOrNull(_token.subject.toLong()) ?: throw NotAuthorizedException("User Not Found")
        else
            throw NotAuthorizedException("User Not Logged In")
    }

}
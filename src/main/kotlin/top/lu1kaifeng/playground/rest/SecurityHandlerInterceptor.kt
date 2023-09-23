package top.lu1kaifeng.playground.rest

import org.springframework.context.annotation.Configuration
import org.springframework.util.AntPathMatcher
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import xyz.luchengeng.info.except.NotAuthorizedException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
class SecurityHandlerInterceptor(private val securityContext: SecurityContext) : HandlerInterceptor, WebMvcConfigurer {
    private val matcher = AntPathMatcher()
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val path = request.requestURI.substring(request.contextPath.length)
        return when {
            "/login".antMatching(path) -> true
            "/sendfromdevice".antMatching(path)->true
            "/post/**".antMatching(path) ->
                if (securityContext.loggedIn) true else throw NotAuthorizedException("")
            "/temp/**".antMatching(path) ->
                if (securityContext.loggedIn) true else throw NotAuthorizedException("")
            "/device/**".antMatching(path) ->
                if (securityContext.loggedIn) true else throw NotAuthorizedException("")
            else -> throw NotAuthorizedException("")
        }
    }

    private fun String.antMatching(path: String) = matcher.match(this, path)
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(this)
    }
}
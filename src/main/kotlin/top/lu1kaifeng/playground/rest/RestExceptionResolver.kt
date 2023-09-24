package top.lu1kaifeng.playground.rest

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver
import top.lu1kaifeng.playground.except.RestException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class RestExceptionResolver : AbstractHandlerExceptionResolver() {
    init {
        order = HIGHEST_PRECEDENCE
    }
    override fun doResolveException(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any?,
        ex: Exception
    ): ModelAndView {
        response.contentType = "application/json"
        if (ex is RestException) {
            response.status = ex.status.value()
        }else{
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            ObjectMapper().writeValue(response.writer,ex.message)
        }
        return ModelAndView()
    }
}
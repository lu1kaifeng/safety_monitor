package top.lu1kaifeng.playground.rest

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver
import top.lu1kaifeng.playground.except.RestException
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
@Component
class RestExceptionResolver : AbstractHandlerExceptionResolver(){
    override fun doResolveException(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any?,
        ex: Exception
    ): ModelAndView {
        if(ex is RestException){
            response.contentType = "application/json"
            response.status = ex.status.value()
            ObjectMapper().writeValue(response.writer,ex)
        }else{
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            ex.printStackTrace(response.writer)
        }
        return ModelAndView()
    }
}
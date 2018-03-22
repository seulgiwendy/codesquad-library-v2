package com.codesquad.library.domain.exceptions.resolvers

import com.codesquad.library.domain.exceptions.security.BaseSecurityException
import com.codesquad.library.dtos.exceptions.ExceptionsDocument
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class BaseSecurityExceptionResolver: HandlerExceptionResolver {

    private val logger: Logger = LoggerFactory.getLogger(BaseSecurityExceptionResolver::class.java)

    override fun resolveException(req: HttpServletRequest?, res: HttpServletResponse?, obj: Any?, e: Exception?): ModelAndView? {
        if (e is BaseSecurityException) {
            var securityException: BaseSecurityException = e as BaseSecurityException
            logger.debug("Base Security Exception Caught!")
            TODO("write baseexception -> exceptiondocument logic first!")
            return null
        }
        return null
    }

    fun sendResponse(res: HttpServletResponse, doc: ExceptionsDocument) {
        res.status = doc.httpStatus.value()
        res.contentType = MediaType.APPLICATION_JSON_UTF8_VALUE
        res.writer.write(ObjectMapper().writeValueAsString(doc))
    }
}
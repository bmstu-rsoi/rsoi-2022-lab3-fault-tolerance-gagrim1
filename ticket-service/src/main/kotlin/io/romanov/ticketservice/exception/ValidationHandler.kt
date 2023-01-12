package io.romanov.ticketservice.exception

import feign.FeignException
import io.romanov.common.ErrorResponse
import io.romanov.common.exception.CommonExceptionHandler
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Import(CommonExceptionHandler::class)
class ValidationHandler {

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(FeignException.InternalServerError::class)
    fun handleRuntimeException(e: FeignException.InternalServerError) = ErrorResponse("Bonus Service unavailable") // sry for that

}

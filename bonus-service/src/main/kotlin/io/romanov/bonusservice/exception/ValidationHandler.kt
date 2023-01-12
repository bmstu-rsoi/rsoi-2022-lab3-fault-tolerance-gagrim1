package io.romanov.bonusservice.exception

import io.romanov.common.exception.CommonExceptionHandler
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Import(CommonExceptionHandler::class)
class ValidationHandler

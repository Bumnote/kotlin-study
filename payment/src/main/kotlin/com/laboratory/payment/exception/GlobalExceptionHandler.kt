package com.laboratory.payment.exception

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = KotlinLogging.logger { }

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(PaymentException::class)
    fun handlePaymentException(e: PaymentException): ErrorResponse {
        log.error(e) { "${e.errorCode} is occurred." }
        return ErrorResponse(e.errorCode)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ErrorResponse {
        log.error(e) { "Exception is occurred." }
        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}

class ErrorResponse(
    val errorCode: ErrorCode,
    val errorMessage: String = errorCode.errorMessage
)

/*
* Kotlin은 롬복이 없어 logging을 설정할 수 없다.
* 그래서 별도의 외부 라이브러리를 활용해야한다.
* */
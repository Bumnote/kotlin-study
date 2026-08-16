package com.laboratory.payment.controller

import com.laboratory.payment.service.PaymentService
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping("/pay")
    fun pay(
        @Valid @RequestBody
        payRequest: PayRequest
    ): PayResponse {
        return PayResponse("p1", 100, "txId", LocalDateTime.now())
    }
}

data class PayResponse(
    val payUserId: String,
    val amount: Long,
    val transactionId: String,
    val transactedAt: LocalDateTime
)

// 결제 요청: 외부 가맹점 -> 우리 결제 시스템으로 들어온다.
data class PayRequest(
    /* 이 곳은 생성자와 프로퍼티를 동시에 선언해주는 기능을 하지만,
    * 사실상 생성자 선언이기 때문에 @NotBlank를 필드 변수에 적용할 수 있도록 field: 키워드를 추가한다.
    * */
    @field:NotBlank
    val payUserId: String,
    @field:Min(100)
    val amount: Long,
    @field:NotBlank
    val merchantTransactionId: String,
    @field:NotBlank
    val orderTitle: String,
)
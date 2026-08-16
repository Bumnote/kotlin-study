package com.laboratory.payment.service

import com.laboratory.payment.OrderStatus
import com.laboratory.payment.TransactionStatus.RESERVE
import com.laboratory.payment.TransactionType.PAYMENT
import com.laboratory.payment.domain.Order
import com.laboratory.payment.domain.OrderTransaction
import com.laboratory.payment.domain.PaymentUser
import com.laboratory.payment.exception.ErrorCode
import com.laboratory.payment.exception.PaymentException
import com.laboratory.payment.repository.OrderRepository
import com.laboratory.payment.repository.OrderTransactionRepository
import com.laboratory.payment.repository.PaymentUserRepository
import com.laboratory.payment.util.generateOrderId
import com.laboratory.payment.util.generateTransactionId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/*
* 결제의 요청 저장, 성공, 실패 저장
* */
@Service
class PaymentStatusService(
    private val paymentUserRepository: PaymentUserRepository,
    private val orderRepository: OrderRepository,
    private val orderTransactionRepository: OrderTransactionRepository
) {

    @Transactional
    fun savePayRequest(
        payUserId: String,
        amount: Long,
        orderTitle: String,
        merchantTransactionId: String,
    ): Long {
        // order, orderTransaction 저장
        val paymentUser: PaymentUser = paymentUserRepository.findByPayUserId(
            payUserId
        ) ?: throw PaymentException(ErrorCode.INVALID_REQUEST, "사용자 없음 : $payUserId")

        val order = orderRepository.save(
            Order(
                orderId = generateOrderId(),
                paymentUser = paymentUser,
                orderStatus = OrderStatus.CREATED,
                orderTitle = orderTitle,
                orderAmount = amount
            )
        )

        orderTransactionRepository.save(
            OrderTransaction(
                transactionId = generateTransactionId(),
                order = order,
                transactionType = PAYMENT,
                transactionStatus = RESERVE,
                transactionAmount = amount,
                merchantTransactionId = merchantTransactionId,
                description = orderTitle
            )
        )

        return order.id ?: throw PaymentException(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}
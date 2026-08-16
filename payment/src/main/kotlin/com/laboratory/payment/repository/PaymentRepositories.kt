package com.laboratory.payment.repository

import com.laboratory.payment.domain.Order
import com.laboratory.payment.domain.OrderTransaction
import com.laboratory.payment.domain.PaymentUser
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentUserRepository : JpaRepository<PaymentUser, Long> {
    fun findByPayUserId(payUserId: String): PaymentUser?
}

interface OrderRepository : JpaRepository<Order, Long> {

}

interface OrderTransactionRepository : JpaRepository<OrderTransaction, Long> {

}
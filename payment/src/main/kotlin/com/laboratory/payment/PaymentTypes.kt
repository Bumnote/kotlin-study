package com.laboratory.payment

enum class OrderStatus {
    CREATED,
    FAILED,
    PAID,
    CANCELLED,
    PARTIAL_REFUNDED,
    REFUNDED
}

enum class TransactionType {
    PAYMENT, REFUND, CANCEL
}

enum class TransactionStatus {
    RESERVE, SUCCESS, FAILURE
}
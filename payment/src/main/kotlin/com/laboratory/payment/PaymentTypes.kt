package com.laboratory.payment

enum class OrderStatus {
    CREATED,
    FAILED,
    PAID,
    CANCELLED,
    PARTIAL_REFUNDED,
    REFUNDED
}
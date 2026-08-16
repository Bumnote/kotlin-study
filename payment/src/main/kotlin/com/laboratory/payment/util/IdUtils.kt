package com.laboratory.payment.util

import java.util.*

private const val ORDER_ID_PREFIX = "PO"
private const val TRANSACTION_ID_PREFIX = "PT"

fun generateOrderId() = ORDER_ID_PREFIX + generateUUID()
fun generateTransactionId() = TRANSACTION_ID_PREFIX + generateUUID()

// 최상위 함수가 private인 경우에는 현재 파일 내에서만 사용이 가능하다.
private fun generateUUID(): String = UUID.randomUUID().toString().replace("-", "")
package repeat_

import java.util.*

val binaryReps = TreeMap<Char, String>()

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "숫자"
    in 'a'..'z', in 'A'..'Z' -> "알파벳"
    else -> "숫자도 알파벳도 아님"
}

fun MapTest() {
    for (c in 'A'..'Z') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for ((key, value) in binaryReps) {
        println("문자: $key, ASCII 코드: $value")
    }

    println(isLetter('A'))
    println(isNotDigit('A'))
    println(recognize('A'))
}

/*
1. 'A'..'Z': c는 'A'문자에서 'Z'문자까지 반복한다.
2. (key, value) in binaryReps
    - binaryReps라는 map 구조체에 담긴 값을 for-each 스타일로 하나씩 이터레이션
    - map 구조체(key-value) 값을 좌측의 (key, value)로 구조분해(destructuring declaration)해서 바로 변수에 담는다.
3. in 키워드를 통해서 범위 검사를 진행할 수 있다.
    - a in s..t: 내부적으로 s <= a && a <= t 로 변환된다. (양쪽 포함)
* */
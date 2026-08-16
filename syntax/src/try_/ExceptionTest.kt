package try_

import java.io.IOException

fun getLength(str: String): Int =
    when {
        // Java와 거의 비슷하지만, new가 불필요하다.
        str.length >= 10 -> throw IllegalStateException("문자열 길이가 10보다 큽니다.")
        else -> str.length
    }

/*
* try-catch-finally 구문은 자바와 거의 동일하지만, 이 부분도 if, when과 마찬가지로 식(값으로 취급 가능한 문장)으로 취급한다.
* Java와의 차이점은 다음과 같다.
* Checked Exception 이라고 해도, 함수 시그니처에 throws IOException을 붙이지 않아도 된다.
* Kotlin은 컴파일 오류가 발생하지 않자미나, Java 코드의 경우는 예외 전파를 하지 않으면 컴파일 오류가 발생한다.
* */
fun parse(numberStr: String): Int = try {
    Integer.parseInt(numberStr)
} catch (e: Exception) {
    throw IOException("일부러 발생시키는 checked exception")
} finally {
    println("무조건 실행되는 코드 블록")
}
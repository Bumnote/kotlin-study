package when_

import when_.Color.*

// 간결한 enum class
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE
}

// 프로퍼티와 메소드를 갖는 enum class
//enum class Color(val r: Int, val g: Int, val b: Int) {
//    RED(255, 0, 0),
//    ORANGE(255, 166, 0),
//    YELLOW(255, 255, 0),
//    GREEN(0, 255, 0);
//
//    fun rgb() = (r * 256 + g) * 256 + b
//}

// 하나의 값에 1:1 조건
//fun getKoreanColor(color: Color): String =
//    when (color) {
//        RED -> "빨강"
//        ORANGE -> "오렌지"
//        YELLOW -> "노랑"
//        GREEN -> "녹색"
//    }

// 다중 조건에 N:1 조건
fun getKoreanColor(color: Color) =
    when (color) {
        RED, ORANGE -> "빨강 또는 오렌지"
        YELLOW -> "노랑"
        GREEN, BLUE -> "녹색 또는 파란색"
    }

fun mix(c1: Color, c2: Color) =
    when {
        c1 == RED && c2 == YELLOW -> "오렌지"
        c1 == YELLOW && c2 == BLUE -> "녹색"
        else -> throw RuntimeException()
    }

/*
1. enum의 모든 구성 요소를 나열하지 않거나, else가 없으면 컴파일 오류가 발생한다. -> 모든 조건을 명시해야한다.
-> else를 쓰지 않고, 모든 요소 나열을 하면 신규 요소가 생겼을 때, 해당 로직 추가가 쉽다.
-> java에서 if 조건식 또는 switch 문으로 처리 시, 신규 요소 추가가 되면 해당 조건을 모두 직접 찾아야만 했다. 이런 불편함을 해소 (컴파일 단계에서 오류 발생하기 때문)
2. is else if else if else 문장과 동일한 구조도 가능하다. -> when 뒤에 조건에 대한 () 생략
-> 조건식이 길지 않고, 유사도가 높은 경우 간혹 사용
* */


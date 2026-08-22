package lambda_

fun sum(x: Int, y: Int): Int = x + y
val sumLambda = { x: Int, y: Int -> x + y }

fun main() {
    // 일반 함수 호출
    println(sum(10, 15))
    // 람다 변수 호출
    println(sumLambda(10, 15))
    // 람다 수식 바로 실행
    println({ x: Int, y: Int -> x + y }(10, 15))
}

/**
 * 위의 함수를 람다식으로 변경하면
 * { x: Int, y: Int -> x + y }
 * 람다를 사용하는 방법
 * 1. 함수에 파라미터 람다식을 넘기기
 * 2. 람다식을 변수에 저장하고, 해당 식을 나중에 필요할 때, 실행시키기
 */
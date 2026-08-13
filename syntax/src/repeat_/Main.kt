package repeat_

fun main() {
    // 1 ~ 100까지 (100 포함)
    for (i in 1..100)
        println(evenOrOdd(i))

    // 1 ~ 100까지 (100 미포함)
    for (i in 1 until 100)
        println(evenOrOdd(i))

    // 100 ~ 1까지 (3 간격으로, 100, 97 ,,, 1)
    for (i in 100 downTo 1 step 3)
        println(evenOrOdd(i))

    // 1 ~ 100까지 (3 간격으로 1, 4, ,,, 100)
    for (i in 1..100 step 3)
        println(evenOrOdd(i))

    MapTest()
}

fun evenOrOdd(n: Int) = when {
    n % 2 == 0 -> "even"
    else -> "odd"
}

/*
1. 기본적으로 i in 1..100 은 양쪽 끝 부분을 포함, 마지막을 미포함 하려면 until 키워드 사용한다.
* */
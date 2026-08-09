fun main() {
    val value = max(5, 3)
    println("max value is = $value")

    // value 변수 : 변경 불가능 (immutable) -> Java의 final과 동일
    val question = "what's wrong?"
    val answer = 123

    val poet: String = "Let is be forgotten"
    val age: Int = 25

    // variable 변수 : 변경 가능 (mutable)
    var changeable = "old"
    println("before: $changeable")
    changeable = "new"
    println("after: $changeable")

    val name = "zero"
    println("Hello, $name!")
    println("Hello, ${if (age > 28) name else "one"}!")
}

fun max(a: Int, b: Int): Int = if (a > b) a else b
// 반환 타입 추론이 가능하기 때문에 아래와 같이 작성할 수도 있다.
// fun max(a: Int, b: Int) = if (a > b) a else b

/*
[ 정리 ]
1. 코틀린 언어에서는 세미콜론이 없어도 된다.
2. 함수를 클래스 안에 정의할 필요가 없다.
3. 함수의 반환형은 파라미터 목록 뒤에 온다. 변수의 타입도 함수의 파라미터처럼 변수명 뒤에 위치한다.
4. 코틀린의 타입 추론 (type inference) 기능 덕분에 반환 타입을 생략할 수 있다.
5. 변수도 함수의 반환타입처럼 타입 추론을 활용해 생략이 가능하다.
6. "$" 표시를 활용해 문자열 변수를 문자열 리터럴 안에 사용 가능하다.
7. ${} 형식을 사용하면 더 복잡한 수식도 가능하다.
*/
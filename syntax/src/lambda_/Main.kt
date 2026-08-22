package lambda_

data class Person(
    val name: String,
    val age: Int
)


val persons = listOf(
    Person("Captain", 44),
    Person("Cyclops", 35),
    Person("Deadpool", 31),
    Person("Iceman", 54)
)

fun main() {
    // 가장 나이가 많은 사람을 출력
    println(persons.maxByOrNull { it.age })
    // 변화 과정
    // 1. 가장 정성적인 람다 호출, 람다 수식(중괄호)를 함수 호출에 인자로 넣어줌
    println(persons.maxByOrNull { person: Person -> person.age })
    // 2. 가장 마지막 인자가 람다 식이면 함수 호출 바깥으로 뺄 수 있음
    println(persons.maxByOrNull() { person: Person -> person.age })
    // 3. 람다만 있는 경우, 빈괄호 삭제 가능
    println(persons.maxByOrNull { person: Person -> person.age })
    // 4. 컴파일러가 타입 추론
    println(persons.maxByOrNull { person -> person.age })
    // 5. 람다의 파라미터 이름을 기본 이름인 it으로 수정하면, 가장 간결한 람다식이 완성된다.
    println(persons.maxByOrNull { it.age })
}


/*
* 람다란 무엇인가?
* - 람다란 일종의 익명 함수이며, 로직이다. 함수에 로직을 넘기기 쉽게 하기 위해 활용한다.
*
* 코틀린의 람다식
* -> 매우 간결해졌다. 즉, 매우 높은 간결성과 한눈에 보이는 가독성이 장점이다.
* -> 함수 호출을 ()가 아닌 {}로 했다.
*
* 단일 파라미터만 사용하는 람다식에서 주로 최종 단계 수준으로 활용
* 다중 파라미터이거나 컴파일러 타입 추론이 어려운 경우이거나 깊이가 있는 수식인 경우에는
*   it이나 타입 추론을 사용하기 어려울 수 있음
* 상황에 따라 적절히 활용하는 것이 좋다.
*
* 이중 콜론(::)을 활용해서 특정 클래스의 프로퍼티나 메서드를 참조할 수 있다.
* 최상위 함수나 값의 경우 ::topLevelFunction 처럼 클래스명 지정 없이 바로 참조 가능하다.
* */
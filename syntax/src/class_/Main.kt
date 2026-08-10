package class_

fun main(args: Array<String>) {
    // Person 객체 생성, new 연산자를 사용하지 않아도 된다.
    val person = Person("abc", true)
    println(person.name)
    println(person.isMarried)

    println(createRandomRectangle().isSquare)
}

/*
1. 자바와 다르게 코틀린은 디렉토리 구조 != 패키지 경로
2. 파일 하나에 여러 클래스와 함수, 최상위 변수 모드 선언 가능하다.
-> 이 부분이 코틀린에서 매우 편리하고 자주 활용되는 부분!
-> 크기가 작은 클래스나 성격이 비슷한 클래스, enum 등을 모아놓으면 관리하기가 편하고, 한누에 보기 좋다.
* */
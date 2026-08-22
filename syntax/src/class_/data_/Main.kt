package class_.data_

data class User(val name: String, val age: Int)

fun main() {
    println(User("Zero", 24))
}


/*
* toString(): Object의 기본 toString() 대신, "User(name=John, age=42)"와 같은 형식으로
* 내부의 데이터를 알아보기 쉽게 표현해주는 메서드를 제공한다.
*
* equals(), hashCode(): 두 클래스를 기본적인 동일성 검증 대신 동등성 검증으로 확인할 수 있도록 해줌
* */
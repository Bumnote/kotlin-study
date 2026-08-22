package class_.object_

class Person(val name: String, val isAdult: Boolean)

object Family {
    val members = mutableListOf<Person>()
}

fun main() {
    Family.members.add(Person("snow", true))
}


/*
*
* 자바에서의 싱글톤과 같은 목적으로 클래스 선언과 객체 생성을 동시에 진행한다.
*   - 직접 생성할 필요가 없으며, 별도 인스턴스 생성이 불가능하다.
*   - 싱글톤 패턴과 같이 어플리케이션에 인스턴스가 단 1개만 필요한 경우에 활용하면 좋다.
*
* Comparator의 구현처럼 단 한번만 사용되는 경우에도 사용 가능하다.
* 자바에서의 Util Class처럼 내부에 static method만 존재하고 별도 인스턴스 생성을 안하는 경우에도 사용이 가능하다.
*   - 하지만 이런 경우에는 클래스 없이 파일에 바로 함수를 만들어서 사용하는(최상위 함수, top level function)이 더 낫다.
*
* 익명 클래스에도 object 키워드 사용이 가능하다. -> 람다 활용 가능
* */
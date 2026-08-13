package when_

sealed class Person(
    val name: String,
    val isMarried: Boolean
)

class Developer(
    name: String,
    isMarried: Boolean,
    val language: String
) : Person(
    name,
    isMarried
)

class Marketer(
    name: String,
    isMarried: Boolean,
    val division: Division
) : Person(
    name,
    isMarried
)

enum class Division {
    CONTENTS, DIGITAL, BRAND
}

fun printSpecialSKill(person: Person) =
    when (person) {
        // smart cast 덕분에 Developer로 추가 형변환이 필요 없이 language 프로퍼티 사용
        is Developer -> println(person.language)
        // smart cast 덕분에 Marketer로 추가 형변환이 필요 없이 division 프로퍼티 사용
        is Marketer -> println(person.division)
    }

fun getSpecialSkill(person: Person): String =
    if (person is Developer) {
        println(person.language)
        person.language
    } else if (person is Marketer) {
        println(person.division)
        person.division.name
    } else throw RuntimeException()

/*
1. 인터페이스의 구현체가 여러 개이거나, 상속받은 클래스가 여러 개인 경우 타입 검사가 필요하다.
- Java: 타입 검사 후, 명시적 형변환 (Developer) person과 같이 반드시 필요하다.
- Kotlin: 타입 검사할 때, 자동으로 형변환까지 진행 (smart cast)
2. 직접 형변환도 가능하다.
- val dev = person as Developer
3. 조건(if, when 등)의 실행 부분이 {} 블록인 경우, 마지막 값이 결과값이 된다. -> return 값으로 활용 가능
* */
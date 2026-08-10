package class_

/*
public class Person {
    private final Strint name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

위 java 코드와 동일하다.
* */

class Person(
    val name: String,
    val isMarried: Boolean
)

/*
1. 엄청 간결하다.
2. 생성자와 프로퍼티 정의가 한번에 진행된다.
3. 프로퍼티란?
- 클래스 안에 정의된 변수
4. 접근 제어자(public/private)이 없다. -> 기본 제어자가 public이라 생략이 가능하다.
5. 자바 클래시는 필드를 만든 후, getter/setter를 만들어서 프로퍼티를 만들지만,
코틀린 클래스는 반대로 프로퍼티를 만들어서 기본적인 접근자까지 만들어준다. -> record와 흡사
6. 즉, 코틀린은 프로퍼티를 통해 기본적인 getter/setter를 만들어주고, 수정이 필요한 경우에만
커스텀 getter/setter를 만들어서 사용하면 된다.
7. boolean형 변수에 대한 생성자가 다르다.
    - java -> getter(isMarried()), setter(setMarried())
    - kotlin -> getter/setter(isMarried)

* */
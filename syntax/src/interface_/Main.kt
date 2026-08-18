package interface_

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun focus()
    // fun showOff() = println("I'm focusable")
}

class Button : Clickable, Focusable {
    override fun click() {
        println("Button is clicked")
    }

    override fun focus() {
        println("Button is focused")
    }
}

open class RichButton : Clickable {
    // final method: 오버라이드 불가
    fun disable() {}

    // open method: 오버라이드 가능
    open fun animate() {}

    // override 메서드: 오버라이드 가능
    override fun click() {}
}

fun main() {
    Button().click()
}
/*
* DIP(의존성 역전)를 지키기 위해서 인터페이스를 활용한다.
* 자바의 implements와 extends는 ":" 문자로 대체된다.
* : 문자를 활용해서 상속과 구현을 나타내면서, 구분한다.
* 인터페이스의 메서드 구현은 "override" 변경자를 반드시 붙여야 한다.
* Clickable과 Focusable이 둘 다 showOff()라는 기본 구현 메서드가 있는 경우, 컴파일 오류가 발생한다.
* 이 때에는 반드시 구현을 변경해야 한다. 즉, 다중 인터페이스 상속은 가능하나, 같은 함수에 대해서는 반드시 구현을 변경해야한다.
*
* Java의 접근 제어자 public, private 처럼, Kotlin에는 open, final, abstract 변경자가 있고, 기본적으로는 final을 가진다.
* 무분별한 상속과 오버라이드는 취약한 기반 클래스(= fragile base class) 문제를 일으킬 수 있다.
* Java: 기본적으로 모든 클래스, 메서드는 상속할 수 있고, final class는 상속할 수 없다.
* Kotlin: 기본적으로 모든 클래스, 메서드는 final class(아무 표시가 없어도 final), open class 인 경우에만 상속 가능하다.
* */
package class_

import java.util.*

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

/*
isSquare는 함수로 정의할 수도 있으나, 이 값은 클래스의 프로퍼티(특성)을 나타내주는 값이므로
커스텀 getter를 통해 프로퍼티 값을 드러내는 것이 조금 더 자연스럽다.
* */
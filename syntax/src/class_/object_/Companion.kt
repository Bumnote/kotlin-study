package class_.object_


open class Parent {
    private val familyName: String

    constructor(familyName: String) {
        this.familyName = familyName
    }
}

class NewChild(
    private val subName: String,
    familyName: String,
    private val age: Int
) : Parent(familyName) {

    companion object {
        const val MAX_CHILD_COUNT = 4
        fun ofDefaultAge(
            subName: String, familyName: String
        ): NewChild = NewChild(subName, familyName, 0)

        fun ofDefaultName(
            age: Int
        ): NewChild = NewChild(
            "defaultName",
            "defaultFamilyName",
            10
        )
    }
}

/*
* companion Object -> 자바의 static Method를 대체하는 용도
* Java에서 static으로 상수 값을 저장하거나 factory 생성자를 만들던 방식을 동일하게 활용 가능하다.
* */
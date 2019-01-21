package com.cocoba.kotlinfunctionexample

/**
 * Created by Chandra on 21/01/19.
 * Need some help?
 * Contact me at y.pristyan.chandra@gmail.com
 */
class School {
    private var phone: String? = null
    private var name: String? = null
    private var student: Student? = null


    /** Run Function
     * `this` refer to Student, not School
     * The attribute call directly refers to Student
     *
     * @return Unit
     */
    private fun runFunction() = Student().run {
        /* refer to Student */
        name = "John Thor"
        phone = "088888888888"

        /* `this` refer to Student */
        this.name = "John Thor"
        this.phone = "088888888888"

        this@School.name = "Dumb Le Door"
        this@School.phone = "1200000090"
        this@School.student = this
    }


    /** Apply Function
     * `this` refer to Student, not School
     * The attribute call directly refers to Student
     *
     * @return Student
     */
    private fun applyFunction() = Student().apply {
        /* refer to Student */
        name = "Lee Junk Kok"
        phone = "008008008"

        /* `this` refer to Student */
        this.name = "Lee Junk Kok"
        this.phone = "008008008"

        this@School.name = "Dumb Le Door"
        this@School.phone = "1200000090"
    }


    /** Also Function
     * `this` refer to School
     * need `it` prefix to call Student attributes
     *
     * @return Student
     * */
    private fun alsoFunction() = Student().also {

        /* `this` refer to School */
        this.name = "Dumb Es"
        this.phone = "210001020"

        /* If you want to access Student attributes, you need to add `it` prefix */
        it.name = "Thug Gi Men"
        it.phone = "288288288"
    }


    /** Let Function
     * `this` refer to School
     * need `it` prefix to call Student attributes
     *
     * @return Unit
     * */
    private fun letFunction() = Student().let {
        /* `this` refer to School */
        this.name = "Harp Pest"
        this.phone = "210001020"

        /* If you want to access Student attributes, you need to add `it` prefix */
        it.name = "Joke Ow"
        it.phone = "288288288"
        student = it
    }



    /** CONCLUSION
     * RUN -> `this` refer to it self, no need prefix to call attributes, return Unit
     * APPLY -> `this` refer to it self, no need prefix to call attributes, return it self
     *
     * LET -> need `it` prefix to call attributes, return Unit
     * ALSO -> need `it` prefix to call attributes, return it self
     * */



    fun execute(): String {
        val sb = StringBuilder()
        runFunction()
        sb.append("RUN : \n")
        sb.append("School : $name | $phone\n")
        sb.append("Student : ${student?.name} | ${student?.phone}\n\n")

        student = applyFunction()
        sb.append("APPLY : \n")
        sb.append("School : $name | $phone\n")
        sb.append("Student : ${student?.name} | ${student?.phone}\n\n")

        letFunction()
        sb.append("LET : \n")
        sb.append("School : $name | $phone\n")
        sb.append("Student : ${student?.name} | ${student?.phone}\n\n")

        student = alsoFunction()
        sb.append("ALSO : \n")
        sb.append("School : $name | $phone\n")
        sb.append("Student : ${student?.name} | ${student?.phone}\n\n")

        return sb.toString()
    }

}

class Student {
    var name: String? = null
    var phone: String? = null
}
fun main() {
    //fun add(item: Int)
    //Accept a number and add it to the end of the list
    var acceptToEnd = mutableListOf<Int>()
    while (true) {
        println("Please give me a number....")
        var inputNumber = readln() // What if not a number?
        if (isNumber(inputNumber) == false) {
            println("That is not a number, please try again....")
            inputNumber = readln()
            acceptToEnd.add(inputNumber.toInt())
            println(acceptToEnd)
        } else {
            acceptToEnd.add(inputNumber.toInt())
            println(acceptToEnd)
            continue
        }
    }
}

fun isNumber(s: String): Boolean {
    return when (s.toIntOrNull()) {
        null -> false
        else -> true
    }
}
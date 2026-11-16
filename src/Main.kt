// Задание 1
fun main() {
    println("Введите число: ")
    val n = readln()
    val checkInput = n.toIntOrNull()

    if(checkInput == null) {
        println("Ошибка ввода: введено не целое положительное число.")
        return
    }
    // Способ 1
    val method_1 = n.toInt()
    val lastDigit = method_1%10
    var firstDigit = method_1
    while(firstDigit >= 10) {
        firstDigit/=10
    }
    val sum_1 = firstDigit + lastDigit

    println("Способ 1.\nСумма первой ($firstDigit) и последней ($lastDigit) цифр: $sum_1")

    // Способ 2
    val method_2 = n
    val firstSymbol = method_2.first().digitToInt()
    val lastSymbol = method_2.last().digitToInt()

    val sum_2 = firstSymbol + lastSymbol

    println("Способ 2.\nСумма первой ($firstSymbol) и последней ($lastSymbol) цифр: $sum_2")
}
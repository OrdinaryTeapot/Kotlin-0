import kotlin.math.sqrt

// Запуск функций
fun main(){
    while(true){
        println("Выберите номер задания (1-10), введите 0 для выхода:")
        val choice = readln()
        val checkInput = choice.toIntOrNull()
        if(checkInput == null) {
            println("Ошибка ввода: введено не целое положительное число.")
            break
        }
        val n = choice.toInt()
        when(n){
            1 -> task_1()
            2 -> task_2()
            3 -> task_3()
            4 -> task_4()
            0 -> break
        }
    }
}
// Задание 1
fun task_1() {
    println("===============Задание 1===============")
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

// Задание 2
fun task_2() {
    println("===============Задание 2===============")
    println("Введите любое число (введите 0 для завершения): ")
    val numbers = mutableListOf<Double>()

    while (true) {
        // Заменяем запятую на точку на случай, если пользователь введет "3,5" вместо "3.5"
        val input = readln().replace(',', '.')
        val number = input.toDoubleOrNull()

        if (number == null) {
            println("Ошибка ввода: введено не число.")
            continue
        }

        if (number == 0.0) {
            break
        }

        numbers.add(number)
    }

    if (numbers.isEmpty()) {
        println("Вы не ввели ни одного числа до нуля.")
    } else {
        println(
            "Количество введённых чисел: ${numbers.size}\n" +
                    "Сумма введённых чисел: ${numbers.sum()}\n" +
                    "Среднее арифметическое: ${numbers.average()}"
        )
    }
}

// Задание 3
fun task_3(){
    println("===============Задание 3===============")
    val a = (0..10).random()
    while(true) {
        println("Введите число: ")
        val b = readln().toIntOrNull()

        if (b == null || b !in 0..10) {
            println("Ошибка ввода: введено не целое положительное число.")
            continue
        }
        else if( b>a){
            println("Много")
            continue
        }
        else if(b<a){
            println("Мало")
            continue
        }
        else{
            println("Угадал")
            break
        }
    }
}

fun task_4(){
    println("===============Задание 4===============")
    println("Введите количество простых чисел (n >= 1): ")

    val n = readln().toIntOrNull()
    if (n == null || n < 1) {
        println("Ошибка: введите целое число больше или равное 1.")
        return
    }

    var count = 0
    var candidate = 2

    while (count < n) {
        if (isPrime(candidate)) {
            count++
            println("$count-е число: $candidate")
        }
        candidate++
    }
}

// Функция для проверки, является ли число простым
fun isPrime(number: Int): Boolean {
    if (number < 2) return false
    // Проверяем делители только до квадратного корня из числа
    val limit = sqrt(number.toDouble()).toInt()
    for (i in 2..limit) {
        if (number % i == 0) {
            return false // Нашелся делитель — число составное
        }
    }
    return true
}
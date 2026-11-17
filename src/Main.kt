import kotlin.math.sqrt

// Запуск функций
fun main() {
    while (true) {
        println("=======================================\n")
        println("Выберите номер задания (1-10), введите 0 для выхода:")
        val choice = readln()
        val checkInput = choice.toIntOrNull()
        if (checkInput == null) {
            println("Ошибка ввода: введено не целое положительное число.")
            break
        }
        val n = choice.toInt()
        when (n) {
            1 -> task_1()
            2 -> task_2()
            3 -> task_3()
            4 -> task_4()
            5 -> task_5()
            6 -> task_6()
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

    if (checkInput == null) {
        println("Ошибка ввода: введено не целое положительное число.")
        return
    }
    // Способ 1
    val method_1 = n.toInt()
    val lastDigit = method_1 % 10
    var firstDigit = method_1
    while (firstDigit >= 10) {
        firstDigit /= 10
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
fun task_3() {
    println("===============Задание 3===============")
    val a = (0..10).random()
    while (true) {
        println("Введите число: ")
        val b = readln().toIntOrNull()

        if (b == null || b !in 0..10) {
            println("Ошибка ввода: введено не целое положительное число.")
            continue
        } else if (b > a) {
            println("Много")
            continue
        } else if (b < a) {
            println("Мало")
            continue
        } else {
            println("Угадал")
            break
        }
    }
}

// Задание 4
fun task_4() {
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

// Задание 5
fun task_5() {
    println("===============Задание 5===============")
    val numbers = arrayOf(3, 5, 6, 1, 7, 10, 9, 4, 12, 18)
    println("Результат цикла for:")
    useForTask5(numbers)
    println("Результат цикла while:")
    useWhileTask5(numbers)
    println("Результат оператора forEach:")
    useForEachTask5(numbers)
}

// Функция цикла for
fun useForTask5(array: Array<Int>) {
    for (i in 1 until array.size - 1) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            println("${array[i]}")
        }
    }
    println()
}

// Функция цикла while
fun useWhileTask5(array: Array<Int>) {
    var i = 1
    while (i < array.size - 1) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            println("${array[i]}")
        }
        i++
    }
    println()
}

// Функция оператора forEach
fun useForEachTask5(array: Array<Int>) {
    array.forEachIndexed { index, element ->
        if (index > 0 && index < array.size - 1) {
            if (element > array[index - 1] && element > array[index + 1]) {
                println("${element}")
            }
        }
    }
    println()
}

// Задание 6
fun task_6() {
    println("===============Задание 6===============")
    val numbers = arrayOf(3, 5, 6, 1, 7, 10, 9, 4, 12, -18)
    println("\nРезультат цикла for:")
    useForTask6(numbers)
    println("\nРезультат цикла while:")
    useWhileTask6(numbers)
    println("\nРезультат оператора forEach:")
    useForEachTask6(numbers)
    println("\nРезультат функции reduce():")
    useReduceTask6(numbers)
    println("\nРезультат функций min(), max():")
    useMinMaxTask6(numbers)

}

// Функция цикла for
fun useForTask6(array: Array<Int>) {
    var product = 1
    var min = array[0]
    var max = array[0]

    for (element in array) {
        product *= element
        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
    }
    println("Произведение элементов: $product")
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")
}

// Функция цикла while
fun useWhileTask6(array: Array<Int>) {
    var product = 1
    var min = array[0]
    var max = array[0]

    var i = 0
    while (i < array.size) {
        val element = array[i]
        product *= element

        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
        i++
    }
    println("Произведение элементов: $product")
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")
}

// Функция оператора forEach
fun useForEachTask6(array: Array<Int>) {
    var product = 1
    var min = array[0]
    var max = array[0]

    array.forEach { element ->
        product *= element
        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
    }
    println("Произведение элементов: $product")
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")
}

// Функция reduce()
fun useReduceTask6(array: Array<Int>) {
    val product = array.reduce { acc, element -> acc * element }
    val min = array.reduce { acc, element -> if (element < acc) element else acc }
    val max = array.reduce { acc, element -> if (element > acc) element else acc }
    println("Произведение элементов: $product")
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")
}

// Функции min(), max()
fun useMinMaxTask6(array: Array<Int>) {
    val product = array.reduce { acc, element -> acc * element }
    val min = array.min()
    val max = array.max()
    println("Произведение элементов: $product")
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")
}
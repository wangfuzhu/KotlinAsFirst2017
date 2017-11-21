@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.

 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var qiclo: Int = n
    if (n < 0)
        qiclo = -n
    var number: Int = 0
    for (i in 1..9999) {
        number += 1
        qiclo /= 10
        if (qiclo < 1) {
            break
        }
    }
    return number

}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    if (n <= 2) {
        return 1
    } else {
        return fib(n - 2) + fib(n - 1)
    }

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var minm: Int = 1
    for (i in 2..m * n) {
        minm += 1
        if ((i % m == 0) && (i % n == 0)) break
        else continue
    }
    return minm
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var min: Int = 1
    for (i in 2..n) {
        min += 1
        if (n % i == 0) break
        else continue
    }
    return min
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var max: Int = n
    for (i in 1..n) {
        max -= 1
        if (n % max == 0) break
        else continue
    }
    return max
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var result: Int = 0
    for (i in 2..n) {
        if ((n % i == 0) && (m % i == 0)) result += 1
    }
    return (result == 0)
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    if ((m == 0) || (n == 0)) return true
    else {
        var result: Int = 0
        for (i in 1..Math.ceil(Math.sqrt(n.toDouble())).toInt()) {
            if ((i * i >= m) && (i * i <= n)) {
                result += 1
            }
        }
        return (result > 0)
    }
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var counter = 1
    var sin = x % (2 * Math.PI)
    val sinConst = sin
    var equation = sin
    while (Math.abs(equation) >= eps) {
        equation = -equation * sinConst / ((counter * 2 + 1) * (counter * 2)).toDouble() * sinConst
        counter += 1
        sin += equation
    }
    return sin
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var equation = 1.0
    var counter = 1
    var cos = 1.0
    while (Math.abs(equation) >= eps) {
        equation = -equation * (x % (2 * Math.PI)) / ((counter * 2 - 1) * (counter * 2)).toDouble() * (x % (2 * Math.PI))
        counter += 1
        cos += equation
    }
    return cos
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    if (n == 0) return 0
    else {
        var x: Int
        var y = 0
        var z: Int = n
        for (i in 1..200) {
            x = z % 10
            y = y * 10 + x
            z = z / 10
            if (z <= 0.01) break
            else continue
        }
        return y
    }
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    if (n == 0) return true
    else {
        return n == revert(n)
    }
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var x = n
    var y = 1
    var z = 0
    var w = 0
    while (x >= 10) {
        x /= 10; w += 1; y *= 10
    }
    x = w
    var k = y

    for (i in 1..w) {
        k = y
        for (j in 1..x) {
            k = y / 10
            z = n / k % 10

            if (z != (n / y % 10)) return true
        }
        y /= 10
        x -= 1
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var numbers = 1
    var str = ""
    var Nn = n
    while (Nn > 0) {
        val sqrnumb = numbers * numbers
        str = "$sqrnumb"
        numbers++
        Nn -= str.length
    }
    numbers = str.length - 1 + Nn
    return str[numbers].toString().toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var numbers = 1
    var str = ""
    var Nn = n
    var fibnumb: Int
    while (Nn > 0) {
        fibnumb = fib(numbers)
        str = "$fibnumb"
        numbers++
        Nn -= str.length
    }
    numbers = str.length - 1 + Nn
    return str[numbers].toString().toInt()
}



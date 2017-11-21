@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson3.task1.maxDivisor

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double =
        when {
            v.isEmpty() -> 0.0
            else -> Math.sqrt(v.map { it * it }.sum())
        }

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double =
        when {
            list.isEmpty() -> 0.0
            else-> list.sum() / list.size
        }

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> =
        when {
            list.isEmpty() -> list
            else->{
                val const=list.sum() / list.size
                for (i in 0 until list.size) {
                    list[i] -= const
                }
                list
            }
        }

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double =
        when {
            a.isEmpty()||b.isEmpty()-> 0.0
            else -> {
                var C = 0.0
                for (elCount in 0 until a.size)
                    C += a[elCount] * b[elCount]
                C
            }
        }

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double =
        when {
            p.isEmpty() -> 0.0
            else -> {
                var px = 0.0
                for (elcount in 0 until p.size)
                    px += p[elcount] * Math.pow(x, elcount.toDouble())
                px
            }
        }

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> =
    when {
        list.isEmpty()-> list
        (list.size==1)-> list
        else->{
            var answer1 = list[0]
            for (i in 1 until list.size){
                val answer2=list[i]
                list[i] += answer1
                answer1 += answer2
            }
            list
        }


    }


/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var copy = n
    var divosor = 2
    var list = mutableListOf<Int>()
    for (i in 1..n){
        if (copy > 1) {
            if (copy % divosor == 0) {
                copy /= divosor
                list.add(divosor)
            } else
                divosor += 1
        }
        else break
    }
    return list
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    if (n<base) return listOf(n)
    var copyn = n
    val answer = mutableListOf<Int>()
    val answer2 = mutableListOf<Int>()
    var elcount:Int
    while(copyn>0){
        answer.add(copyn%base)
        copyn/=base
    }
    for (i in 0..answer.size) {
        if (answer.size - 1 - i >= 0) {
            elcount = answer[answer.size - 1 - i]
            answer2.add(elcount)
        } else break
    }
    return answer2
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val list=convert(n,base)
    val abc="abcdefghijklmnopqrstuvwxyz"
    var answer =""
    for (i in 0 until list.size)
        if (list[i]> 9)
            answer += abc[list[i]-10]
    else answer += list[i]
    return answer
}


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var answer=0
    val list= mutableListOf<Int>()
    var number:Int
    for (i in 0..digits.size){
        if (digits.size - 1 - i >= 0){
            number =digits[digits.size- 1-i]
            list.add(number)
        }
        else break
    }
    var n=1
    for (i in 0 until digits.size){
        answer += list[i]*n
        n *= base
    }
    return answer
}
/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val list = mutableListOf<Int>()
    val number = "0123456789"
    val abc = "abcdefghijklmnopqrstuvwxyz"
    for(i in 0 until str.length )
        if (str[i] in number)
            list.add(number.indexOf(str[i],0))
        else list.add(abc.indexOf(str[i],0)+10)
    return decimal(list,base)
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var str = ""
    val abc = listOf<String>("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val number = listOf<Int>(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    var copy = n
    var i =0
    while (number[i]>n) i+=1
    while (copy > 0){
       while (copy >= number[i]){
           str += abc[i]
           copy -= number[i]
       }
        i+=1
    }
    return str
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var str = ""
    val number = listOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900)
    val numru = listOf<String>("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять" , "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"  , "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    var copy = n
    var copy1 = n
    if (n == 0) return "ноль"
    if (copy/1000>=1){
        copy%=1000
        copy1/=1000
        for(x in 36 downTo 0){
            if (copy >= number[x]) {
                str += numru[x]
                copy -= number[x]
            }
            else break
        }
        str = str +" тысячи"
        for (i in 36 downTo 1) {
            if (copy >= number[i]) {
                str += numru[i]
                copy -= number[i]
            }
            else break
        }
    }
    else {
        for (i in 36 downTo 1) {
            if (copy >= number[i]) {
                str += numru[i]
                copy -= number[i]
                }
            else break
        }
    }
    return str
}

@file:Suppress("UNUSED_PARAMETER")
package lesson5.task1

import java.math.RoundingMode

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        }
        else {
            println("Прошло секунд с начала суток: $seconds")
        }
    }
    else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    val data = str.split(" ")
    val day = data[0].toInt()
    val day1 = if (day in 0..9)"0$day" else "$day"
    var month =""
    var answer=""
    var long =0
    for (part in data)
        long +=1
    if (long!=3) return ""
    when(data[1]){
        "января" -> month += "01"
        "февраля" -> month += "02"
        "марта" -> month += "03"
        "апреля" -> month += "04"
        "мая" -> month += "05"
        "июня" -> month += "06"
        "июля" -> month += "07"
        "августа" -> month += "08"
        "сентября" -> month += "09"
        "октября" -> month += "10"
        "ноября" -> month += "11"
        "декабря" -> month += "12"
        else -> return ""
    }
    if (day>31) return ""
    else {
        answer += day1 + "." + month + "." + data[2]
        return answer
    }
}
/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    var answer = ""
    var long = 0
    var month = ""
    val data = digital.split(".")
    /**
     * if there have abc
     */
    val number="0123456789"
    var abc =0
    for (i in 1..digital.length){
        for (x in 1..number.length) {
            if (digital[i - 1] == number[x - 1]) abc += 1
        }
        if (abc==0) return ""
    }
    val day = data[0].toInt()
    val day1 = "$day"
    for (part in data)
        long +=1
    if (long!=3) return ""
    if (data[0].toInt() > 31) return ""
    when(data[1]){
        "01" -> month += "января"
        "02" -> month += "февраля"
        "03" -> month += "марта"
        "04" -> month += "апреля"
        "05" -> month += "мая"
        "06" -> month += "июня"
        "07" -> month += "июля"
        "08" -> month += "августа"
        "09" -> month += "сентября"
        "10" -> month += "октября"
        "11" -> month += "ноября"
        "12" -> month += "декабря"
        else -> return ""
    }
    answer += day1 + " "+month + " " + data[2]
    return answer
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String {
    val Ture = "0123456789+()- "
    var abc = 0
    if((phone.length==0)||((phone.length==1)&&(phone[0]==Ture[14]))) return ""
    for(i in 1..phone.length){
        for (x in 1..Ture.length) {
            if (phone[i - 1] == Ture[x - 1]) abc += 1
        }
        if (abc!=1) return ""
        abc =0
    }
    val parts = phone.split(" ")
    var answer = ""
        for (part in parts) {
            for(n in 0..part.length-1){
                for (x in 0..10) {
                    if (part[n] == Ture[x])
                        answer += part[n]
                }
                if (answer=="") return ""
        }
    }
    return answer
}
/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    if (jumps.isEmpty()) return -1
    val number = "1234567890"
    var element = ""
    var numresult = -1
    for (el in jumps) {
        if (el in number) element += el
        else if (el == ' ' || el == '-' || el == '%') {
            if (element.isNotEmpty() && element.toInt() > numresult) numresult = element.toInt()
            element = ""
        } else return -1
    }
    if (element.isNotEmpty() && element.toInt() > numresult) {
        numresult = element.toInt()
    }
    return numresult
}

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int {
    val parts = jumps.split(" ")
    var max = -1
    for (part in 1 until parts.size step 2) {
        for (i in parts[part]) {
            if ((i == '+') && (max < parts[part - 1].toInt())) max = parts[part - 1].toInt()
        }
    }
    return max
}
/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    if (expression.length == 0) throw IllegalArgumentException()
    val parts = expression.split(" ")
    var result = parts[0].toInt()
    for (i in 2..parts.size step 2){
        when {
            parts[i-1] == "+" -> result += parts[i].toInt()
            parts[i-1] == "-" -> result -= parts[i].toInt()
        }
    }
    return result
}


/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val parts = str.toUpperCase().split(" ")
    var number = 0
    var answer = -1
    for (part in parts){
        number +=1
    }
    if (number == 1) return -1
    for (i in 0..number - 2){
        if (parts[i] == parts[i+1]){
            answer += 1
            break
        }
        else{
            answer += parts[i].length + 1
            continue
        }
    }
    return answer
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String {
    if (description.isEmpty()) return ""
    var max = 0.0
    var name = ""
    var parts = description.split("; ")
    for (i in parts){
        val parts2 = i.split(" ")
        for (x in 1 until parts2.size step 2){
            if (parts2[x].toDouble()>max) {
                max = parts2[x].toDouble()
                name = parts2[x - 1]
            }
        }
    }
    return name
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
    fun fromRoman(roman: String): Int {
    var answer = 0
    val Romeabc = "IVXLCDM"
    var abc =0
    for (i in 1..roman.length){
        for (x in 1..Romeabc.length) {
            if (roman[i - 1] == roman[x - 1]) abc += 1
        }
        if (abc==0) return -1
    }
    for (i in 0 until roman.length){
        when (roman[i]){
            Romeabc[6] -> answer += 1000
            Romeabc[5] -> answer += 500
            Romeabc[4] -> answer += 100
            Romeabc[3] -> answer += 50
            Romeabc[2] -> answer += 10
            Romeabc[1] -> answer += 5
            Romeabc[0] -> answer += 1
        }
    }
    return answer
}

    /**
     * Очень сложная
     *
     * Имеется специальное устройство, представляющее собой
     * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
     * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
     * Каждая команда кодируется одним специальным символом:
     *	> - сдвиг датчика вправо на 1 ячейку;
     *  < - сдвиг датчика влево на 1 ячейку;
     *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
     *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
     *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
     *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
     *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
     *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
     *      (комбинация [] имитирует цикл)
     *  пробел - пустая команда
     *
     * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
     *
     * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
     * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
     * значении под датчиком равном 0) и пробелы.
     *
     * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
     * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
     *
     * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
     * То же исключение формируется, если у символов [ ] не оказывается пары.
     * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
     * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
     * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
     * IllegalArgumentException.
     * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
     *
     */
    fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()
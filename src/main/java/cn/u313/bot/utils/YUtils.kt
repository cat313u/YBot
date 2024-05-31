package cn.u313.bot.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class YUtils {
}
fun getCurrentDateAsInteger(): Int {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    return currentDate.format(formatter).toInt()
}
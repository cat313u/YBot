package cn.u313.bot.utils

import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class YUtils {
}

/**
 * 获取yyyyMMdd 格式时间并转为Int
 */
fun getCurrentDate(exec:(String,String)->Unit={_,_->}): String {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val dateStr = currentDate.format(formatter)
    exec(currentDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli().toString(),dateStr)
    return dateStr
}
fun getCurrentDateAsInteger(): Int {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    return currentDate.format(formatter).toInt()
}
fun extractQQ(input: String): Long {
    return getAtQQ(input)?.toLong()?:extractQQ1(input)
}
fun extractQQ1(input:String): Long {
    val regex = "【(.*?)】".toRegex()
    val match = regex.find(input)
    return match?.groupValues?.getOrNull(1)?.toLong() ?: 123456L
}
fun getAtQQ(input:String): String? {
    val regex = "\\[CQ:at,qq=(\\d+)]".toRegex()
    val match = regex.find(input)
    return match?.groupValues?.getOrNull(1)
}
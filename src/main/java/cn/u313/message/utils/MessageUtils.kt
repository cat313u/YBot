package cn.u313.message.utils

import cn.u313.message.bean.GroupMessage
import cn.u313.message.bean.PrivateMessage
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.StringJoiner

/**
 * 消息发送
 */
class MessageUtils {
    var executor: ThreadPoolTaskExecutor = ThreadPoolTaskExecutor().apply {
        corePoolSize = 3
        maxPoolSize = 10
        queueCapacity = 100
        setThreadNamePrefix("MyThread-")
        initialize()
    }
}
val messageEvent = MessageUtils()
fun MessageUtils.sendMsg(groupMessage: GroupMessage, msg:Any?){
    executor.execute {
        OkHttpUtils.postData("http://localhost:3000/send_group_msg","""
            {"group_id":${groupMessage.groupId},"auto_escape":false,"message":"$msg"}
        """.trimIndent())
    }
}
fun MessageUtils.sendMsg(privateMessage: PrivateMessage, msg:Any?){
    if (msg == null) return
    executor.execute {
        OkHttpUtils.postData("http://localhost:3000/send_private_msg","""
            {"user_id":${privateMessage.userId},"auto_escape":false,"message":"$msg"}
        """.trimIndent())
    }
}
private fun message(msg:Any):String{
    var split = msg.toString().split("\n")
    if (split.size == 1) return messageAppend(split)
    split = msg.toString().split("\t\n")
    return messageAppend(split)
}

private fun messageAppend(msgs: List<String>): String {
    val stringJoiner = StringJoiner(",", "", "")
    msgs.forEach {
        stringJoiner.add("{\"type\":\"text\",\"data\":{\"text\":\"$it\"}")
    }
    return stringJoiner.toString()
}
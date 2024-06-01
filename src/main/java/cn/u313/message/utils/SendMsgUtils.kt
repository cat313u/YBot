package cn.u313.message.utils

import cn.u313.message.bean.GroupMessage
import cn.u313.message.bean.PrivateMessage


class SendMsgUtils {
}
fun String.send(groupMessage: GroupMessage) =  messageEvent.sendMsg(groupMessage,this)
fun String.send(privateMessage: PrivateMessage) =  messageEvent.sendMsg(privateMessage,this)
package cn.u313.bot.listener

import cn.u313.bot.service.SignInService
import cn.u313.message.annotation.BotListener
import cn.u313.message.annotation.Filter
import cn.u313.message.annotation.OnGroup
import cn.u313.message.annotation.OnPrivate
import cn.u313.message.bean.GroupMessage
import cn.u313.message.bean.PrivateMessage
import cn.u313.message.utils.messageEvent
import cn.u313.message.utils.sendMsg
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

@BotListener
class TestListener {
    @Autowired
    var signInService:SignInService? =null
    @Filter(".*签到.*")
    @OnPrivate
    fun privateTest1(privateMessage: PrivateMessage){
        messageEvent.sendMsg(privateMessage,signInService?.sign(privateMessage.userId))
    }
    @Filter(".*查询.*")
    @OnPrivate
    fun from(privateMessage: PrivateMessage){
        messageEvent.sendMsg(privateMessage,signInService?.from(privateMessage.userId))
    }
    @Filter(".*查询.*")
    @OnGroup
    fun from(groupMessage: GroupMessage){
        messageEvent.sendMsg(groupMessage,signInService?.from(groupMessage.userId))
    }
    @OnGroup
    @Filter(".*签到.*")
    fun groupTest(groupMessage: GroupMessage){
        messageEvent.sendMsg(groupMessage,signInService?.sign(groupMessage.userId))
    }
    @OnGroup
    @Filter("复读机.*")
    fun hi(groupMessage: GroupMessage){
        messageEvent.sendMsg(groupMessage,groupMessage.msg.replace("复读机",""))
    }
}
package cn.u313.bot.listener

import cn.u313.bot.service.RobberyService
import cn.u313.bot.utils.extractQQ
import cn.u313.message.annotation.BotListener
import cn.u313.message.annotation.Filter
import cn.u313.message.annotation.OnGroup
import cn.u313.message.annotation.OnPrivate
import cn.u313.message.bean.GroupMessage
import cn.u313.message.bean.PrivateMessage
import cn.u313.message.utils.send
import org.springframework.beans.factory.annotation.Autowired

/**
 * 抢劫
 */
@BotListener
class RobberyListener {
    @Autowired
    var robberyService: RobberyService? = null

    @OnPrivate
    @Filter(".*打劫.*")
    fun rbo(privateMessage: PrivateMessage) {
        robberyService?.apply {
            robbery(privateMessage.userId, 123456).send(privateMessage)
        }
    }

    @OnGroup
    @Filter(".*打劫.*")
    fun rbo(groupMessage: GroupMessage) {
        robberyService?.apply {
            robbery(groupMessage.userId, extractQQ(groupMessage.msg)).send(groupMessage)
        }
    }
}
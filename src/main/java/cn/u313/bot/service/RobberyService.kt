package cn.u313.bot.service

import cn.u313.bot.config.Operation
import cn.u313.bot.entry.RecordEntity
import cn.u313.bot.entry.UserDataEntity
import cn.u313.bot.service.BaseService
import cn.u313.bot.utils.getCurrentDate
import cn.u313.message.annotation.BotListener
import org.springframework.stereotype.Service

/**
 * 抢劫
 */
@Service
class RobberyService : BaseService() {
    private val toUserCount = 1 // 单次
    private val max = 5 // 单次
    fun robbery(from: Long, to: Long): String {
        return isValid(from, to) { isValid, msg ->
            if (isValid.not()) {
                return@isValid msg
            } else {
                val fromUser = getUser(from) // 打劫
                val toUser = getUser(to) // 被打劫

                if (isSuccess()) {
                    val optionCoin = optionCoin(fromUser, toUser)
                    return@isValid """
                抢劫成功！
                获得 $optionCoin 悦币！
            """.trimIndent()
                }
                return@isValid """
            抢劫失败！
            再去练练再来试试吧！
        """.trimIndent()
            }
        }

    }

    private fun optionCoin(fromUser: UserDataEntity?, toUser: UserDataEntity?): Int {
        val coi = getCoin()
        fromUser!!.apply {
            coin = coin?.plus(coi)
            userDataEntityRepository!!.save(this)
        }
        toUser!!.apply {
            coin = coin?.minus(coi)
            userDataEntityRepository!!.save(this)
        }
        val recordEntity = RecordEntity()
        recordEntity.coin = coi.toString()
        recordEntity.userId = fromUser.uid
        recordEntity.toUserId = toUser.uid
        recordEntity.rType = Operation.ROBBERY.name
        getCurrentDate { currentTimeMillis, dateStr ->
            recordEntity.dateLong = currentTimeMillis
            recordEntity.createDate = dateStr
        }
        recordEntityRepository!!.save(recordEntity)
        return coi
    }

    fun getCoin(): Int {
        return (Math.random() * 5 + 1).toInt()
    }

    private fun isValid(from: Long, to: Long, exec: (Boolean, String) -> String): String {
        if (from == to) return exec(false, "自己不能打劫自己哦！")
        val countSum =
            recordEntityRepository!!.countByUserIdAndRTypeAndCreateDate(from, Operation.ROBBERY.name)
        if (max <= countSum) return exec(false, "今天已经到抢劫次数上限啦\n明天再来了哦")
        val count =
            recordEntityRepository!!.robberyCont(from, Operation.ROBBERY.name, to)
        if (count < toUserCount)
            return exec(true, "")
        return exec(false, "今天已经抢劫过他啦！\n换个人试试吧")
    }

    private fun isSuccess(): Boolean {
        return Math.random() * 100 > 10
    }
}
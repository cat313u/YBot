package cn.u313.bot.service

import cn.u313.bot.entry.UserDataEntity
import cn.u313.bot.repository.UserDataEntityRepository
import cn.u313.bot.utils.getCurrentDateAsInteger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignInService {
    @Autowired
    var userDataEntityRepository:UserDataEntityRepository? = null
    private fun resiger(uid: Long): UserDataEntity? {
        val apply = UserDataEntity().apply {
            this.uid = uid
        }
        return userDataEntityRepository?.save(apply)
    }
    private fun saveUser(user:UserDataEntity?){
        if (user == null) return
        userDataEntityRepository?.save(user)
    }
    fun from(uid: Long): String {
        var user = getUser(uid)
        if (user == null) return "未查询到您的用户信息\n请签到后再查询谢谢"
        return """
            您当前的悦币数量:${user.coin}
            其他功能暂未完善哦
        """.trimIndent()
    }
    fun sign(uid: Long): String {
        val user = getUser(uid)
        user!!
        if (user.signDate < getCurrentDateAsInteger()){
            user.coin = user.coin?.plus(20)?:20
            user.signDate = getCurrentDateAsInteger()
        }else{
            return "签到失败！\n 你今天已经签到过了哦"
        }
        saveUser(user)
        return "签到成功！\n获得 20 悦币"
    }
    fun getUser(uid: Long): UserDataEntity? {
        val findByUid = userDataEntityRepository?.findByUid(uid) ?: return resiger(uid)
        return findByUid
    }
}
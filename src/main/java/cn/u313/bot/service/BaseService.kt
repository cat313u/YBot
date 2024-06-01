package cn.u313.bot.service

import cn.u313.bot.entry.UserDataEntity
import cn.u313.bot.repository.RecordEntityRepository
import cn.u313.bot.repository.UserDataEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class BaseService {
    @Autowired
    var userDataEntityRepository: UserDataEntityRepository? = null
    @Autowired
    var recordEntityRepository: RecordEntityRepository? = null

    /**
     * 注册用户
     */
    private fun register(uid: Long): UserDataEntity? {
        val apply = UserDataEntity().apply {
            this.uid = uid
        }
        return userDataEntityRepository?.save(apply)
    }

    /**
     * 保存
     */
    fun saveUser(user: UserDataEntity?){
        if (user == null) return
        userDataEntityRepository?.save(user)
    }

    /**
     * 获取用户
     */
    fun getUser(uid: Long): UserDataEntity? {
        val findByUid = userDataEntityRepository?.findByUid(uid) ?: return register(uid)
        return findByUid
    }
}
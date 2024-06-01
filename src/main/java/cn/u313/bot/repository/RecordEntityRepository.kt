package cn.u313.bot.repository;

import cn.u313.bot.entry.RecordEntity
import cn.u313.bot.utils.getCurrentDate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RecordEntityRepository : JpaRepository<RecordEntity, Long> {
    fun findByUserIdAndRType(userId: Long, rType: String):RecordEntity?
    fun findByUserIdAndRTypeAndToUserId(userId: Long, rType: String, toUserId: Long):RecordEntity?
    fun countByUserIdAndRTypeAndToUserId(userId: Long, rType: String, toUserId: Long):Int
    @Query(nativeQuery = true, value = "select count(re1_0.id) from record_entity re1_0 where re1_0.user_id=:userId and re1_0.r_type=:rType and re1_0.to_user_id=:toUserId and re1_0.create_date = :dateStr ")
    fun robberyCont(userId: Long, rType: String, toUserId: Long,dateStr:String = getCurrentDate()):Int
    fun countByUserIdAndRTypeAndCreateDate(userId: Long, rType: String, createDate: String = getCurrentDate()):Int
}
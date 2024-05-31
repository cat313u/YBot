package cn.u313.bot.repository;

import cn.u313.bot.entry.UserDataEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository
@Repository
interface UserDataEntityRepository : JpaRepository<UserDataEntity, Long>, JpaSpecificationExecutor<UserDataEntity> {
    fun findByUid(uid:Long):UserDataEntity?
}
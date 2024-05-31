package cn.u313.bot.repository;

import cn.u313.bot.entry.RecordEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RecordEntityRepository : JpaRepository<RecordEntity, Long> {

}
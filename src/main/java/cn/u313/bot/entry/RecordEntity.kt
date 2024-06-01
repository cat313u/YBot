package cn.u313.bot.entry

import jakarta.persistence.*

@Entity
@Table(name = "record_entity")
open class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
    open var createDate: String? = null // 格式化的时间
    open var dateLong: String? = null // 时间戳
    open var rType: String? = null // 操作记录
    open var coin: String? = null // 变动的金币数量
    open var userId: Long? = null // 用户ID
    open var toUserId: Long? = null // 被动的用户ID
    open var groupId: Long? = null // 群ID
}
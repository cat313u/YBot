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
    open var rType: String? = null
    open var coin: String? = null
}
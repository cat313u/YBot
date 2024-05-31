package cn.u313.bot.entry

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "user_data_entity")
open class UserDataEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
    open var coin: Int? = 0
    open var uid: Long? = null
    open var signDate: Int = 0

}
package cn.u313.message.bean

data class AT(val userId:Long) {
    override fun toString(): String {
        return "[CQ:at,qq=$userId]"
    }
}
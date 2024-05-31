package cn.u313.message.bean;

import lombok.Data;

/**
 * @ProjectName: botv2
 * @Package: cn.u313.message.bean
 * @ClassName: GroupMessage
 * @Author: 柳苏言
 * @Description:
 * @Date: 2024/5/25 21:49
 * @Version: 1.0
 */

public class PrivateMessage extends BaseMsg{
    private String groupId;
    private String card;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}

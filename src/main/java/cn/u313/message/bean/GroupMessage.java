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
@Data
public class GroupMessage extends BaseMsg{
    private Long groupId;
    private String card;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}

package cn.u313.message.bean;

import lombok.Data;

/**
 * @ProjectName: botv2
 * @Package: cn.u313.message.bean
 * @ClassName: BaseMsg
 * @Author: 柳苏言
 * @Description:
 * @Date: 2024/5/25 21:52
 * @Version: 1.0
 */
public class BaseMsg {
    private Long messageId;
    private Long selfId;
    private String time;
    private Long userId;
    private String postType;
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getSelfId() {
        return selfId;
    }

    public void setSelfId(Long selfId) {
        this.selfId = selfId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }
}

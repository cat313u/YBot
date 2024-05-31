package cn.u313.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: botv2
 * @Package: cn.u313.bot.model
 * @ClassName: NTMessage
 * @Author: 柳苏言
 * @Description: NT 消息,原始消息
 * @Date: 2024/5/25 20:43
 * @Version: 1.0
 */
public class NTMessage {

    @JsonProperty("self_id")
    private Long selfId;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("message_id")
    private Long messageId;
    @JsonProperty("real_id")
    private Long realId;
    @JsonProperty("message_seq")
    private Long messageSeq;
    @JsonProperty("message_type")
    private String messageType;
    @JsonProperty("sender")
    private SenderDTO sender;
    @JsonProperty("raw_message")
    private String rawMessage;
    @JsonProperty("font")
    private Long font;
    @JsonProperty("sub_type")
    private String subType;
    @JsonProperty("message")
    private String message;
    @JsonProperty("message_format")
    private String messageFormat;
    @JsonProperty("post_type")
    private String postType;
    @JsonProperty("group_id")
    private Long groupId;

    public Long getSelfId() {
        return selfId;
    }

    public void setSelfId(Long selfId) {
        this.selfId = selfId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getRealId() {
        return realId;
    }

    public void setRealId(Long realId) {
        this.realId = realId;
    }

    public Long getMessageSeq() {
        return messageSeq;
    }

    public void setMessageSeq(Long messageSeq) {
        this.messageSeq = messageSeq;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public SenderDTO getSender() {
        return sender;
    }

    public void setSender(SenderDTO sender) {
        this.sender = sender;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public Long getFont() {
        return font;
    }

    public void setFont(Long font) {
        this.font = font;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageFormat() {
        return messageFormat;
    }

    public void setMessageFormat(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public static class SenderDTO {
        @JsonProperty("user_id")
        private Long userId;
        @JsonProperty("nickname")
        private String nickname;
        @JsonProperty("card")
        private String card;
        @JsonProperty("role")
        private String role;

        @Override
        public String toString() {
            return "SenderDTO{" +
                    "userId=" + userId +
                    ", nickname='" + nickname + '\'' +
                    ", card='" + card + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

    }

    @Override
    public String toString() {
        return "NTMessage{" +
                "selfId=" + selfId +
                ", userId=" + userId +
                ", time=" + time +
                ", messageId=" + messageId +
                ", realId=" + realId +
                ", messageSeq=" + messageSeq +
                ", messageType='" + messageType + '\'' +
                ", sender=" + sender +
                ", rawMessage='" + rawMessage + '\'' +
                ", font=" + font +
                ", subType='" + subType + '\'' +
                ", message='" + message + '\'' +
                ", messageFormat='" + messageFormat + '\'' +
                ", postType='" + postType + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}

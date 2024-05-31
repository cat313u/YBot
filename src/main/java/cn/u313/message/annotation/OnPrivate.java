package cn.u313.message.annotation;

import java.lang.annotation.*;

/**
 * @ProjectName: botv2
 * @Package: cn.u313.message.annotation
 * @ClassName: OnPrivate
 * @Author: 柳苏言
 * @Description: 私聊消息
 * @Date: 2024/5/25 20:57
 * @Version: 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OnPrivate {
}

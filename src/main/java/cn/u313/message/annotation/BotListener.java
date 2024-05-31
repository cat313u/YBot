package cn.u313.message.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @ProjectName: botv2
 * @Package: cn.u313.message.annotation
 * @ClassName: OnPrivate
 * @Author: 柳苏言
 * @Description: Bot 注解，告诉解析器这是Bot监听类
 * @Date: 2024/5/25 20:57
 * @Version: 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface BotListener {
}

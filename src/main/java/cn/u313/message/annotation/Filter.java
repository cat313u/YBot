package cn.u313.message.annotation;

import java.lang.annotation.*;
import java.util.regex.Pattern;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Filter {
    String value() default "";// 正则
}
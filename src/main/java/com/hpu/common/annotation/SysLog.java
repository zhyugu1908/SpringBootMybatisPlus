package com.hpu.common.annotation;

import java.lang.annotation.*;

/**
 * Created by zhangyuguang on 2018/10/1.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";

}

package com.lesson13.demo13.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Title : AspLog </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-02-26
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspLog {

    String value() default "";

}

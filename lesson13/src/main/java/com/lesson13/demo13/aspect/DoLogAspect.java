package com.lesson13.demo13.aspect;

import com.lesson13.demo13.entity.DoLog;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * <p>Title : DoLogAspect </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-02-26
 */
@Aspect
@Component
public class DoLogAspect {



    @Pointcut("@annotation( com.lesson13.demo13.aspect.AspLog )")
    public void ddlog() {
    }

    @AfterReturning("ddlog()")
    public void save(JoinPoint joinPoint) {
        DoLog doLog = new DoLog();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // 切点方法
        Method method = signature.getMethod();

        // 自定义注解的获取
        AspLog aspLog = method.getAnnotation(AspLog.class);
        String value;
        if (aspLog != null) {
            value = aspLog.value();
            doLog.setAspVal(value);
        }
        // 当前注解的class
        String doClassName = joinPoint.getTarget().getClass().getName();
        // 请求参数
        Object[] args = joinPoint.getArgs();
        // 请求函数名
        String methodName = method.getName();

        doLog.setDoClass(doClassName);
        doLog.setMethodName(methodName);
        doLog.setParams(args);


        System.out.println();

    }


}

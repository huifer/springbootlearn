package com.lesson.demo08.controller;

import javax.servlet.http.HttpServletRequest;

import com.lesson.demo08.exception.MineException;
import com.lesson.demo08.pojo.ErrorMassage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/***
 * 全局异常控制
 */
@ControllerAdvice
public class GlobalExceptionController {
    /**
     * 在@ControllerAdvice类中，根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理
     */
    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 捕获自定义异常，返回json信息
     */
    @ExceptionHandler(value = MineException.class)
    @ResponseBody
    public ErrorMassage<Object> ErrorHandler(HttpServletRequest req, MineException e) throws Exception {
        ErrorMassage<Object> error = new ErrorMassage<>();
        error.setCode(404);
        error.setMessage("Not Found Exception ！！！");
        error.setUrl(req.getRequestURL().toString());
        error.setData(e);
        return error;
    }

    /**
     * @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView ErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        ErrorMassage<Exception> error = new ErrorMassage<Exception>();
        error.setCode(400);
        error.setMessage("系统异常");
        error.setUrl(req.getRequestURI());
        error.setData(e);
        mav.addObject(error);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}


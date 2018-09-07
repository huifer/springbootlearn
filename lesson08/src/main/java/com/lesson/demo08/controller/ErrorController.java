package com.lesson.demo08.controller;

import com.lesson.demo08.exception.MineException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ErrorController {

    private final static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping("/")
    public String hello(ModelMap map) {
        logger.info("request -> hello ...");
        map.addAttribute("index", "spring 全局异常抓取...");
        return "index";
    }

    @RequestMapping("/anyone")
    public String anyone(ModelMap map) throws Exception {
        logger.info("request -> index ...");
        throw new Exception();
    }

    @RequestMapping("/mine")
    public String mine(ModelMap map) {
        logger.info("request -> mine ...");
        Throwable throwable = new Throwable();
        throw new MineException("我们访问到了 mine ...", throwable);
    }


    @ResponseBody
    @RequestMapping("/sum")
    public String sum(ModelMap map) throws ArithmeticException {
        // 手动直接报错接受异常值
        int i = 1 / 0;
        return "" + i;
    }
}

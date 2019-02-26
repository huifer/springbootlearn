package com.lesson13.demo13.controller;

import com.lesson13.demo13.aspect.AspLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title : Controller </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-02-26
 */
@RestController
public class Controller {


    @GetMapping("/test/{id}")
    @ResponseBody
    @AspLog(value = "这是一个测试")
    public Object test(@PathVariable("id") String id) {
        return "asdkalsjdklajsdkl";
    }

}

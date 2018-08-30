package com.lesson.demo02.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Api("JsonRest相关api")
public class JsonRestDemoController {

    @Autowired
    @Qualifier("currentUser")
    private User user;

    @Bean
    public User currentUser() {
        User user = new User();
        user.setName("JSON");
        user.setAge(20);
        return user;
    }

    @ApiOperation(value = "获取单个用户信息", notes = "获取用户信息")
    @GetMapping(path = "/json/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User user() {
        user.add(linkTo(methodOn(JsonRestDemoController.class).setUserName(user.getName())).withSelfRel());
        user.add(linkTo(methodOn(JsonRestDemoController.class).setUserAge(user.getAge())).withSelfRel());
        return user;
    }

    //setName
    @GetMapping(path = "/json/user/set/name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "String", required = false, value = "修改名称") // 注明 ： name 的值需要和函数参数名称一样 不然会多出一条无关参数记录
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 400, message = "参数问题")
    })
    public User setUserName(@RequestParam String name) {
        user.setName(name);
        return user;

    }

    //setAge
    @GetMapping(path = "/json/user/set/age", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({

            @ApiImplicitParam(paramType = "query", name = "age", dataType = "int", required = false, value = "修改年龄")
    })
    public User setUserAge(@RequestParam int age) {
        user.setAge(age);
        return user;
    }

}

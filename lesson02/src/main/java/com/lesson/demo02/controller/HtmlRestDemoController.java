package com.lesson.demo02.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
public class HtmlRestDemoController {

    /***
     * RestController 返回网页
     * @return
     */
    @RequestMapping("/html/01")
    @ResponseBody
    public String html01() {
        return "<html><body>Hello,World</body></html>";
    }

    /***
     * url 参数 参数在//之间
     * @param message
     * @return
     */
    @GetMapping("/html/02/{message}")
    public String html02(@PathVariable String message) {
        return "<html><body>PathVariable value: " + message + "</body></html>";
    }

    /***
     * url 参数 参数在? 后用&符号相连接
     * @param param
     * @param request
     * @return
     */
    @GetMapping("/html/03/param")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "p", dataType = "String", required = false, value = "p值"),
            @ApiImplicitParam(paramType = "query", name = "param2", dataType = "String", required = false, value = "param2值")
    })
    public String html03(@RequestParam(value = "p", required = false, defaultValue = "Empty") String param,
                         HttpServletRequest request) {

        // http://localhost:8080/html/03/param?p=hello
        String param2 = request.getParameter("param2");
        return "<html><body> Request Parameter1 value : " + param
                + " , parameter2 value :" + param2 +
                " </body></html>";
    }


    /***
     * 请求头
     * @param acceptHeader
     * @return
     */
    @GetMapping("/html/04/header")
    public String html04(@RequestHeader(value = "Accept") String acceptHeader) {
        return acceptHeader;
    }

    /***
     * 设置 cookies
     * @param wang
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/html/05/cookie")
    public String html05(@CookieValue( required = false) String wang,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        response.addCookie(new Cookie("foot", "bar"));
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c);
        }
        System.out.println(wang);
        return "success";
    }

    /***
     * ResponseEntity 用来设置 body 以及header
     * @return
     */
    @GetMapping("/html/06/response/entity")
    public ResponseEntity<String> html06(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("myHeader", Arrays.asList("MyHeaderValue"));

        ResponseEntity responseEntity = new ResponseEntity("<html><body>entity OK</body></html>", httpHeaders, HttpStatus.OK);
        return responseEntity;
    }


}

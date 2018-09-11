package com.lesson.demo11;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogsController {
    private final static Logger logger = LoggerFactory.getLogger(LogsController.class);

    @RequestMapping(value = { "/**", "/" }, method = RequestMethod.GET)
    public Long createLogs() {
        logger.info("----------------------------------INFO");
        logger.debug("----------------------------------DEBUG");
        logger.error("----------------------------------ERROR");
        LoggingUtil.creatLogging();


        logger.error("aaaaaaaaaaaaa");
        return System.currentTimeMillis();
    }

    @GetMapping("/log")
    public String log(){
        log.error("test orr");

        return "aa";
    }



}

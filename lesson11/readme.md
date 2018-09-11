# Spring Boot 日志
## 依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-logging</artifactId>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <scope>provided</scope>
</dependency>
```

## 日志配置
- 文本输出
    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <configuration>
    
        <!-- ConsoleAppender-输出到控制台 -->
        <appender name="consoleApp" class="ch.qos.logback.core.ConsoleAppender">
            <layout class="ch.qos.logback.classic.PatternLayout">
                <pattern>
                    %date{yyyy-MM-dd HH:mm:ss.SSS} %-5level[%thread]%logger{56}.%method:%L -%msg%n
                </pattern>
            </layout>
        </appender>
    
        <!-- RollingFileAppender-输出到文件，滚动策略：每过一段时间则新建文件保存输出日志 -->
        <appender name="fileInfoApp" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <!-- 只输出INFO、WARN级别的日志 -->
            <filter class="ch.qos.logback.classic.filter.LevelFilter">
                <level>ERROR</level>
                <onMatch>DENY</onMatch>
                <onMismatch>ACCEPT</onMismatch>
            </filter>
            <encoder>
                <pattern>
                    %date{yyyy-MM-dd HH:mm:ss.SSS} %-5level[%thread]%logger{56}.%method:%L -%msg%n
                </pattern>
            </encoder>
            <!-- 滚动策略 -->
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!-- 路径 -->
                <fileNamePattern>app_log/log/app.info.%d.log</fileNamePattern>
            </rollingPolicy>
        </appender>
    
        <appender name="fileErrorApp" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <!-- 只输出ERROR级别的日志 -->
            <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
                <level>ERROR</level>
            </filter>
            <encoder>
                <pattern>
                    %date{yyyy-MM-dd HH:mm:ss.SSS} %-5level[%thread]%logger{56}.%method:%L -%msg%n
                </pattern>
            </encoder>
    
            <!-- 设置滚动策略 -->
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!-- 路径 -->
                <fileNamePattern>app_log/log/app.err.%d.log</fileNamePattern>
                <!-- 控制保留的归档文件的最大数量，超出数量就删除旧文件，假设设置每个月滚动，
                且<maxHistory> 是1，则只保存最近1个月的文件，删除之前的旧文件 -->
                <MaxHistory>1</MaxHistory>
    
            </rollingPolicy>
        </appender>
        <!-- 设置日志级别为INFO，输出到三个地方 -->
        <root level="INFO">
            <appender-ref ref="consoleApp"/>
            <appender-ref ref="fileInfoApp"/>
            <appender-ref ref="fileErrorApp"/>
        </root>
    </configuration>
    ```
    
- HTML输出
    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <configuration>
    
        <!--定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径-->
        <property name="LOG_HOME" value="D:/IdeaProjects/springbootlearn/lesson11/log" />
        <!-- 控制台输出 -->
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
            </encoder>
        </appender>
        <!-- 按照每天生成日志文件 -->
        <appender name="FILE"  class="ch.qos.logback.core.rolling.RollingFileAppender">
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!--日志文件输出的文件名-->
                <FileNamePattern>${LOG_HOME}/TestWeb.log.%d{yyyy-MM-dd}.log</FileNamePattern>
                <!--日志文件保留天数-->
                <MaxHistory>30</MaxHistory>
            </rollingPolicy>
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
                <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
            </encoder>
            <!--日志文件最大的大小-->
            <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
                <MaxFileSize>10MB</MaxFileSize>
            </triggeringPolicy>
        </appender>
    
        <!-- 生成html格式日志开始 -->
        <appender name="HTML" class="ch.qos.logback.core.FileAppender">
            <!-- 过滤器 -->
            <filter class="ch.qos.logback.classic.filter.LevelFilter">-->
                <level>ERROR</level>
                <onMatch>ACCEPT</onMatch>
                <onMismatch>DENY</onMismatch>
            </filter>
    
            <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
                <layout class="ch.qos.logback.classic.html.HTMLLayout">
                    <pattern>%p%d%msg%M%F{32}%L</pattern>
                </layout>
            </encoder>
            <file>/log/app.err..html</file>
        </appender>
    
        <!-- 生成html格式日志结束 -->
    
        <!-- 每天生成一个html格式的日志开始 -->
        <appender name="FILE_HTML"  class="ch.qos.logback.core.rolling.RollingFileAppender">
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <!--日志文件输出的文件名-->
                <FileNamePattern>${LOG_HOME}/Test111.log.%d{yyyy-MM-dd}.html</FileNamePattern>
                <!--日志文件保留天数-->
                <MaxHistory>30</MaxHistory>
            </rollingPolicy>
            <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
                <layout class="ch.qos.logback.classic.html.HTMLLayout">
                    <pattern>%p%d%msg%M%F{32}%L</pattern>
                </layout>
            </encoder>
            <!--日志文件最大的大小-->
            <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
                <MaxFileSize>10MB</MaxFileSize>
            </triggeringPolicy>
        </appender>
    
        <!-- 每天生成一个html格式的日志结束 -->
    
    
        <!-- show parameters for hibernate sql 专为 Hibernate 定制 -->
        <!-- <logger name="org.hibernate.type.descriptor.sql.BasicBinder"  level="TRACE" />
        <logger name="org.hibernate.type.descriptor.sql.BasicExtractor"  level="DEBUG" />
        <logger name="org.hibernate.SQL" level="DEBUG" />
        <logger name="org.hibernate.engine.QueryParameters" level="DEBUG" />
        <logger name="org.hibernate.engine.query.HQLQueryPlan" level="DEBUG" /> -->
    
        <!--myibatis log configure-->
        <logger name="com.apache.ibatis" level="TRACE"/>
        <logger name="java.sql.Connection" level="DEBUG"/>
        <logger name="java.sql.Statement" level="DEBUG"/>
        <logger name="java.sql.PreparedStatement" level="DEBUG"/>
    
        <!-- 日志输出级别 -->
        <root level="WARN">
            <appender-ref ref="STDOUT" />
            <appender-ref ref="FILE" />
            <appender-ref ref="HTML" />
            <appender-ref ref="FILE_HTML" />
        </root>
        <!--&lt;!&ndash;日志异步到数据库&ndash;&gt;-->
        <!--<appender name="DB" class="ch.qos.logback.classic.db.DBAppender">-->
            <!--&lt;!&ndash;<!–日志异步到数据库 –>&ndash;&gt;-->
            <!--<connectionSource class="ch.qos.logback.core.db.DriverManagerConnectionSource">-->
                <!--&lt;!&ndash;<!–连接池 –>&ndash;&gt;-->
                <!--<dataSource class="com.mchange.v2.c3p0.ComboPooledDataSource">-->
                    <!--<driverClass>com.mysql.jdbc.Driver</driverClass>-->
                    <!--<url>jdbc:mysql://localhost:3306/java</url>-->
                    <!--<user>root</user>-->
                    <!--<password>root</password>-->
                <!--</dataSource>-->
            <!--</connectionSource>-->
        <!--</appender>-->
    
    
    </configuration>
    ```
    
## controller 编写
```java
package com.lesson.demo11;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // lombok 后可以不用每次都编写一个 Logger 在顶部 方便使用
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

```
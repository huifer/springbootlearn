# Spring Boot Mybatis
## 配置
- xml配置
    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
            PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-config.dtd">
    
    
    <configuration>
    
        <properties resource="mybatis/mybatis.properties">
    
        </properties>
    
        <settings>
            <setting name="cacheEnable" value="true"/>
        </settings>
    
        <environments default="dev">
            <environment id="dev">
                <transactionManager type="JDBC"/>
    
                <dataSource type="POOLED">
                    <property name="driver" value="jdbc.driver-class"/>
                    <property name="url" value="jdbc.url"/>
                    <property name="username" value="jdbc.user"/>
                    <property name="password" value="jdbc.password"/>
                </dataSource>
            </environment>
        </environments>
    
    
    </configuration>
    ```
- 数据库配置
    ```properties
    jdbc.driver-class=com.mysql.jdbc.Driver
    jdbc.url=jdbc:mysql://localhost:3306/javatest
    jdbc.user=root
    jdbc.password=wangtao007123
    ```
package com.lesson.demo03;

import com.lesson.demo03.servlet.MyServletRequestListener;
import com.lesson.demo03.springbootApi.MySBFilter;
import com.lesson.demo03.springbootApi.MySBServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.lesson.demo03.servlet", "com.lesson.demo03.filter"})
public class Demo03Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Demo03Application.class, args);
    }

    /***
     * spring boot Servlet API Bean
     * @return
     */
    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

        servletRegistrationBean.setServlet(new MySBServlet());
        servletRegistrationBean.setName("mysbservler");
        servletRegistrationBean.addUrlMappings("/spring-boot/mysbservler");
        servletRegistrationBean.addInitParameter("myName", "myValue");

        return servletRegistrationBean;
    }

    /***
     * spring boot Filter API Bean
     * @return
     */
    @Bean
    public static FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new MySBFilter());
        filterRegistrationBean.addServletNames("mysbservler");

        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE);

        return filterRegistrationBean;

    }

    /***
     * spring boot Listener API Bean
     * @return
     */
    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyServletRequestListener());
        return servletListenerRegistrationBean;
    }


}

package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

//IMPORTANT: adnotarea asta cauta sub ierarhia de sub locatia clasei asteia !!!
//sunt configurate implicit beanuri ce inlocuie web.xml
//e pornit implicit un tomcat pe 8080 !
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8081);
        factory.setSessionTimeout(30, TimeUnit.MINUTES);
        factory.setContextPath("/ecomm");
        return factory;
    }

}
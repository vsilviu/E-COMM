package com.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//IMPORTANT: adnotarea asta cauta sub ierarhia de sub locatia clasei asteia !!!
//sunt configurate implicit beanuri ce inlocuie web.xml
//e pornit implicit un tomcat pe 8080 !
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
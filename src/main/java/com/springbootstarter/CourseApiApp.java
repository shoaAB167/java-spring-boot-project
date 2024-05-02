package com.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This is starting point
@SpringBootApplication
public class CourseApiApp {
    public static void main(String[] args) {
        //sets up default configuration
        //starts spring application context
        //performs class path scan
        //starts tomcat server
        SpringApplication.run(CourseApiApp.class, args);
        //System.out.println("Hello world!");
    }
}
package com.amudhan.caveatemptor;

import com.amudhan.caveatemptor.web.GreetingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = GreetingController.class, basePackages = "com.amudhan.caveatemptor")
//@EnableAutoConfiguration
public class CaveatEmptorApplication extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(CaveatEmptorApplication.class);

    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(CaveatEmptorApplication.class);
        app.run(args);
        log.info("app started!");
    }
}

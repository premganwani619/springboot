package com.dailycodebuffer.springboot.tutorial;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

}
//in spring, we create war file and then deploy it to app or web server ex jboss tomcat web speare
//application will run on embedded server which is apache tomcat server
//server will be embeded on jar files
//hikari connection pull is to maintain connect with database
//spring data jpa creates tables automatically and also update them
//spring boot provides autoconfiguration for ex we don't need to do config for let's say messaging queue ,caching mechanism,hibernate or other libraries etc
//there is a lot of dependency addition in spring,packages,modules,jar files addition ,configurations,property addition ,technologies ,we can group dependencies in starter templates in springboot
//spring boot provides rapid add dev spring boot is easier
//we are moving in microservices arch. so in java spring boot is default option
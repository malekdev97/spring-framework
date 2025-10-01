package com.artcode.artcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArtcodeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ArtcodeApplication.class, args);

		context.getBean("HeavyResource");
	}

}

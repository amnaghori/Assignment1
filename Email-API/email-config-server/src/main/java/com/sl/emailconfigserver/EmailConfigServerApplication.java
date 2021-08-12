package com.sl.emailconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EmailConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailConfigServerApplication.class, args);
	}

}

package cn.exrick.manager.annotation.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:spring/springmvc.xml" })
@EnableAutoConfiguration
@SpringBootApplication
public class MallManagerWebStart {

	public static void main(String[] args) {
		SpringApplication.run(MallManagerWebStart.class, args);
	}
}

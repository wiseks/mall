package cn.exrick.front.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:spring/springmvc.xml" })
@EnableAutoConfiguration
public class MallFrontStart {

	public static void main(String[] args) {
		SpringApplication.run(MallFrontStart.class, args);
	}
}

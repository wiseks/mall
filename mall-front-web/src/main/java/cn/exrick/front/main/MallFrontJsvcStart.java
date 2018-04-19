package cn.exrick.front.main;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ImportResource({ "classpath:spring/springmvc.xml" })
@EnableAutoConfiguration
public class MallFrontJsvcStart {
	
	String[] args = null;

	public static void main(String[] args) {
		SpringApplication.run(MallFrontJsvcStart.class, args);
	}
	
	public void init() throws Exception {

		System.out.println("execute init method！");

	}

	public void init(String[] args) throws Exception {
		this.args = args;
		System.out.println("execute init(args) method");

	}

	public void start() throws Exception {
		BasicConfigurator.configure();
		SpringApplication.run(MallFrontJsvcStart.class, args);

	}

	public void stop() throws Exception {
		System.out.println("execute stop method！");

	}

	public void destroy() throws Exception {

		System.out.println("execute destroy method!");

	}
}

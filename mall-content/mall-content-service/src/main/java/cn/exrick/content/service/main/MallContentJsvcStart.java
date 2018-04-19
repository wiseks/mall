package cn.exrick.content.service.main;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MallContentJsvcStart {
	
	ClassPathXmlApplicationContext ctx = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/*.xml");
		ctx.refresh();
		ctx.start();
		Scanner scan = new Scanner(System.in);
		System.out.println("service started");
		Boolean wait = true;
		while (wait) {
			String result = scan.nextLine();
			while (!result.equals("stop")) {
				System.out.println("service continue");
				result = scan.nextLine();
			}
			System.out.println("are you sure stop services?");
			result = scan.nextLine();
			if (!result.equals("y")) {
				System.out.println("service continue");
				continue;
			}
			wait = false;
		}
		System.out.println("service end");
		ctx.close();
		scan.close();
	}
	
	public void init() throws Exception {

		System.out.println("execute init method！");

	}

	public void init(String[] args) throws Exception {

		System.out.println("execute init(args) method");

	}

	public void start() throws Exception {
		BasicConfigurator.configure();
		System.out.println(">>>>>>>>>execute start method！");
		ctx = new ClassPathXmlApplicationContext("spring/*.xml");
		ctx.refresh();
		ctx.start();
		System.out.println(">>>>>>>>>>>>server started！");

	}

	public void stop() throws Exception {
		ctx.close();
		System.out.println("execute stop method！");

	}

	public void destroy() throws Exception {

		System.out.println("execute destroy method!");

	}
}

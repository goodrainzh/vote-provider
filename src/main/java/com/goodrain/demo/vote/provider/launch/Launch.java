package com.goodrain.demo.vote.provider.launch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {
	private static Logger logger = LoggerFactory.getLogger(Launch.class);

	private static volatile boolean running = true;

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
			context.start();
			logger.info("vote provider started!");

		} catch (Exception e) {
			e.printStackTrace();
			running = false;
			System.exit(1);
		}

		synchronized (Launch.class) {
			while (running) {
				try {
					Launch.class.wait();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}
}

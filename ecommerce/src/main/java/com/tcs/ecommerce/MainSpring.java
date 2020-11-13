package com.tcs.ecommerce;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;

public class MainSpring {

	public static void main(String[] args) {
		System.out.println("Before object creation");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		System.out.println("After context creation");
		DataSource dataSource = context.getBean("getMySQLDataSource", DataSource.class);
		DataSource dataSource2 = context.getBean("getMySQLDataSource", DataSource.class);
		System.out.println("After dataSource");
		System.out.println(dataSource == dataSource2);
		context.close();
	}
}

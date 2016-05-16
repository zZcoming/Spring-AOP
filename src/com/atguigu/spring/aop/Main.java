package com.atguigu.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 * <p/>
 * Created by zZ on 2016-5-14.
 */
public class Main {
	public static void main(String[] args) {
		// 1. 读取spring配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		// 2. 获取bean
		Calculator calculator = (Calculator) applicationContext.getBean(Calculator.class);
		// 3. 调用方法
		calculator.add(3, 5);
		System.out.println();

		// 本方法正常执行，所以有AfterReturning，没有AfterThrowing
		calculator.div(100, 5);
		System.out.println();

		// 本方法异常退出，所以没有AfterReturning，有AfterThrowing
		calculator.div(100, 0);
		System.out.println();
	}
}

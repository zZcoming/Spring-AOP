package com.atguigu.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 切面
 * <p/>
 * Created by zZ on 2016-5-14.
 */
@Component
@Aspect
public class LoggingAspect {

	// 在目标方法开始之前，执行本方法
	@Before("execution(public int com.atguigu.spring.aop.Calculator.*(int, int))")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	@After("execution(public int com.atguigu.spring.aop.Calculator.*(int, int))")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " ends");
	}
}

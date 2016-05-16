package com.atguigu.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 切面
 * <p/>
 * Created by zZ on 2016-5-14.
 */
@Order(2)
@Component
@Aspect
public class LoggingAspect {

	// 可以用此方法代替execution方法，达到统一切入点的效果，在其他切面中也可以使用本方法
	@Pointcut("execution(public int com.atguigu.spring.aop.Calculator.*(int, int))")
	public void declaredJoinPointExpression(){}

	// 前置通知：在目标方法开始之前，执行本方法
	@Before("declaredJoinPointExpression()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	// 后通知：在方法结束后执行，无论是正常退出还是异常退出
	@After("execution(public int com.atguigu.spring.aop.Calculator.*(int, int))")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}

	/**
	 * 返回后通知：正常返回后执行
	 *
	 * @param joinPoint
	 * @param result    方法的返回值
	 */
	@AfterReturning(value = "declaredJoinPointExpression()"
			, returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The result of " + methodName + " is : " + result);
	}

	/**
	 * 抛出异常后通知：在方法抛出异常退出时执行
	 *
	 * @param joinPoint
	 * @param e         抛出的异常
	 */
	@AfterThrowing(value = "declaredJoinPointExpression()"
			, throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " throws exception : " + e);
	}
}

package com.atguigu.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 第二个切面，为了体现@Order的作用
 * <p/>
 * Created by zZ on 2016/5/15.
 */
@Order(1)  // @Order中的数字越小，优先级越高
@Aspect
@Component
public class OrderAspect {

	// 当有多个前置通知时，先执行@Order更小的那个
	@Before("com.atguigu.spring.aop.LoggingAspect.declaredJoinPointExpression()")
	public void before() {
		System.out.println("当有多个前置通知时，先执行@Order更小的那个");
	}
}

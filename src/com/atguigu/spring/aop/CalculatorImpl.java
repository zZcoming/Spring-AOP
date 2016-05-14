package com.atguigu.spring.aop;

import org.springframework.stereotype.Component;

/**
 * 计算器实现类
 * <p/>
 * Created by zZ on 2016-5-14.
 */
@Component
public class CalculatorImpl implements Calculator {
	@Override
	public int add(int i, int j) {
		return i + j;
	}

	@Override
	public int sub(int i, int j) {
		return i - j;
	}

	@Override
	public int mul(int i, int j) {
		return i * j;
	}

	@Override
	public int div(int i, int j) {
		return i / j;
	}
}

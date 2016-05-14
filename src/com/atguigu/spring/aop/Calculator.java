package com.atguigu.spring.aop;

/**
 * 计算器类
 * 四个方法分别是加减乘除
 * <p/>
 * Created by zZ on 2016-5-14.
 */
public interface Calculator {
	int add(int i, int j);

	int sub(int i, int j);

	int mul(int i, int j);

	int div(int i, int j);
}

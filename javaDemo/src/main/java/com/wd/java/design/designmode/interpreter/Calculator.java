package com.wd.java.design.designmode.interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Calculator {

	// 定义表达式
	private Expression expression;

	public Calculator(String str) {
		super();
		Stack<Expression> stack = new Stack<>();
		char[] cs = str.toCharArray();
		Expression left;
		Expression right;
		for (int i = 0; i < cs.length; i++) {
			switch (cs[i]) {
			case '+':
				left = stack.pop();
				right = new VarExpression(String.valueOf(cs[++i]));
				stack.push(new AddExpression(left, right));
				break;
			case '-':
				left = stack.pop();
				right = new VarExpression(String.valueOf(cs[++i]));
				stack.push(new SubExpression(left, right));
				break;
			default:
				stack.push(new VarExpression(String.valueOf(cs[i])));
				break;

			}
			System.out.println("stack=" + Arrays.toString(stack.toArray()));
		}
		this.expression = stack.pop();
		System.out.println(expression);

	}

	public int run(HashMap<String, Integer> val) {
		return this.expression.interpreter(val);
	};
}

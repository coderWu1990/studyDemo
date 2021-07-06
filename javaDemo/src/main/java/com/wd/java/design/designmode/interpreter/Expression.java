package com.wd.java.design.designmode.interpreter;

import java.util.HashMap;

public abstract class Expression {

	public abstract int interpreter(HashMap<String, Integer> val);
}

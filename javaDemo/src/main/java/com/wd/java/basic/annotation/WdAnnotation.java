/**
 * 
 */
package com.wd.java.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target (value={ElementType.METHOD})
public @interface WdAnnotation {
	String name();
	int age();
	int[] score();
}

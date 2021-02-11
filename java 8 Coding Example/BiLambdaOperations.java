/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
class Employee11{
	String name;
	Double salary;
	public Employee11(String name,Double sal) {
		this.name = name;
		this.salary = sal;
	}
}

public class BiLambdaOperations {
	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bp = (a,b) ->(a+b)%2==0;
		System.out.println(bp.test(10, 20));
		
	}
}



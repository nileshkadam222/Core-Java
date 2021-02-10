/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

interface Interf{
	public static void m1() {
		System.out.println("static method executed");
	}
	
	public default void m2() {
		System.out.println("defaut method executed");
	}
}
public class StaticMethodsInIntraface {
	public static void main(String[] args) {
		Interf.m1();
		
	}
}



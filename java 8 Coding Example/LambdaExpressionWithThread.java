/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

class MyThread implements Runnable {
	private String params = null;

	public MyThread(String uName) {
		this.params = uName;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread Running with params " + this.params);
		}
	}
}

public class LambdaExpressionWithThread {

	private static String threadParam = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String uName = "Hello";
		MyThread t = new MyThread(uName);
		Thread t1 = new Thread(t);
		t1.start();

		//lambdaExpression
		threadParam = uName;
		Thread t2 = new Thread(r);
		t2.start();
	}

	static Runnable r = () -> {
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Child Thread Running with Lambada Expression"+threadParam);
		}
	};

}

/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.function.Consumer;

public class ConsumerFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<String> c = s->System.out.println("this is "+ s);
		
		c.accept("Nilesh");

	}

}



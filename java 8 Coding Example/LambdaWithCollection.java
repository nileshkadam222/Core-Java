/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class myComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return (o1 < o2)?-1:(o1>o2)?1:0;
	}
	
}
public class LambdaWithCollection {
	public static void main(String args[]) {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(68);
		l1.add(45);
		l1.add(65);
		l1.add(88);
		l1.add(9);
		l1.add(5);
		System.out.println(l1);
		//Without lambada Expression
		Collections.sort(l1,new myComparator());
		System.out.println(l1);
		Comparator<Integer> c = (o1,o2)->(o1 < o2)?-1:(o1>o2)?1:0;
		Collections.sort(l1,c);
		System.out.println("Using Lambda Expression" + l1);
		
	}
	
}



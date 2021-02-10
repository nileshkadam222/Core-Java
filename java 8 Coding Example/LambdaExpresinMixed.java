/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.function.Consumer;
import java.util.function.Function;

class StudentC {
	String name;
	int marks;

	public StudentC(String name, int marks) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.marks = marks;
	}

}

public class LambdaExpresinMixed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<StudentC, String> f = s -> (s.marks >= 80) ? "A" : (s.marks >= 60) ? "B" : (s.marks >= 35) ? "c" : "";
		
		Consumer<StudentC> c = stu->{
			System.out.println("Student Name " + stu.name);
			System.out.println("Studen Marks " + stu.marks);
			System.out.println("Student Gread " + f.apply(stu));
			System.out.println();
		};
		
		StudentC[] s = { new StudentC("Yogesh", 50), new StudentC("Nilesh", 90) };
		
		for (StudentC stu : s)c.accept(stu);
		
	}

}

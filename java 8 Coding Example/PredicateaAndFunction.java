/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.function.Function;
import java.util.function.Predicate;

class Student {
	String name;
	int marks;

	public Student(String name, int marks) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.marks = marks;
	}

}

public class PredicateaAndFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Student, String> f = s -> (s.marks >= 80) ? "A" : (s.marks >= 60) ? "B" : (s.marks >= 35) ? "c" : "";

		Student[] s = { new Student("Yogesh", 50), new Student("Nilesh", 90) };
		for (Student stu : s) {
			System.out.println("Student Name " + stu.name);
			System.out.println("Studen Marks " + stu.marks);
			System.out.println("Student Gread " + f.apply(stu));
			System.out.println();

		}
	}

}

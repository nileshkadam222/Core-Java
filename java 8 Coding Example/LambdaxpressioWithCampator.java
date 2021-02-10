/**
 * @author NileshK
 *
 * 
 */
package com.mrm.share_point_demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee {
	String name;
	int id;
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
	
}

public class LambdaxpressioWithCampator {
	public static void main(String[] 
			args) {
		List<Employee> l = new ArrayList<Employee>();
		l.add(new Employee("Nilesh", 109));
		l.add(new Employee("Harshu", 19));
		l.add(new Employee("Yogesh", 98));
		l.add(new Employee("Ashok", 87));
		l.add(new Employee("Yogesh", 98));
		System.out.println("List -->"+ l);
		Collections.sort(l,(o1,o2)->o1.id<o2.id?-1:o1.id>o2.id?1:0);
		System.out.println("List Sorting With Integr Value -- > "+l);
		Collections.sort(l,(s1,s2)->s1.name.compareToIgnoreCase(s2.name));
		System.out.println("List Sorting WIth Sring Value ----->" + l);
		
		
	}
}



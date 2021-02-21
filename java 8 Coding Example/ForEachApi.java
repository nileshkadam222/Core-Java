package testing.streams;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForEachApi {

	public static void main(String args[]) {
		String a= "Hi i am Nilesh";
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(32);
		l1.add(54);
		l1.add(76);
		l1.add(75);
		
		System.out.println("All Students Marks : "+ l1);
		
		l1.stream().forEach(System.out::println);
	}
}

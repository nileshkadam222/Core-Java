package testing.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStringArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> s = new ArrayList<String>();
		s.add("Nilesh Kadam");
		s.add("Nilesh");
		s.add("Nilesh Kad");
		s.add("Nilesh Ka");
		s.add("Nilesh Kada");
		System.out.println("Array : "+ s);
		
		Comparator<String> c = (s1,s2)->{
			int l1= s1.length();
			int l2= s2.length();
			if(l1<l2) {
				return -1;
			}else if(l1>l2) {
				return +1;
			}else {
				return s1.compareTo(s2);
			}
		};
		
		List<String> sorted = s.stream().sorted(c).collect(Collectors.toList());
		System.out.println("Sorted List : "+ sorted);

	}

}

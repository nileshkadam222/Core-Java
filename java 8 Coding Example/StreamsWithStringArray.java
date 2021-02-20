package testing.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsWithStringArray {

	public static void main(String args[]) {
		
		ArrayList<String> studentsNames = new ArrayList<String>();
		studentsNames.add("A");
		studentsNames.add("F");
		studentsNames.add("B");
		studentsNames.add("C");
		studentsNames.add("D");
		studentsNames.add("Z");
		studentsNames.add("E");
		
		System.out.println("Full Student List");
		
		//Sort Asending order
		
		List<String> AscOrder = studentsNames.stream().sorted().collect(Collectors.toList());
		System.out.println("Asc Sorter List: "+AscOrder);
		
		List<String> DesOrder = studentsNames.stream().sorted((s1,s2)->-s1.compareToIgnoreCase(s2)).collect(Collectors.toList());
		System.out.println("Des Sorter List: "+DesOrder);
		
		List<String> DesOrder1 = studentsNames.stream().sorted((s1,s2)->s2.compareToIgnoreCase(s1)).collect(Collectors.toList());
		System.out.println("Des Sorter List: "+DesOrder1);
	}
}

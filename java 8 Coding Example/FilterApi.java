package testing.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub-
		ArrayList<Integer> studendsMarks = new ArrayList<Integer>();
		studendsMarks.add(70);
		studendsMarks.add(80);
		studendsMarks.add(90);
		studendsMarks.add(45);
		studendsMarks.add(34);
		studendsMarks.add(23);
		studendsMarks.add(32);
		studendsMarks.add(12);
		System.out.println("All studenst Lists: "+studendsMarks);
		//get List of pass students
		List<Integer> passStudens = studendsMarks.stream().filter(i->i>60).collect(Collectors.toList());
		System.out.println("List of pass students :"+passStudens);
		
		//get List of Failed Students
		List<Integer> failedStudents = studendsMarks.stream().filter(i->i<35).collect(Collectors.toList());
		System.out.println("Failed Students list: "+failedStudents);
		
		//give the grace marks the studens have a marks in range 30 to 35
		List<Integer> giveGraseMarks = studendsMarks.stream().map(m->{
				if(m>=30 && m<=40) {
					return m=m+5;
				}
				return m;
			}).collect(Collectors.toList());
		
		System.out.println("Grase marks for students have marks between 30 and 40"+giveGraseMarks);
		
		//count failed students
		long count = studendsMarks.stream().filter(i->i<35).count();
		System.out.println("Count of Failed Students: "+count);
		
		//counts of pass students
		long passStudentsCount = studendsMarks.stream().filter(i->i>35).count();
		System.out.println("Count of pass students: "+passStudentsCount);
		
		//sorting ArrayList using stream api
		List<Integer> AscSorting = studendsMarks.stream().sorted().collect(Collectors.toList());
		System.out.println("Asc order sorting Array");
		
		//Desending order sorting
		Comparator<Integer> c = (obj1,obj2) -> (obj1 < obj2)?1:(obj1 > obj2) ? -1 : 0;
		
		Comparator<Integer> c1 = (obj1,obj2) -> obj1.compareTo(obj2);

		List<Integer> DesSortedList = studendsMarks.stream().sorted(c).collect(Collectors.toList());
		System.out.println("Des Sorting List : "+DesSortedList);
		
		
		
	}

}

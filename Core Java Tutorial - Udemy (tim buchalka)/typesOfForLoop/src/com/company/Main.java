package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //types of for loops in java collections

        /* 1.By Iterator interface.
           2.By for-each loop.
           3.By ListIterator interface.
           4.By for loop.
           5.By forEach() method.
           6.By forEachRemaining() method.*/

        ArrayList<String> studentList = new ArrayList<String>();
        studentList.add("Nilesh");
        studentList.add("Sushant");
        studentList.add("Paritosh");

        //by Iterator interface
        Iterator it = studentList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //reverse the at1 = rrayList

        System.out.println("Reverse the arrayList");
        Iterator  it1 = studentList.listIterator(studentList.size());
        while (((ListIterator) it1).hasPrevious()){
                System.out.println(((ListIterator) it1).previous());
        }

        //for Each loop
        for(String student : studentList){
            System.out.println(student);
        }


        //for Each method

       studentList.forEach(student ->{
            System.out.println(student);
        });

       //for forEachRemaining method

        Iterator it3 = studentList.iterator();

        it3.forEachRemaining(student ->{
            System.out.println(student);
        });








    }
}

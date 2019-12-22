package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListProgram {

    ArrayList<String> grocreyList = new ArrayList();
    public void addGrocreyList(String groceryItem){
        grocreyList.add(groceryItem);
    }

    public void printGroceryList(){
        System.out.println("Grocery List:");
        grocreyList.forEach(groceryItem ->{
            System.out.println(groceryItem);
        });
    }

    public void  modifyGroceryList(int position,String item){
        grocreyList.set(position,item);
    }

    public void removeGroceryItemByPosition(int position){
        grocreyList.remove(position);
    }

    public void removeGroceryItemByName(String item){
        int position = grocreyList.indexOf(item);
        grocreyList.remove(position);
    }

    public String searchItem(String item){
        int position = grocreyList.indexOf(item);
        if(position <= 0){
            return grocreyList.get(position);
        }
        return "Not Found";
    }




}

package com.company;

public class EvenDigitSum {
    // write your code here
    private  int EvenDigitSum(int number){
        if(number <0){
            return 1;
        }else{
            int altNumber = number;
            int checker;
            int sum = 0;
            while(altNumber != 0){
                checker = altNumber % 10;
                if(checker % 2 ==0){
                    sum =sum + checker;
                }
                altNumber = altNumber / 10;

            }
            return sum;
        }

    }

    public static void main(String args[]){
        EvenDigitSum ed = new EvenDigitSum();
        int sum = ed.EvenDigitSum(200);
        System.out.println("Number "+sum);

    }
}
package com.company;

public class Main {

    public static void main(String[] args) {
        int score = calculateScore(10,30);
        System.out.print("score" + score);

        int score2 = calculateScore(20);
        System.out.print("score 2" + score2);
	// write your code here
    }

    public static int calculateScore(int p1,int p2){
        return p1 + p2;
    }

    public static int calculateScore(int p2){
        return 1000 + p2;
    }
}

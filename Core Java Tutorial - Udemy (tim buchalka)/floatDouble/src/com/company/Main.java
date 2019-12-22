package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here


        printMegaBytesAndKiloBytes(1024);
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        if (kiloBytes >= 0) {

            int megabytes = (int) (kiloBytes / 1024);
            int remainingKilobytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megabytes + " MB and " +
                    remainingKilobytes + " KB");
        } else
            System.out.println("Invalid Value");

    }
}
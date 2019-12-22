package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //maximum length of byte is 2 rase to 7
        byte maxByhteValue = (byte)Math.pow(2,7);
        byte minByteValue = maxByhteValue;
        System.out.println("maximum value of byte"+maxByhteValue);
        System.out.println("minimum value of byte -"+minByteValue);

        //maximum length of short is 2 rase 15
        short maxShortValue = (short) Math.pow(2,15);
        short minShortValue = (short)Math.pow(2,15);
        System.out.println("max length of short value"+maxShortValue);
        System.out.println("min length of short value"+minShortValue);

        //maximum length of integer value is 2 rase to 31

        int maxIntergerLength = (int)Math.pow(2,31);
        System.out.println("maximum length of integer : "+maxIntergerLength);
        System.out.println("maximum length of integer : -"+(maxIntergerLength -1));

    }
}

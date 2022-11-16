package org.horbola.leetcode.java.median;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Median {
    public Integer[] arr1, arr2;
    public int median;

    public Median(Integer[] arr1, Integer[] arr2){
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public static void main(String[] args) {
        for (;;){
            System.out.println("\n");

            System.out.println("Please enter the string to search for palindromic substring");
            System.out.println("If you want to close the program, please press 'c' and continue to run the program, press Enter");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.equalsIgnoreCase("c"))
                break;
            else {
                Integer arr1[] = getArray(in, "first");
                System.out.println("\n");
                Integer arr2[] = getArray(in, "second");
                callProgram(arr1, arr2);
            }
        }
    }

    private static Integer[] getArray(Scanner in, String cardinal){
        String str = String.format("please enter the number of elements of the %s array", cardinal);
        System.out.println(str);
        Integer length = in.nextInt();
        Integer[] elems = new Integer[length];
        for (int i = 0; i < length; i++){
            String strr = "";
            if (elems[0] == null)
                strr = String.format("Enter the first element of the %s array", cardinal);
            else
                strr = String.format("Enter the next element of the %s array", cardinal);
            System.out.println(strr);

            elems[i] = in.nextInt();
        }
        return elems;
    }

    private static void callProgram(Integer arr1[], Integer arr2[]){
        Median median = new Median(arr1, arr2);
        median.findMedian().print();
    }

    public void print(){
        System.out.println("The median of the two integer arrays is: " + this.median);
    }



    public Median findMedian(){
        List<Integer[]> list = new ArrayList(Arrays.asList(this.arr1));
        list.addAll(new ArrayList(Arrays.asList(this.arr2)));
        var arr = list.toArray();
        Arrays.sort(arr);

        int index = 0;
        if (arr.length % 2 == 0){
            index = arr.length / 2;
            Integer num1 = (Integer) arr[index];
            Integer num2 = (Integer) arr[index - 1];
            int avr = (num1 + num2) / 2;
            this.median = avr;
        }
        else {
            index = (arr.length - 1) / 2;
            Integer num1 = (Integer) arr[index];
            this.median = num1;
        }

        return this;
    }
}

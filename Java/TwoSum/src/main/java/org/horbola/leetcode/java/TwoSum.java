package org.horbola.leetcode.java;

import java.util.Scanner;

public class TwoSum {
    public Integer[] source;
    public int target;
    public int[] pair;

    public TwoSum(Integer[] source, int target){
        this.source = source;
        this.target = target;
    }

    public static void main(String[] args) {
        for (;;){
            System.out.println("\n");

            System.out.println("Please enter the source array and target number to find the pair");
            System.out.println("If you want to close the program, please press 'c' and continue to run the program, press Enter");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.equalsIgnoreCase("c"))
                break;
            else {
                Integer[] source = getArray(in);
                System.out.println("\n");
                System.out.println("please enter the target number");
                int target = in.nextInt();
                callProgram(source, target);
            }
        }
    }

    private static Integer[] getArray(Scanner in){
        String str = "please enter the length of elements of the array";
        System.out.println(str);
        Integer length = in.nextInt();
        Integer[] elems = new Integer[length];
        for (int i = 0; i < length; i++){
            String strr = "";
            if (elems[0] == null)
                strr = "Enter the first element of the array";
            else
                strr = "Enter the next element of the array";
            System.out.println(strr);

            elems[i] = in.nextInt();
        }
        return elems;
    }

    private static void callProgram(Integer[] source, int target){
        var twoSum = new TwoSum(source, target);
        twoSum.findPair().print();
    }

    private void print() {
        if (pair == null)
            System.out.println("Error occurred");
        else
            System.out.println("The pair is: " + pair[0] + " and : " + pair[1]);
    }

    public TwoSum findPair(){
        this.validateData();
        this.pair = new int[2];
        for (int i = 0; i < source.length; i++) {
            int el = source[i];
            for (int j = i+1; j < source.length; j++) {
                int ell = source[j];
                if( el + ell == target ) {
                    pair[0] = el;
                    pair[1] = ell;
                }
            }
        }
        this.pair = pair;
        return this;
    }

    private void validateData(){
        if ( (source.length < 2) || source.length > (Math.pow(10, 4)) ){
            System.out.println("Please provide the array with at least two elements and at most 10*10*10*10");
            return;
        }

        for (int el : source){
                if ( (el <= -Math.pow(10, 9)) || el >= Math.pow(10, 9)){
                System.out.println("You have provided this number: "+ el +" beyond the specified range");
                System.out.println("Please provide each element of the array greater than 10*10 and less than 10*10*10*10");
                return;
            }
        }

        if ( (target <= -Math.pow(10, 9)) || (target >= Math.pow(10, 9)) ){
            System.out.println("Please provide each element of the array greater than 10*10 and less than 10*10*10*10");
            return;
        }
    }

}

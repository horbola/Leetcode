package org.horbola.leetcode.java;

import java.util.*;

public class RomanToInt {
    Map<Character, Integer> digitVal;
    String sampString = "";
    int intVal = 0;

    RomanToInt(String sampString){
        this.sampString = sampString;
        digitVal = new TreeMap();
        digitVal.put('i', 1);
        digitVal.put('v', 5);
        digitVal.put('x', 10);
        digitVal.put('l', 50);
        digitVal.put('c', 100);
        digitVal.put('d', 500);
        digitVal.put('m', 1000);
    }

    public static void main(String[] args) {
        for (;;){
            System.out.println("\n");
            System.out.println("Please enter the roman number to convert to integer");
            System.out.println("If you want to close the program, please press 'c'");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equalsIgnoreCase("c"))
                break;
            else {
                callProgram(input);
            }
        }
    }

    private static void callProgram(Object input){
        String str = (String) input;
        var romanInt = new RomanToInt(str);
        romanInt.convert().print();
    }

    public void print(){
        if (this.intVal == 0){
            System.out.println("Sorry! error occurred.");
        }
        else {
            String str = String.format("The Integer form of the %s is: %s", this.sampString, this.intVal);
            System.out.println(str);
        }
    }


    RomanToInt convert(){
        String romanString = this.sampString.toLowerCase();
        Map<Integer, Integer> romanMap = new TreeMap();

        for(int i = 0; i < romanString.length(); i++){
            // convert roman letter to integer separately and put the integer
            Integer intVal = digitVal.get(romanString.charAt(i));
            romanMap.put(i, intVal);
        }

        int adder = 0;
        Set<Map.Entry<Integer, Integer>> romanEntrySet = romanMap.entrySet();
        while(!romanEntrySet.isEmpty()){
            Iterator it = romanEntrySet.iterator();
            Map.Entry<Integer, Integer> firstRoman = (Map.Entry<Integer, Integer>)it.next();
            Map.Entry<Integer, Integer> secondRoman = (Map.Entry<Integer, Integer>)it.next();

            if(!it.hasNext()){
                adder += firstRoman.getValue();
                break;
            }

            if( (firstRoman.getValue() > secondRoman.getValue()) || (firstRoman.getValue() == secondRoman.getValue()) ){
                adder += firstRoman.getValue();
                romanMap.remove(firstRoman.getKey());
            }
            else{
                adder += secondRoman.getValue() - firstRoman.getValue();
                romanMap.remove(firstRoman.getKey());
                romanMap.remove(secondRoman.getKey());
            }
        }
        this.intVal = adder;
        return this;
    }

}

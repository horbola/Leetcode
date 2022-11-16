package org.horbola.leetcode.java.palindromicsubstring;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromicSubstring {
    public String str = "";
    public String palindrome = "";
    public List<String> palindromes = new ArrayList<>();

    public PalindromicSubstring(String str){
        this.str = str;
    }

    public static void main(String[] args) {
        for (;;){
            System.out.println("\n");
            System.out.println("Please enter the string to search for palindromic substring");
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
        var palindrome = new PalindromicSubstring(str);
        palindrome.findPalindrome().print();
    }


    private void print() {
        if (this.palindrome.equals(""))
            System.out.println("There's no palindromic match in this string");
        else
            System.out.println("The palindromic substring is: " + this.palindrome);
    }

    public void test(){
        String startString = "bab";
        String endString = "bab";

        if (startString.equals(endString)){
            System.out.println("it's equal");
        }
    }




    /**
     * which approach is implemented? find that..
     * @return this instance.
     */
    private PalindromicSubstring findPalindromeBackNForth() {
        for (int i = 0, j = this.str.length(); i < this.str.length(); i++, j--){
            for (int k = 0, l = this.str.length(); k < i; k++, l--){
                String startString = this.str.substring(k, i);
                String endString = this.str.substring(j, l);
                System.out.println("start string is: " + startString + ", end string is: " + endString);
                if (startString.equalsIgnoreCase(endString)){
                    this.palindromes.add(startString);
                }
            }

            String tmp = "";
            for (String s : this.palindromes ){
                if (s.length() > tmp.length())
                    tmp = s;
            }
            this.palindrome = tmp;
        }
        return this;
    }

    /**
     * finds palindromic substring in any position
     * @return
     */
    private PalindromicSubstring findPalindrome() {
        for (int i = 0; i < this.str.length(); i++){
            for (int j = 0; j < i; j++){
                String foreward = this.str.substring(j, i);
                String backward = new StringBuilder(foreward).reverse().toString();
                if (foreward.equalsIgnoreCase(backward)){
                    this.palindromes.add(foreward);
                }
            }
        }

        String tmp = "";
        for (String s : this.palindromes ){
            if (s.length() > tmp.length())
                tmp = s;
        }
        this.palindrome = tmp;

        return this;
    }
}

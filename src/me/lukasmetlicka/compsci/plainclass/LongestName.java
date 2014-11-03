package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;
public class LongestName{
 
  public static void main(String[] args){
    
    Scanner console = new Scanner(System.in);
    System.out.println("Enter Names:");
    String input = console.nextLine();
    String[] inputArray = input.split(" ");
    String longestName = inputArray[0];
    for ( int i = 1; i < inputArray.length; i++ ){
      if ( inputArray[i].length() > longestName.length() ){
       longestName = inputArray[i]; 
      }
    }
    System.out.println("Longest Name:\t"+longestName);
  }
  
}
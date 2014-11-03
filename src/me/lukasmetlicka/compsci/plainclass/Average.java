package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;

public class Average {
 
  public static void main(String[] args) {
   
    Scanner input = new Scanner(System.in);
    System.out.println("Enter three numbers delimited by spaces:");
    String numbers = input.nextLine();
    
    String[] numbersArray = numbers.split(" ");
    double added = 0;

    
    System.out.println("Your average is: " + added/3 );
  }
  
}
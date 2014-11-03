package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;
public class GangstaName {

  public static String firstInitial(String a){
    
    String initial = a.substring(0,1);
    initial = initial.toUpperCase();
    return initial;
    
  }
  public static void main(String[] argz){

    Scanner console = new Scanner(System.in);
    System.out.println("Enta yo name, playa!");
    String input = console.nextLine();
    String[] inputArray = input.split(" ");
    String firstName = inputArray[0];
    String lastName = inputArray[1];
    String initial = firstInitial(firstName);
    System.out.println( "Your gangsta name is: \t" + '"' + initial + ". Diddy " + lastName.toUpperCase() + " " + firstName + "-izzle!" + '"'); 
    
  }

}
  



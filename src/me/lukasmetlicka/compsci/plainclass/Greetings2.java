package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;

public class Greetings2 {
  
  public static void main(String[] args) {
    
    Scanner kboard = new Scanner(System.in);
    System.out.println("Enter first name, PUNY HUMAN!");
    String first = kboard.nextLine();
    System.out.println("Input your last name, INSIGNIFGANT ONE!");
    String last = kboard.nextLine();
    System.out.println("I greet you "+ first + " of the tribe " + last);
    System.out.println("WELCOME TO YOUR DOOM!");
    
  }
  
}
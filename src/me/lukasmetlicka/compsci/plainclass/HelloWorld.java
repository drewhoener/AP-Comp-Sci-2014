package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;
public class HelloWorld {
  int i;
  public int doubler( int i ) {
   i = i * i; 
   return i;
  }
 
  public static void main(String[] args) {
    final String HELLOWORLD = "Hello, World!";
    int subtot = 38 + 40 + 30;
    System.out.println("Subtotal:");
    System.out.println( "\t" + subtot);
    System.out.println( "Tax:");
    System.out.println( "\t" + subtot * 0.8);
    System.out.println( "Tip:");
    System.out.println( "\t" + subtot * .15);
    System.out.println( "Total:");
    System.out.println( "\t" + (subtot * 0.8) + ( subtot * .15) + subtot );
    Scanner input = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("give me a number to double!");
    int inputval = input.nextInt();
    int val = new HelloWorld().doubler(inputval);
    System.out.println("Doubling...");
    System.out.println("Doubled number is:");
    System.out.println(val);
 }
}
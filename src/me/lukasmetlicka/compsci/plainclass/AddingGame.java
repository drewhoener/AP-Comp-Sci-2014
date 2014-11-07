package me.lukasmetlicka.compsci.plainclass;

import java.util.Random;
import java.util.Scanner;
public class AddingGame {
  
  Random random = new Random();
  public int valueMaker(int a, int b){
    
    return random.nextInt(b) + a;
    
  }
  
  public int numOfVals(){
    
    int val = random.nextInt(5) + 1;
    return val;
  }
  
  public static void main(String[] args){
    
   AddingGame a = new AddingGame();
   Scanner console = new Scanner(System.in);
   int deaths = 0;
   int points = 0;
   while (deaths <= 3){
  
    int numOfVals = a.numOfVals();
    int val = a.valueMaker(1,10);
    int total = val;
    
    System.out.print(val);
    for (int i = 1; i < numOfVals; i++){
      val = a.valueMaker(1,10);
      System.out.print(" + " + val );
      total += val;
    }
    System.out.print(" =\t");
    int input = console.nextInt();
    if ( input == total ){
      
     points++;
     System.out.print("Correct! # of points:\t" + points + "\n"); 
      
    }
    else {
      
     deaths++;
     System.out.print("Incorrect! the correct awnser was " + total + "\tYou have " + (3 - deaths) + " lifes left!\n");
      
    }
    
  }
  System.out.println("You loose! you had " + points + " points!");
}
}
package me.lukasmetlicka.compsci.plainclass;

import java.util.Random;
public class DiceGame {

  public static void main(String[] args){

  Random random = new Random();
   int tot = 0;
   int count = 0;
   while (tot != 7){
     
    int val1 = random.nextInt(6) + 1;
    int val2 = random.nextInt(6) + 1;
    System.out.println( val1 + " + " + val2 + " = " + (val1 + val2));
    tot = val1 + val2;
    count++;
     
   }
   System.out.println("You won in " + count + " tries!"); 
  }
  
}


package me.lukasmetlicka.compsci.plainclass;

import java.util.Random;
public class TripleHead{
  
  public static boolean isHeads(Random r){
    int myRand = r.nextInt(2);
    if ( myRand == 0 ){
     return false;
    } else {
      return true; 
    }
  }
  
// static method
  public static void main(String[] args){
   
   Random r = new Random();
   int numOfHeads = 0;
   String coin = "";
   int numOfFlips = 0;
   while ( numOfHeads < 3 ){
     
     boolean value = isHeads(r);
     if (value){
       coin = "Heads";
       numOfHeads++;
     } else {
      coin = "Tails";
      numOfHeads = 0;
     }
     System.out.println("We flipped a " + coin );
     numOfFlips++;
     
   }
    System.out.println("We flipped "+ numOfFlips + " coins!");
  }
  
}
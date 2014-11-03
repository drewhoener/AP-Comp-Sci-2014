package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;
public class Temp{
  
  public static void main(String[] args){
    
    Scanner console = new Scanner(System.in);
    System.out.println("Give me temperature values!");
    String input = console.nextLine();
    String[] inputArray = input.split(" ");
    double[] values = new double[inputArray.length];
    try{
    for ( int i = 0; i < values.length; i++){
     values[i] = Double.parseDouble(inputArray[i]); 
    }
    }catch(Exception e){
      e.printStackTrace();
    }
    
    //Calculate Average
    double average = 0;
    for ( int i = 0; i < values.length; i++ ){
      average += values[i];
    }
    average /= values.length;
    //Print Values
    System.out.print("Your values are:\n"+values[0]);
    for ( int i = 1; i < values.length; i++ ){
      System.out.print( "\t" +values[i] );
    }
    System.out.println();
    //Print Average
    System.out.println("Average:\t"+average);
    //Calculate above average
    System.out.print("Values above the average:");
    for ( int i = 0; i < values.length; i++ ){
      if ( values[i] > average ){
       System.out.print("\t"+values[i]);
      }
    }
    System.out.println();
    //Calculate below average
    System.out.print("Values below the average:");
    for ( int i = 0; i < values.length; i++ ){
      if ( values[i] < average ){
       System.out.print("\t"+values[i]);
      }
    }
    System.out.println();
  }
  
}
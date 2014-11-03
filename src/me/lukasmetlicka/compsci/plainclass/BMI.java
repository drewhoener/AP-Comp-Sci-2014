package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;
public class BMI {

  public static String eval(double bmi ){
    
    if ( bmi < 18.5 ){
      
     return "underweight"; 
      
    }
    else if ( bmi >= 18.5 && bmi <= 24.9 ){
     
      return "normal";
      
    }
    else if ( bmi >= 25 && bmi <= 29.9 ){
      
     return "overweight"; 
      
    }
    else {
      
     return "obese"; 
      
    }
    
  }
  
  public static double max( double a, double b){
    
   if ( a > b) {
     
    return a; 
     
   } else {
     
    return b; 
     
   }
  }
   public static double min( double a, double b){
     
     if ( a < b) {
     
    return a; 
     
   } else {
     
    return b; 
     
   }
     
   }
   
    
  
  
  public static void main(String[] args){
   
    Scanner input = new Scanner(System.in);
    System.out.println("This program reads data for two people and computes their body mass index (BMI).");
    
    System.out.println("\n Enter the first person's information: ");
    
    System.out.println("Height: ");
    double h1 = input.nextDouble();
    System.out.println("Weight: ");
    double w1 = input.nextDouble();
    
    System.out.println(" \n Enter the next person's information: ");
    
    System.out.println("Height: ");
    double h2 = input.nextDouble();
    System.out.println("Weight: ");
    double w2 = input.nextDouble();
    
    double bmi1 = (w1/(h1 * h1)) * 703;
    double bmi2 = (w2/(h2 * h2)) * 703;
    
    
    System.out.println( "the first person's BMI is: \t" + Double.toString(bmi1));
    System.out.println( "the first person is: \t" + eval(bmi1));
    System.out.println( " \n ");
    System.out.println( "the second person's BMI is: \t" + Double.toString(bmi2));
    System.out.println( "the second person is: \t" + eval(bmi2));
    System.out.println( "\n The difference in BMI is: \t" + Double.toString(max(bmi1,bmi2) - min(bmi1, bmi2)));
    
  }
  
  
}


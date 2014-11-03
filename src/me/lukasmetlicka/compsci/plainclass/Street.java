package me.lukasmetlicka.compsci.plainclass;

import java.util.Scanner;
public class Street{
  
  public static void main(String[] args){
    
   Scanner console = new Scanner(System.in);
   System.out.println("Enter street (#, Streetname + St/Ln/Ave, City, State, Zip)");
   String input = console.nextLine();
   String[] inputArray = input.split(" ");
   String streetNo = inputArray[0];
   String streetName = inputArray[1] + " " + inputArray[2];
   String city = inputArray[3];
   String state = inputArray[4];
   String zip = inputArray[5];
   System.out.println("Number:\t"+streetNo+"\n"+"Street:\t"+streetName+"\n"+"City:\t"+city+"\n"+"State:\t"+state+"\n"+"Zip:\t"+zip);
    
  }
  
}
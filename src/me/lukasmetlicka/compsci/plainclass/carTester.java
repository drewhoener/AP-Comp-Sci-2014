package me.lukasmetlicka.compsci.plainclass;

public class carTester{
  
  public static void main(String[] args){
    
    Car c1 = new Car();
    System.out.println(c1.getPosition());
    c1.drive(5);
    System.out.println(c1.getPosition());
    
  }
  
}
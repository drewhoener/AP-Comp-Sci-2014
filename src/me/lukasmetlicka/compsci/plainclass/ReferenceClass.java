package me.lukasmetlicka.compsci.plainclass;

public class ReferenceClass {
  
  public static void main(String[] args) {
    
    BankAccount b1 = new BankAccount( 90 );
    System.out.println( b1.getBal(  ) );
    b1.deposit( 10 );
    System.out.println( b1.getBal(  ) );
    
  }
  
}
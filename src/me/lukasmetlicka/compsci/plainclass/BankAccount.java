package me.lukasmetlicka.compsci.plainclass;

public class BankAccount {
  
 //Data
  private double bal;
  
  //Constuctors
  public BankAccount() {
    
    bal = 0;
    
  }
  public BankAccount(double a) {
    
    bal = a;
    
  }
  
  //Methods
  
  //Setters
  public void deposit(double a) {
    
    bal += a;
    
  }
  
  public void atm(double a) {
   
   if ( bal - a > 0 ) {
     bal -= a;
     this.myatm(a);
   
   }
   if ( bal - a == 0 ) {
     
    this.emptyBal(); 
     
   } 
   if ( bal - a < 0 ) {
     
     this.no$();
   
   }
  }
   
  public String removeAccount() {
    
   bal = 0;
   return "Your account has been removed!";
    
  }
  public String quick20(){

    if ( bal - 20 > 0){
      
     bal -= 20;
     this.getBal();
      
    }
    if ( bal - 20 == 0 ) {

      this.emptyBal();
      
    }
    if ( bal - 20 < 0 ) {
         
        this.no$();
         
    }
    else {
         
        return "I have no idea how you got here"; 
         
    }


   return "";
   }



  //Getters
  public double getBal() {
    
   return bal; 
    
  }
  public String emptyBal() {

      return "Oh no! your bank is empty!";
    
  
 }
    public String no$() {
      
    return "you don't have the funds for that! try again"; 
      
    }
    public String myatm(double a){
      
      return "BURRR WIZZ your new balance is $"+ Double.toString(bal) + " You have removed $" + Double.toString(a); 
      
    }
    
}
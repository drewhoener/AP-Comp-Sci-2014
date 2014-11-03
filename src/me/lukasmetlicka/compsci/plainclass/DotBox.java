package me.lukasmetlicka.compsci.plainclass;

public class DotBox{

  public static void main(String[] args){
    
    for (int i = 1; i <= 5; i++){
      
      for (int j = 5; j >= 1; j--){
        
        
        if ( j > i ){
          
         System.out.print(" ."); 
          
        }
        else if ( j == i ){
          
         System.out.print(i); 
          
        }
        else if ( j < i ){
          
         System.out.print(" ."); 
          
        }
        
      }
      System.out.print("\n");
    }
    
  }
  
}


package me.lukasmetlicka.compsci.plainclass;

public class LCM{
  
  public static void main(String[] args){
    

    System.out.println(Integer.toString(findLCM(6,7)));
    
  }
  
  public static int findLCM( int a, int b){
    
   int bigger = findMax(a,b);
   int smaller = findMin(a,b);
   
   for ( int i = 1; i<= smaller; i++){
     
    int x = bigger * i;
    if ( x % smaller == 0 ){
     return x; 
    }
     
   }
   return 1;   
  }
  public static int findMax(int a, int b){
    
    if ( a > b ){
     return a; 
    }
    else {
     return b; 
    }
    
  }
  public static int findMin(int a, int b){
    
    if (a > b){
     return b; 
    }
    else {
     return a; 
    }
    
  }
  
}
  
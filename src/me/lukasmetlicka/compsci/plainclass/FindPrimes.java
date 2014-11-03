package me.lukasmetlicka.compsci.plainclass;

public class FindPrimes{
  
  public static void main(String[] argz){
    

   System.out.println(Integer.toString(power(3,8)));
  }
  
  public static boolean isPrime(int num){
    
    for(int i = 2;i < num; i++){
     
     if ( num % i == 0 ){
       
      return false; 
       
     }
    
   }
   return true;
    
  }
  
  public static void primes(int val){
    int primes = 0;
    for (int i = 1; i <= val; i++){
      
     boolean isPrime = isPrime(i);
     if (isPrime){
       System.out.println("Prime found: " + i);
       primes+= 1;
       
     }
     else {
       System.out.println("tried "+ i + " wasn't prime"); 
     }
      
    }
    System.out.println(primes + " Primes have been found");
      
    }
  
  public static int factorial(int a){
    
   int result = 1;
   for ( int i = 1; i <= a; i++ ){
     
    result = i * result;
    
     
   }
    return result;
  }
  public static int power(int a, int b){
    
   int result = 1;
   for(int i = 0; i < b; i++){
     
    result *= a; 
     
   }
   return result;
  }
  }
  

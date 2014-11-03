package me.lukasmetlicka.compsci.plainclass;

public class Graduation {
  
  public static String Status(int credits, int honors, double gpa){
    
    if ( (credits + honors) > 180 && gpa > 2.0 ){
      
      if ( gpa > 3.6 && gpa < 3.8 ){
        if ( honors < 15 ){
         return "cum laude"; 
        } else {
         return "magna cum laude"; 
        }
      }
      else if ( gpa >= 3.8 ){
        if ( honors < 15 ) {
         return "magna cum laude"; 
        } else {
         return "suma cum laude"; 
        }
      } else {
        return "graduating";
      }
      
    } else {
     return "not graduating"; 
    }
    
  }
  public static void main(String[] args){
   System.out.println(Status( 180, 34, 4.1));
    
    
  }
  
}


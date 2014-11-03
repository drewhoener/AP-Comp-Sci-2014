package me.lukasmetlicka.compsci.plainclass;

public class StringCopier{
  
  public static String copyString(String a, int b){
    String result = "";
    for (int i = 0; i < b; i++ ){
      result += a;
    }
    return result;
  }
  
  public static void main(String[] argz){


      System.out.println(copyString("Hello, World!  ", 3));
    
  }
  
}
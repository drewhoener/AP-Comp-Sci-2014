package me.lukasmetlicka.compsci.plainclass;

public class ITestPoints{
  
  public static void main(String[] args){
    
   Point p1 = new Point(3,1);
   Point p2 = new Point();
   Point p3 = new Point( 900, 6);
   
   System.out.println( p3.distFromOrigin() );
   System.out.println( "X: " + Double.toString(p3.getX()) + "\t Y: " + Double.toString(p3.getY()) );
   p3.setChords( 9, 4 );
   System.out.println( "X: " + Double.toString(p3.getX()) + "\t Y: " + Double.toString(p3.getY()) );
   p3.translateChords(5,5);
   System.out.println( "X: " + Double.toString(p3.getX()) + "\t Y: " + Double.toString(p3.getY()) );
    
  }
  
}
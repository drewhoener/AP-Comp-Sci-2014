package me.lukasmetlicka.compsci.plainclass;

import java.lang.Math;

public class Point {
 
  private double x;
  private double y;
  
  // Constructors
  public Point() {
    
   x = 0;
   y = 0;
    
  }
  public Point(double a) {
    
   x = 0;
   y = 0;
    
  }
  public Point(double a, double b) {
    
    x = a;
    y = b;
    
  }
  
  
  //Getters
  public double getX(){
    
     return x;
    
  }
  public double getY(){
    
     return y;
    
  }
  public double[] getChords() {
    
    double[] chords = {this.getX(), this.getY()};
    return chords;
    
  }
  public double distFromOrigin() {
    
    return Math.sqrt( Math.pow(x,2) + Math.pow(y,2) );
    
  }
  
  
  //Setters
  public void setX(double a) {
    
    x = a; 
    
  }
  public void setY(double a) {
    
    y = a; 
    
  }
  public void setChords(double a, double b) {
    
   x = a;
   y = b;
    
  }
  public void translateChords( double a, double b) {
    
    x += a;
    y += b;
    
  }
  
}
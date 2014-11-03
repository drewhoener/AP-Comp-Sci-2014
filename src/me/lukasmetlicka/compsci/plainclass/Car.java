package me.lukasmetlicka.compsci.plainclass;

import java.lang.Math;
public class Car {
  
 //Data
  private String model;
  private double position;
  private double totalDistance;
  private boolean isBroken;
  
  //constructors
  public Car(){
    
   model = "";
   position = 0;
   totalDistance = 0;
   isBroken = false;
    
  }
  public Car( String m ){
    
   model = m;
   position = 0;
   totalDistance = 0;
   isBroken = false;
    
  }
  public Car( String m, double p ){
    
   model = m;
   position = p;
   totalDistance = 0;
   isBroken = false;
    
  }
  public Car( String m, double p, double t ){
    
   model = m;
   position = p;
   totalDistance = t;
   isBroken = false;
    
  }
  public Car( String m, double p, double t, boolean b ){
    
   model = m;
   position = p;
   totalDistance = t;
   isBroken = b;
    
  }
  
  //basic setters
  public String setModel( String m ){
    
   model = m;
   return model;
    
  }
  public double setPosition( double p ){
    
   position = p;
   return position;
    
  }
  public double setTotalDistance( double d ){
    
   totalDistance = d;
   return totalDistance;
    
  }
  public boolean setIsBroken( boolean b ){
    
   isBroken = b;
   return isBroken;
    
  }
  
  //advanced setters
  public void set( String m, double p ){
    
   model = m;
   position = p;
   totalDistance = 0;
   isBroken = false;
    
  }
  public void set( String m, double p, double t ){
    
   model = m;
   position = p;
   totalDistance = t;
   isBroken = false;
    
  }
  public void set( String m, double p, double t, boolean b ){
    
   model = m;
   position = p;
   totalDistance = t;
   isBroken = b;
    
  }
  
  //basic getters
  public String getModel(){
    
   return model; 
    
  }
  public double getPosition(){
    
   return position; 
    
  }
  public double getTotalDistance(){
    
   return totalDistance; 
    
  }
  public boolean getIsBroken(){
    
   return isBroken; 
    
  }
 
  
  //Operators
  public void drive(double dist){
    
    if ( !isBroken ){
      
     position += dist;
     totalDistance += Math.abs(dist);
      
    }
    
  }
  
}
package me.lukasmetlicka.compsci.plainclass;

/**
 * Created by LukasMetlicka on 11/12/14.
 */
public class Lawyer extends Employee {
    public String toString(){
        return "Lawyer";
    }
    private int Value = 0;
    public void setval(int i){
        Value = i;
    }
    public int getValue(){
        return Value;
    }
}

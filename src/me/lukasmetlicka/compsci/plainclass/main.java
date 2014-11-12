package me.lukasmetlicka.compsci.plainclass;

/**
 * Created by LukasMetlicka on 11/12/14.
 */
public class main {
    public static void main(String[] args){

        Lawyer ed = new Lawyer();
        ed.setval(5);

        System.out.println( ed.toString());
        System.out.print(ed.getValue());

    }
}

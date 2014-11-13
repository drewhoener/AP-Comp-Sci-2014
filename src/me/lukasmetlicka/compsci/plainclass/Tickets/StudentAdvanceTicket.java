package me.lukasmetlicka.compsci.plainclass.Tickets;

/**
 * Created by LukasMetlicka on 11/12/14.
 */
public class StudentAdvance extends Ticket {

    public StudentAdvance(int d, int n){

        super(if (d > 10) return 15 if (d < 10) return 25, n);

    }

}


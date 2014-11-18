package me.lukasmetlicka.compsci.plainclass.Tickets;

/**
 * Created by LukasMetlicka on 11/12/14.
 */
public class StudentAdvanceTicket extends AdvanceTicket{

    public StudentAdvanceTicket(int d, int n){

        super(d >=10 ? 15 : 25, n);

    }

}


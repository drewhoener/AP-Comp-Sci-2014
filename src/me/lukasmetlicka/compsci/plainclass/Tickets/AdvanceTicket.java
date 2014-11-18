package me.lukasmetlicka.compsci.plainclass.Tickets;

/**
 * Created by LukasMetlicka on 11/12/14.
 */
public class AdvanceTicket extends Ticket {

    private int days;

    public AdvanceTicket(int d, int n){

        super(n,d >= 10 ? 30 : 40);


    }

}

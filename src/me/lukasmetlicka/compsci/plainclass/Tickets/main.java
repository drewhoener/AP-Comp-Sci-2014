package me.lukasmetlicka.compsci.plainclass.Tickets;

/**
 * Created by LukasMetlicka on 11/12/14.
 */
public class main {
    public static void main(String[] args){

        Ticket t1 = new Ticket(1,20);
        AdvanceTicket t2 = new AdvanceTicket(15,1);
        WalkupTicket t3 = new WalkupTicket(1);
        StudentAdvanceTicket t4 = new StudentAdvanceTicket(15,1);

        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());

    }
}

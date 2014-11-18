package me.drewhoener.compsci.plainclass.ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketTester {

	public static void main(String[] args) {

		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(new WalkupTicket(1));
		tickets.add(new WalkupTicket(2));
		tickets.add(new WalkupTicket(3));
		tickets.add(new WalkupTicket(4));
		tickets.add(new WalkupTicket(5));
		tickets.add(new AdvanceTicket(6, 2));
		tickets.add(new AdvanceTicket(7, 14));
		tickets.add(new AdvanceTicket(8, 5));
		tickets.add(new AdvanceTicket(9, 9));
		tickets.add(new AdvanceTicket(10, 3));
		tickets.add(new StudentAdvanceTicket(11, 8));
		tickets.add(new StudentAdvanceTicket(12, 5));
		tickets.add(new StudentAdvanceTicket(13, 6));
		tickets.add(new StudentAdvanceTicket(14, 12));
		tickets.add(new StudentAdvanceTicket(15, 14));

		for (Ticket t : tickets) {

			System.out.println(t.toString());

		}


	}
}

package me.drewhoener.compsci.plainclass.ticket;

public class StudentAdvanceTicket extends AdvanceTicket {


	public StudentAdvanceTicket(int num, int daysBefore) {
		super(num, daysBefore);
		super.setPrice(daysBefore >= 10 ? 15 : daysBefore > 0 && daysBefore < 10 ? 20 : 50);
	}

	public String toString() {

		return super.toString() + " (ID Required)";

	}

}

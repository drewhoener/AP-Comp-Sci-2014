package me.drewhoener.compsci.plainclass.ticket;

public class AdvanceTicket extends Ticket {

	private int daysBefore = 0;

	public AdvanceTicket(int num, int daysBefore) {
		super(num);
		this.daysBefore = daysBefore;
		super.setPrice(this.daysBefore >= 10 ? 30 : this.daysBefore > 0 && this.daysBefore < 10 ? 40 : 50);
	}

	public int getDaysBefore() {
		return daysBefore;
	}

}

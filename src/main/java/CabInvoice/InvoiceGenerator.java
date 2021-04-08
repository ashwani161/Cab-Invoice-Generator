package CabInvoice;

import java.util.ArrayList;

public class InvoiceGenerator {
	private static final double NORMAL_MINIMUN_COST_PER_KILOMETER =10;
	private static final int NORMAL_COST_PER_TIME = 1;
	private static final double NORMAL_MINIMUN_FARE = 5;
    private static final double PREMIUM_MINIMUN_COST_PER_KILOMETER =15;
	private static final int PREMIUM_COST_PER_TIME = 2;
	private static final double PREMIUM_MINIMUN_FARE = 20;

	public double calculateFare(double distance, int time) {
		double NormaltotalFare =  distance * NORMAL_MINIMUN_COST_PER_KILOMETER  + time * NORMAL_COST_PER_TIME ;
		if(NormaltotalFare < NORMAL_MINIMUN_FARE ) {
			return  NORMAL_MINIMUN_FARE;
		}
		return NormaltotalFare;
	}
	public double calculateFare1(double distance, int time) {
        double PremiumtotalFare =  distance * PREMIUM_MINIMUN_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME ;
		if(PremiumtotalFare < PREMIUM_MINIMUN_FARE ) {
			return  PREMIUM_MINIMUN_FARE;
		}
		return PremiumtotalFare;
	}
//public static void main(String[] args) {
//	System.out.println("Welcome to Cab Invoice Generator");
//}

	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double totalFare = 0;
		for (Ride ride:rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.size(), totalFare);
	}


}

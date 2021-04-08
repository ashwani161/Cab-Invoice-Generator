package CabInvoice;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator = null;
	@Before void setup() throws Exception {
		InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
	}
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.2;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        ArrayList<Ride> rides = new ArrayList<Ride>();
        		rides.add(new Ride(2.0, 5));
        		rides.add(new Ride(0.1, 1));
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary exceptedinvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(exceptedinvoiceSummary, summary);

     }
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary1() {
		RideRepository riderepo = new RideRepository();
		riderepo.addRidetoUser("User", new Ride(2.0, 5));
		riderepo.addRidetoUser("User", new Ride(0.1, 1));
        InvoiceSummary summary = invoiceGenerator.calculateFare(riderepo.getRides("User"));
        InvoiceSummary exceptedinvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(exceptedinvoiceSummary, summary);

     }
	
	@Test
	public void givenDistanceAndTime_ShouldReturnPremiumTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare1(distance, time);
		Assert.assertEquals(40, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_ShouldReturnpremiumMinFare() {
		double distance = 0.5;
		int time = 4;
		double fare = invoiceGenerator.calculateFare1(distance, time);
		Assert.assertEquals(20, fare, 0.0);
	}
}
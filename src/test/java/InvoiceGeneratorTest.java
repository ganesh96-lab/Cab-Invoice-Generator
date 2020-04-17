import cabinvoicegenerator.InvoiceGenerator;
import cabinvoicegenerator.InvoiceSummary;
import cabinvoicegenerator.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator=null;

    @Before
    public void setUp() throws Exception{
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void whenGivenDistanceAndTime_shouldReturnTotalFare() {
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance,time);
        System.out.println(fare);
        Assert.assertEquals(25,fare,0.0);
    }

/*    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(0.1,1)
        };
        double fare=invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,fare,0.0);
    }*/

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(0.1,1)
        };
        InvoiceSummary summary=invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}

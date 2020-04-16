import cabinvoicegenerator.InvoiceGenerator;
import cabinvoicegenerator.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

    @Test
    public void whenGivenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance,time);
        System.out.println(fare);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
        Ride[] rides={
                new Ride(2.0,5),
                new Ride(0.1,1)
        };
        double fare=invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,fare,0.0);
    }
}

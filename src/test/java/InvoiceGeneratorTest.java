import cabinvoicegenerator.InvoiceGenerator;
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
}

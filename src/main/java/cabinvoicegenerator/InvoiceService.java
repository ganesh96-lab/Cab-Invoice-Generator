package cabinvoicegenerator;

public class InvoiceService {
    private static final int COST_PER_MINUTE=1;
    private static final double MINIMUM_COST_PER_KILOMETER=10;
    private static final double MINIMUM_FARE=5;
    private RideRepository rideRepository;
    public InvoiceService() {
        this.rideRepository=new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance*MINIMUM_COST_PER_KILOMETER+time*COST_PER_MINUTE;
        return Math.max(totalFare,MINIMUM_FARE);
    }
    public InvoiceSummary calculateFare(Ride[] rides){
            double totaleFare=0;
            for (Ride ride:rides){
                totaleFare=totaleFare+this.calculateFare(ride.distance,ride.time);
            }
            return new InvoiceSummary(rides.length,totaleFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRide(userId));
    }
}

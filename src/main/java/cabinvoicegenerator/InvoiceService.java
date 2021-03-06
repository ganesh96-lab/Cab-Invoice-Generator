package cabinvoicegenerator;

public class InvoiceService {
    private static final int COST_PER_MINUTE=1;
    private static final double MINIMUM_COST_PER_KILOMETER=10;
    private static final double MINIMUM_FARE=5;
    private RideRepository rideRepository;

    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final double PREMIUM_MINIMUM_FARE = 20;
    //Constructor
    public InvoiceService() {
        this.rideRepository=new RideRepository();
    }

    public double calculateFare(double distance, int time,Ride.RideType rideType) {
        double totalFare=0;
        if (rideType==Ride.RideType.NORMAL) {
            totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
            return Math.max(totalFare, MINIMUM_FARE);
        }
        totalFare=distance*PREMIUM_MINIMUM_COST_PER_KILOMETER+time*PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare,PREMIUM_MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totaleFare=0;
        for (Ride ride:rides){
             totaleFare=totaleFare+this.calculateFare(ride.distance,ride.time,ride.rideType);
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

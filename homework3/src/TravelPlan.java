import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Trip trip=new Trip();

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    //in ce zi ce vizitez
    private Map<Attraction, LocalDate> travelPlan=new HashMap<>();
    private LocalDate date;

    public Map<Attraction, LocalDate> getTravelPlan() {
        return travelPlan;
    }

    @Override
    public String toString() {
        String travelInfo=new String();
        LocalDate date=trip.getStart();
        /*for (LocalDate i=trip.getStart();i.isBefore(trip.getEnd());i=i.plusDays(1))
            for (Attraction a: trip.getAttractions()){
           travelInfo+=( "On " +  i +  " we'll visit: " + a + "\n");
        }*/
        while (date.isBefore(trip.getEnd()))
        for (Attraction a: trip.getAttractions()){
            travelInfo+="On " + date + " we'll visit: " + a+ "\n";
            date= date.plusDays(1);
        }
         return travelInfo;
    }
    public void setTravelPlan(){
        for (Attraction a: trip.getAttractions()){
            travelPlan.put(a,date);
        }
    }
}

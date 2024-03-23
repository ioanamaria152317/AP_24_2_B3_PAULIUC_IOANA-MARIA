import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Museum museum = new Museum();
        museum.setName("museum");
        TimeInterval timeInterval=new TimeInterval(LocalTime.of(8,0),LocalTime.of(19,30));
        TimeInterval weekendInterval= new TimeInterval(LocalTime.of(10,0),LocalTime.of(15,0));
        Map<LocalDate, TimeInterval> timetable=new HashMap<>();
        for (int i=1;i<8;i++){
            LocalDate date=LocalDate.of(2024, 7, i);
            DayOfWeek day=date.getDayOfWeek();
            if (day== DayOfWeek.SATURDAY || day==DayOfWeek.SUNDAY){
                timetable.put(date, weekendInterval);
            }
            timetable.put(date, timeInterval);
        }
        museum.setTimetable(timetable);
        museum.setTicketPrice(20);
        Church church = new Church();
        church.setName("Frumoasa");
        TimeInterval churchInterval=new TimeInterval(LocalTime.of(7,30),LocalTime.of(12,30));
        Map<LocalDate, TimeInterval> churchTimetable=new HashMap<>();
        LocalDate churchDate=LocalDate.of(2024, 3,17);
        churchTimetable.put(churchDate,churchInterval);
        church.setTimetable(churchTimetable);

         Church church1=new Church(); //pelerinaj
        church1.setName("Voronet");
        TimeInterval voronetInterval=new TimeInterval(LocalTime.of(6,0),LocalTime.of(13,0));
        Map<LocalDate, TimeInterval> voronetTimetable=new HashMap<>();
        LocalDate voronetDate=LocalDate.of(2024,3,17);
        voronetTimetable.put(voronetDate,voronetInterval);
        church1.setTimetable(voronetTimetable);
        Church church2=new Church();
        church2.setName("Catedrala");

        Statue statue=new Statue();
        statue.setName("statue");
        Concert concert=new Concert();
        concert.setName("concert");
        Trip trip=new Trip();
        List<Attraction> attractions=new ArrayList<>();
        attractions.add(church);
        attractions.add(statue);
        attractions.add(museum);
        attractions.add(concert);
        attractions.add(church1);
        trip.setAttractions(attractions);
        Visitable[] arr = {museum, church, concert};
        System.out.println(trip.getAttractions());

        trip.setCity("Iasi");
        LocalDate dateTripStart=LocalDate.of(2024,5,14);
        trip.setStart(dateTripStart);
        LocalDate dateTripEnd=LocalDate.of(2024, 5,18);
        trip.setEnd(dateTripEnd);
        System.out.println(trip);
        TravelPlan travelPlan=new TravelPlan();
        travelPlan.setTrip(trip);
        travelPlan.setTravelPlan();
        System.out.println(travelPlan);

       // System.out.println(trip.freeVisitableLocations());

        OrderByDegreeColoring order=new OrderByDegreeColoring();
        Map<Attraction, Set<Attraction>> biserici=new HashMap<>();
        Set<Attraction> bisericiConectate=new HashSet<>();
        Set<Attraction> bisericiConectate2=new HashSet<>();
        bisericiConectate.add(church1);
        bisericiConectate.add(church2);
        bisericiConectate2.add(church2);
        biserici.put(church,bisericiConectate );
        biserici.put(church1,bisericiConectate2);
        biserici.put(church2,bisericiConectate);
        order.setListaAdiacenta(biserici);
        List<Attraction> sortedAtrr=new ArrayList<>(biserici.keySet());
        order.setSortedAttractions(sortedAtrr);
        order.orderAttractions();
        System.out.println(order.getSortedAttractions());
        System.out.println(biserici);
    }
}
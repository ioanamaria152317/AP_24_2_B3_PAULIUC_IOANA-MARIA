import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Museum museum = new Museum();
        TimeInterval<LocalTime, LocalTime> timeInterval=new TimeInterval<>(LocalTime.of(8,0),LocalTime.of(19,30));
        Map<LocalDate, TimeInterval> timetable=new HashMap<>();
        for (int i=1;i<8;i++){
            LocalDate date=LocalDate.of(2024, 7, i);
            timetable.put(date, timeInterval);
        }
        museum.setTimetable(timetable);
        museum.setTicketPrice(20);
        Church church = new Church();
        TimeInterval<LocalTime, LocalTime> churchInterval=new TimeInterval<>(LocalTime.of(7,30),LocalTime.of(12,30));
        Map<LocalDate, TimeInterval> churchTimetable=new HashMap<>();
        LocalDate churchDate=LocalDate.of(2024, 3,17);
        churchTimetable.put(churchDate,churchInterval);
        church.setTimetable(churchTimetable);

        Statue statue=new Statue();

        Concert concert=new Concert();
        Trip trip=new Trip();
        List<Attraction> attractions=new ArrayList<>();
        attractions.add(church);
        attractions.add(statue);
        attractions.add(museum);
        attractions.add(concert);
        trip.setAttractions(attractions);
        Visitable[] arr = {museum, church, statue, concert};
    }
}
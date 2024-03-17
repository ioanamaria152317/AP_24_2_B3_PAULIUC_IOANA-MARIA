import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;

public interface Visitable {
   // LocalTime openingHour=null;  //dc niciun modif de acces nu merge?
    //totul este implicit public ; totul e final; constante
    Map<LocalDate, TimeInterval> getTimetable();  //IN CE zi viz si in ce interval
    default LocalTime getOpeningHour(LocalDate date) {
        TimeInterval timeInterval = getTimetable().get(date);
        return timeInterval.getOpeningTime();
    }
}

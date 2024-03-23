import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();  //IN CE zi viz si in ce interval
    default LocalTime getOpeningHour(LocalDate date) {
        TimeInterval timeInterval = getTimetable().get(date);
        return timeInterval.getOpeningTime();
    }
}

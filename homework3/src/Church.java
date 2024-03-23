import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Church extends Attraction implements Visitable{

    private Map<LocalDate, TimeInterval> timetable;
    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.timetable;
    }
    public void setTimetable(Map<LocalDate, TimeInterval> timetable){
        this.timetable=timetable;
    }

    /*public LocalTime getOpeningHour(LocalDate date) {
        return Visitable.super.getOpeningHour(date);
    }*/
}

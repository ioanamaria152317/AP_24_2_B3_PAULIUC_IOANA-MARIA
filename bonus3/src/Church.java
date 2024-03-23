import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Church extends Attraction implements Visitable{

    private Map<DayOfWeek, TimeInterval> timetable;
    @Override
    public Map<DayOfWeek, TimeInterval> getTimetable() {
        return this.timetable;
    }
    public void setTimetable(Map<DayOfWeek, TimeInterval> timetable){
        this.timetable=timetable;
    }

    /*public LocalTime getOpeningHour(LocalDate date) {
        return Visitable.super.getOpeningHour(date);
    }*/
}

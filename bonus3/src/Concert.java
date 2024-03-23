import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class Concert extends Attraction implements Payable, Visitable{

    private Map<DayOfWeek, TimeInterval> timetable;
    private double ticketPrice;
    @Override
    public Map<DayOfWeek,TimeInterval> getTimetable() {
        return timetable;
    }
    public void setTimetable(Map<DayOfWeek, TimeInterval> timetable) {
        this.timetable = timetable;
    }
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticket){
        this.ticketPrice=ticket;
    }
}

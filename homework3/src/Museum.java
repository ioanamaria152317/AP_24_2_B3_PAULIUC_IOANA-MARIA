import java.time.LocalDate;
import java.util.Map;

public class Museum extends Attraction implements Visitable, Payable{
    private double ticketPrice;
    private Map<LocalDate, TimeInterval> timetable;
    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }
    public void setTicketPrice(double price){
        this.ticketPrice=price;
    }
    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.timetable;
    }
    public void setTimetable(Map <LocalDate, TimeInterval> timetable){
        this.timetable=timetable;
    }
}

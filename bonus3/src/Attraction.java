import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public abstract class Attraction{
     private DayOfWeek day;
     public DayOfWeek setDay(){
         if (this instanceof Visitable)
             day = ((Visitable) this).getTimetable().keySet().stream().findAny().orElse(null);
         return day;
         //stream un fel de iterator peste keySet??????//
     }
    private String name;

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public int compareTo(Attraction other) {
        if (this instanceof Visitable && other instanceof Visitable)
            return ((Visitable) this).getOpeningHour(setDay()).compareTo(((Visitable) other).getOpeningHour(setDate()));
        else
            return Integer.MIN_VALUE; //"attraction is not visitable!";
    }*/
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public abstract class Attraction implements Comparable<Attraction>{
     private LocalDate date;
     public LocalDate setDate(){
         if (this instanceof Visitable)
             date = ((Visitable) this).getTimetable().keySet().stream().findAny().orElse(null);
         return date;
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

    public int compareTo(Attraction other) {
        if (this instanceof Visitable && other instanceof Visitable)
            return ((Visitable) this).getOpeningHour(setDate()).compareTo(((Visitable) other).getOpeningHour(setDate()));
        else
            return Integer.MIN_VALUE; //"attraction is not visitable!";
    }
}

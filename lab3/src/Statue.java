import java.time.LocalDate;
import java.util.Map;

public class Statue extends Attraction implements Visitable {
      private Map<LocalDate,TimeInterval> fictiveTimetable;
    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.fictiveTimetable;
    }
}

import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime>{
   // private LocalTime openingTime;
  //  private LocalTime closingTime;
    public TimeInterval(LocalTime openingTime, LocalTime closingTime) {
        super(openingTime,closingTime);
    }
    public LocalTime getOpeningTime() {
        return super.first;
    }
    public LocalTime getClosingTime() {
        return super.second;
    }
    public TimeInterval(){};
}

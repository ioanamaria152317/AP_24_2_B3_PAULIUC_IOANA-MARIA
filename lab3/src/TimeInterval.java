import java.time.LocalTime;

class TimeInterval<S, F> extends Pair {
    private LocalTime openingTime;
    private LocalTime closingTime;


    public TimeInterval(LocalTime openingTime, LocalTime closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }
    public TimeInterval(){};
}


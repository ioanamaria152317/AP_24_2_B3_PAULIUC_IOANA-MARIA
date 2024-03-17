import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trip {

    private String city;
    private LocalDate start, end;
    private List<Attraction> attractions = new ArrayList<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", attractions=" + attractions +
                '}';
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}

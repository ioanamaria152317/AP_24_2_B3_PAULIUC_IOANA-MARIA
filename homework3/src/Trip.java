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

    public List<Attraction> freeVisitableLocations (){
        List<Attraction> freeLocations=new ArrayList<>();
        for (Attraction a : getAttractions()){
            if (a instanceof Church )
                freeLocations.add(a);
        }
        //freeLocations.sort(Attraction::compareTo);
        freeLocations.sort((a1,a2)-> a1.compareTo(a2));
        return freeLocations;  //tb sort by opening hour
    }
}

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class OrderByDegreeColoring extends Trip{
    //lista adiacenta
    //fiecare nod e o atractie, fiecare cul ei (zilele in care poate fi viz)
    private Map<Attraction, Set<Attraction>> listaAdiacenta=new HashMap<>();
    //cica la set nu pot avea duplicate
    private Map<Attraction, List<DayOfWeek>> possibleDates=new HashMap<>();
    //date in care poate fi viz
    private Map<Attraction, DayOfWeek> daysOfTrip=new HashMap<>();
    private  List<Attraction> sortedAttractions = new ArrayList<>();

    public List<Attraction> getSortedAttractions() {
        return sortedAttractions;
    }

    public void setSortedAttractions(List<Attraction> sortedAttractions) {
        this.sortedAttractions = sortedAttractions;
    }

    public Map<Attraction, Set<Attraction>> getListaAdiacenta() {
        return listaAdiacenta;
    }

    public Map<Attraction, List<DayOfWeek>> getPossibleDates() {
        //tb sa ma uit in timetable pt fiecare attraction
        for(Attraction a: this.getAttractions()){
            if (a instanceof Visitable){
                if (((Visitable) a).getTimetable().containsKey(this.getStart()) && ((Visitable) a).getTimetable().keySet().stream().allMatch(this::isBefore)) {
                       possibleDates.put(a,((Visitable) a).getTimetable().keySet().stream().toList());
                }
            }
        }
        return possibleDates;
    }

    public Map<Attraction, DayOfWeek> getDaysOfTrip() {
        return daysOfTrip;
    }

    public void setDaysOfTrip(Map<Attraction, DayOfWeek> daysOfTrip) {
        this.daysOfTrip = daysOfTrip;
    }

    public void setPossibleDates(Map<Attraction, List<DayOfWeek>> possibleDates) {
        this.possibleDates = possibleDates;
    }

    public void setListaAdiacenta(Map<Attraction, Set<Attraction>> listaAdiacenta) {
        this.listaAdiacenta = listaAdiacenta;
    }

    //culorile grafului
    OrderByDegreeColoring(){};
    OrderByDegreeColoring(Map<Attraction, Set<Attraction>> listaAdiacenta, Map<Attraction,List<DayOfWeek>> possibleDates, Map<Attraction,DayOfWeek> daysOfTrip){
        this.listaAdiacenta=listaAdiacenta;
        this.possibleDates=possibleDates;
        this.daysOfTrip=daysOfTrip;
    }
    public List<Attraction> orderAttractions() {
        //vreau sa sortez atractiile dupa gradul lor

        this.sortedAttractions.sort((a, b) -> Integer.compare(this.listaAdiacenta.get(b).size() ,listaAdiacenta.get(a).size()));
        return this.sortedAttractions;
        //MERGEEEEEEEEEEEEE
    }
    public void Color(){
        for (Attraction a: this.getSortedAttractions()){
            Set<Attraction> vecini=new HashSet<>(listaAdiacenta.get(a));

            //colorez primul nod
            daysOfTrip.put(a, getPossibleDates().get(a).getFirst());
            for (Attraction vecin: vecini){
                //vreau o data care sa fie intre start trip si end trip -ok
                // atractia sa fie open -toate sunt asa vr eu momentan

                //vreau sa colorez urm atractie din array ul de atractii sortate
                if (possibleDates.containsKey(vecin)){

                }
            }
        }
    }
}
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Depot {
    private String name;
    private List<Vehicle> vehicles=new ArrayList<Vehicle>();
    private int numberOfVehicles;
    public Depot(){};
    private LocalTime currentTime=LocalTime.now();

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public Depot(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfVehicles(){return numberOfVehicles;}
    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles=vehicles;
        for(Vehicle v: vehicles){
            numberOfVehicles++;
            v.setDepot(this);
        } //mostenire; ca daca eu as avea camion si masina derivate din vehicle, nu ar sti ce element sa puna
        //deci daca nu exista mostenire pe planeta ar fi mers
    }
    public List <Vehicle> getVehicles() {
        return vehicles;
    }
    public String toString()
    {
        return name;
    }
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) obj;
        return name.equals(other.name);
    }
}

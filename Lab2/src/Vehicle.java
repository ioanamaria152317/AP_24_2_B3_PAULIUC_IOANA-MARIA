import java.util.Arrays;

public class Vehicle {
    private String name;

    private Depot depot;
    public Vehicle(String name) {
        this.name = name;
    }
    public Vehicle(){};
    public Depot getDepot() {
        return depot;
    }
    public void setDepot(Depot depot) {
        this.depot = depot;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Vehicle)){
            return false;
        }
        Vehicle other=(Vehicle) obj;
        return name.equals(other.name);
    }
}

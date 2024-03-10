import java.util.Arrays;

public class Depot {
    private String name;
    private Vehicle[] vehicles;
    public Depot(){};
    public Depot(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setVehicles(Vehicle ... vehicles){
        this.vehicles=vehicles;
        for(Vehicle v: vehicles){
            v.setDepot(this);
        } //mostenire; ca daca eu as avea camion si masina derivate din vehicle, nu ar sti ce element sa puna
        //deci daca nu exista mostenire pe planeta ar fi mers
    }
    public Vehicle[] getVehicles() {
        return vehicles;
    }
    public String toString()
    {
        return name;
    }
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Depot)){
            return false;
        }
        Depot other=(Depot) obj;
        return name.equals(other.name);
    }
}

package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MersLaOcazie {

    private List<Vehicle> vehicles;  //fiecare ar putea sa mearga cu propria masina, dar
    //nu vrem asta

    private Map<Destination, List<Person>> destinationMap = new HashMap<>();
    private List<Person> people = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Destination> destinations() {
        return vehicles.stream()
                .flatMap(vehicle -> {
                            //aplica functia pe care i-o dau si
                            //ret altceva
                            //flatMap ma lasa sa fac asta si map nu???/!!!!!!!
                            List<Destination> dest = vehicle.getDriver().getDestinationsBefore();
                            dest.add(vehicle.getDriver().getDestination());  //merge doar pe randuri dif??????/
                            return dest.stream();
                        }
                )
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<Destination, List<Person>> destinationMap() {
        //am deja lista de dest, vreau sa vad person ce dest are
        // List<Person> oameniLaOcazie=new ArrayList<>();
        for (Destination dest : destinations()) {
            /*for (Person p: people){
                if (p.getDestination().equals(dest)){
                   oameniLaOcazie.add(p);
                }*/
            List<Person> oameniLaOcazie = people.stream()    //am inceput sa gandesc stream uri!!!!!
                    .filter(person -> person.getDestination().equals(dest))
                    .collect(Collectors.toList());

            destinationMap.put(dest, oameniLaOcazie);
        }
        return destinationMap;
    }

    public void greedyMatch() {
        //PRACTIC VREAU UN PASAGER CU ACEEASI DEST CA DRIVER UL IN AC MASINA
        for (Person p : people)
            for (Vehicle v : vehicles) {
                if (v.getDriver().hasCommonDestination(p.getDestination()) && p instanceof Passenger) {
                    v.addPassenger((Passenger) p);
                }
                //ii setez eu driver in main
            }
    }

    public void printMap(Map<Destination, List<Person>> map) {
        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey().getName() + "-" +
                        entry.getValue().toString()));
    }

}


//"put If DEFAULT
//val asociata cheii sau val default daca n am nimic acolo
//teoretic daca am ceva acolo imi da pasagerii, daca nu imi da un array gol?


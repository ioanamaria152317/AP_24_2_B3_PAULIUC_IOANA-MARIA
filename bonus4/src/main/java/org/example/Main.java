package org.example;

import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        MersLaOcazie mersLaOcazie = new MersLaOcazie();

        String driverName1 = faker.name().fullName();
        String driverName2 = faker.name().fullName();
        String driverName3 = faker.name().fullName();
        String driverName4 = faker.name().fullName();

        String passName1 = faker.name().fullName();
        String passName2 = faker.name().fullName();
        String passName3 = faker.name().fullName();
        String passName4 = faker.name().fullName();

        String destName1 = faker.address().city();
        String destName2 = faker.address().city();
        String destName3 = faker.address().city();
        String destName4 = faker.address().city();

        String destPass1 = faker.address().city();
        String destPass2 = faker.address().city();
        String destPass3 = faker.address().city();
        String destPass4 = faker.address().city();

        Destination dest1 = new Destination(destName1);  //pt driver
        Destination dest2 = new Destination(destName2);
        Destination dest3 = new Destination(destName3);
        Destination dest4 = new Destination(destName4);

        Passenger passenger1 = new Passenger(passName1, dest1);
        Passenger passenger2 = new Passenger(passName2, dest2);
        Passenger passenger3 = new Passenger(passName3, dest3);
        Passenger passenger4 = new Passenger(passName4, dest4);

        List<Person> people = new ArrayList<>();
        people.add(passenger1);
        people.add(passenger2);
        people.add(passenger3);
        people.add(passenger4);

        Destination destPassObject1 = new Destination(destPass1);
        Destination destPassObject2 = new Destination(destPass2);
        Destination destPassObject3 = new Destination(destPass3);
        Destination destPassObject4 = new Destination(destPass4);

        String destBefore1 = faker.address().city();
        String destBefore2 = faker.address().city();
        String destBefore3 = faker.address().city();

        Destination destBeforeObject1 = new Destination(destBefore1);
        Destination destBeforeObject2 = new Destination(destBefore2);
        Destination destBeforeObject3 = new Destination(destBefore3);

        List<Destination> destinationsBefore = new ArrayList<>();
        destinationsBefore.add(destBeforeObject1);
        destinationsBefore.add(destBeforeObject2);
        destinationsBefore.add(destBeforeObject3);

        Driver driver1 = new Driver(driverName1, dest1);
        Driver driver2 = new Driver(driverName2, dest2);
        Driver driver3 = new Driver(driverName3, dest3);
        Driver driver4 = new Driver(driverName4, dest4);
        //prob ca am scris cod mult si prost in loc de var ceva

        people.add(driver1);
        people.add(driver2);
        people.add(driver3);
        people.add(driver4);

        mersLaOcazie.setPeople(people);

        driver1.setDestinationsBefore(destinationsBefore);
        driver2.setDestinationsBefore(destinationsBefore);
        driver3.setDestinationsBefore(destinationsBefore);
        driver4.setDestinationsBefore(destinationsBefore);

        Vehicle vehicle1 = new Vehicle(driver1);
        Vehicle vehicle2 = new Vehicle(driver2);
        Vehicle vehicle3 = new Vehicle(driver3);
        Vehicle vehicle4 = new Vehicle(driver4);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);

        mersLaOcazie.setVehicles(vehicles);

        //Map<Destination,List<Person>> destMap=new HashMap<>();
        mersLaOcazie.destinations();
        mersLaOcazie.destinationMap();
        mersLaOcazie.printMap(mersLaOcazie.destinationMap());
        mersLaOcazie.greedyMatch();

        for (Vehicle v: vehicles){
            System.out.println(" Driver: " + v.getDriver().getName() + " Destination: "
                    + v.getDriver().getDestination() + " Pasager: " + v.getPassengers());
        }

        //vreau un graf care sa aiba ca noduri driveri si pasageri, iar muchiile sa fie
        //conexiuni intre ei   =>>>>> nu am nev de destinatie, destinatia e muchia
        //unesc acei driveri si acei pasageri care au dest comuna =>>>>>>>> in teorie

        Graph<Integer, DefaultEdge> bipartiteGraph = new SimpleGraph<>(DefaultEdge.class);
        Random random=new Random();
        Set<Integer> set1= new HashSet<>();       //fac cele doua partitii pt graful bipartit
        Set<Integer> set2= new HashSet<>();
        for(int i=0;i<4;i++)
        {
            bipartiteGraph.addVertex(i);
            set1.add(i);
        }
        for(int i=4; i<8;i++)
        {
            bipartiteGraph.addVertex(i);
            set2.add(i);
        }
        int count2=0;
        for(int i=0;i<8;i++) {
            if (random.nextInt(4) <= 1) {
                count2++;
                int source = random.nextInt(4);
                int destination = random.nextInt(4) + 4;
                boolean hasEdge = bipartiteGraph.containsEdge(source, destination);
                if (!hasEdge) {
                    bipartiteGraph.addEdge(source, destination);
                }
            }
        }

        System.out.println(bipartiteGraph.edgeSet());

        MatchingAlgorithm<Integer, DefaultEdge> matchingAlgorithm;
        matchingAlgorithm = new HopcroftKarpMaximumCardinalityBipartiteMatching<>(bipartiteGraph,set1,set2);
        MatchingAlgorithm.Matching<Integer, DefaultEdge> matching = matchingAlgorithm.getMatching();

        Set<DefaultEdge> matchingEdges = matching.getEdges();

        //iau doar muchiile care nu s in cuplaj
        Set<Integer> independentSet = new HashSet<>(bipartiteGraph.vertexSet());
        for (DefaultEdge edge : matchingEdges) {

            Integer source = bipartiteGraph.getEdgeSource(edge);
            Integer target = bipartiteGraph.getEdgeTarget(edge);

            independentSet.remove(source);
            independentSet.remove(target);
        }

        System.out.println("Set independent: " + independentSet);


       // System.out.println("Comparatie: Greedy -->"+count1+"    Graph -->"+count2);
        System.out.println(count2);
    }
}


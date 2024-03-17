import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();

        Depot depot1 = new Depot("Metro");
        Depot depot2 = new Depot("Egros");
        pb.setDepots(depot1, depot2);

        List<Vehicle> vehicles1= new ArrayList<Vehicle>();
        Vehicle vehicle1=new Truck("Seat");
        Truck vehicle2=new Truck("BMW");
        vehicles1.add(vehicle1);
        vehicles1.add(vehicle2);
        depot1.setVehicles(vehicles1);

        List<Vehicle> vehicles2=new ArrayList<Vehicle>();
        Vehicle vehicle3 = new Drone();
        vehicle3.setName("Mercedes");
        Vehicle vehicle4 = new Truck();
        vehicle4.setName("Opel");
        vehicles2.add(vehicle3);
        vehicles2.add(vehicle4);
        depot2.setVehicles(vehicles2);

        List<Client> clients=new ArrayList<Client>();
        Client client1=new Client("Client1", LocalTime.of(12,30), LocalTime.of(14,0));
       //System.out.println(depot1.getCurrentTime());
        //System.out.println(client1.getVisitingTimeInterval());
        Client client2=new Client("Client2", LocalTime.of(13,0),LocalTime.of(19,40));
        Client client3=new Client("Client3", LocalTime.of(10,28), LocalTime.of(16,0));
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        pb.setClients(clients);
        System.out.println(pb);
        //Duration durata=Duration.between(LocalTime.of(12,30),LocalTime.of(14,0));
        System.out.println(pb.getRandomInterval());
        System.out.println(pb.getRandomInterval());
        System.out.println(pb.getRandomInterval());

        Solution solutie=new Solution();
        List<Tour> listaDrumuri=new ArrayList<Tour>();

        Tour firstRoute=new Tour();
        firstRoute.setVehicle(vehicle1);
        firstRoute.setClients(clients);
        listaDrumuri.add(firstRoute);

        Tour secondRoute=new Tour();
        firstRoute.setVehicle(vehicle3);
        firstRoute.setClients(clients);
        listaDrumuri.add(secondRoute);

        solutie.setDrum(listaDrumuri);
        System.out.println(solutie);
    }
}

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.temporal.ChronoUnit;

import static java.lang.Math.random;

public class Problem {
    private Depot[] depots;

    public StringBuilder getDepots() {
        StringBuilder cv = new StringBuilder();
        for (Depot d : depots) {
            cv.append(d.getName() + " ");
        }
        return cv;
    }

    private int numberOfAllVehicles;
    private List<Vehicle> allVehicles=new ArrayList<Vehicle>();

    public void setDepots(Depot... depots) {
        this.depots = depots;
    }

    private List<Client> clients=new ArrayList<Client>();

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List< Vehicle> getVehicles() {
        //all the vehicles
         for (Depot d:depots){
             for (Vehicle v: d.getVehicles())
                 allVehicles.add(v);
         }
         return allVehicles;
    }

    public String toString() {
            return getVehicles().toString();
    }
    private Duration randomInterval;
    public Duration getRandomInterval(){
        Random random=new Random();
        //daca vreau un interval random pt cazul depot-client
        //cat fac de la depot pana la un client oarecare
        //tb sa am in vedere visiting time interval
        List<LocalTime> depotTimes=new ArrayList<LocalTime>();
        for (Depot d: depots) {
            depotTimes.add(d.getCurrentTime());
        }
        int randomIndex1=random.nextInt(depotTimes.size());
        LocalTime randomDepotTime=depotTimes.get(randomIndex1);
        List<Duration> clientTimes=new ArrayList<Duration>();
        for (Client c:clients){
            clientTimes.add(c.getVisitingTimeInterval());
        }
       // int randomIndex2=random.nextInt(clientTimes.size());
       // LocalTime randomClientTime=clientTimes.get(randomIndex2);  //un min random
       // LocalTime maxTime=clients.get(randomIndex2).getMaxTime();   //max ul lui coresp

        int index = random.nextInt(clientTimes.size());  //limita
        Duration clientRandomInterval = clientTimes.get(index);
        //vreau o ora random in intervalul asta random generat
        LocalTime minTime=clients.get(index).getMinTime();
        LocalTime maxTime=clients.get(index).getMaxTime();
        LocalTime randomClientTime;
        do {
            int hour = random.nextInt(maxTime.getHour());
            int minute = random.nextInt(maxTime.getMinute()+1);
            //bound aici o sa fie zero pt ca am 14:00
            randomClientTime = LocalTime.of(hour,minute);
        } while (maxTime.isBefore(minTime));

        Duration randomInterval=Duration.between(randomDepotTime,randomClientTime);
        return randomInterval;  //e f bun
        //mai tb sa fac pt cazul client-to-client
    }
}

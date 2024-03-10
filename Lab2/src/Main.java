import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

             Client client1=new Client();
             client1.setName("Ioana");
             client1.setMinTime(LocalTime.of(8,0));
             client1.setMaxTime(LocalTime.of(12,30));
             System.out.println(client1.getName());

             Client client2=new Client("Nadia");
             System.out.println(client2);

             Client client3= new Client("Alex",LocalTime.NOON,LocalTime.MIDNIGHT);

             Client client4=new Client("Matei",ClientType.PREMIUM);
             System.out.println(client4);

             Depot depot1=new Depot("Depot 1");
             Vehicle vehicle1=new Vehicle();
             vehicle1.setName("Seat Ibiza");
             Vehicle vehicle2=new Vehicle();
             depot1.setVehicles(vehicle1,vehicle2);
             Depot depot2=new Depot("Depot 2");
             Vehicle vehicle3=new Vehicle();
             depot2.setVehicles(vehicle3);

        System.out.println(depot1);
        System.out.println(vehicle1);

        /*short a[]=new short[10];
        a[0]=10;
        a[1]=2;
        for( int i=0;i<10;i++){
            System.out.println(a[i]);
        }*/
    }
}
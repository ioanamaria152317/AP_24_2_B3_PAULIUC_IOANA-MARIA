import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tour {
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private List<Client> clients=new ArrayList<Client>();

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    //aici fac alocarea clientilor cred eu
    //plec de la depot, merg la niste clienti, ma intorc la depot
    //2 pt depot
    //1 pt vehicle
    //0 pt client
  private final int depot=2;
  private final int vehiclee=1;
  private final int client=3;
    private int[][] matrix=new int[100][100];
    public List<Client> allocateClients(){
        Random random=new Random();
        matrix[0][0]=depot;
        List<Client> visitedClients=new ArrayList<>();
        for (Client c:clients){
            int randomLinie = random.nextInt(100);
            int randomCol = random.nextInt(100);
            if (matrix[randomLinie][randomCol] != client) {           //sa nu fie viz deja
                // randomLinie = random.nextInt(100);
                // randomCol = random.nextInt(100);
                matrix[randomLinie][randomCol] = client; //vizitez
                visitedClients.add(c);
            }

        }
        return visitedClients;
    }

    public String toString() {
        return "Vehicle " + this.vehicle + " has clients: " + allocateClients().toString();
    }
}

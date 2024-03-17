import java.time.Duration;
import java.time.LocalTime;

public class Client {
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;
    private Duration visitingTimeInterval;
    public Duration getVisitingTimeInterval(){
        return Duration.between(minTime,maxTime);
    }
    public Client(String name,ClientType type){
        this.name=name;
        this.type=type;
    }
    public Client() {}
    public Client(String name){
        this.name=name;
    }
    public Client(String name, LocalTime minTime, LocalTime maxTime){
        this.name=name;
        this.minTime=minTime;
        this.maxTime=maxTime;
        this.visitingTimeInterval=getVisitingTimeInterval();
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

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Client)){
            return false;
        }
        Client other=(Client) obj;
        return name.equals(other.name);
    }
}

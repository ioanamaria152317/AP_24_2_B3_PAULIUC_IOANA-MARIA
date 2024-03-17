import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Tour> drum=new ArrayList<Tour>();

    public List<Tour> getDrum() {
        return drum;
    }

    public void setDrum(List<Tour> drum) {
        this.drum = drum;
    }
//greedy: la fiecare pas aleg ce pare mai bun pt moment
    //de ex iau cel mai apropiat client, adica cel pana la care fac cel mai putin timp
    //tot fac alegeri pana i am vizitat pe toti
    public String toString(){
        return drum.toString();
    }

}

public class Pair <T, U> {
    protected T first;

   /* public T getFirst() {
        return first;
    }*/

    protected U second;

   /* public U getSecond() {
        return second;
    }*/

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public Pair(){};

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

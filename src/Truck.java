public class Truck implements Runnable {

    static Object monitor = new Object();
    int nRaces;
    int capacity;
    Elevator elevator1;
    Elevator elevator2;

    public Truck(int nRaces, int capacity, Elevator elevator1, Elevator elevator2) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator1 = elevator1;
        this.elevator2 = elevator2;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            synchronized (monitor) {
                elevator1.add(capacity / 2);
            }
            synchronized (monitor) {
                elevator2.add(capacity / 2);
            }
        }
    }
}

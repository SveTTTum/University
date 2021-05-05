import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParkingMain {
    public static void main(String[] args) throws InterruptedException {
        int permits = 4;
        Semaphore semaphore = new Semaphore(permits); //парковочные места
        Car car[] = new Car[10];

        for(int i = 1; i <= car.length; i++) {
            new Car(semaphore, i).start();
        }
    }
}

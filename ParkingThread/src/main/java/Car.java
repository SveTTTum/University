import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private final int id;
    private final Semaphore semaphore;

    public Car(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car " + id + " waiting for a free parking space");
            if (semaphore.tryAcquire(10, TimeUnit.SECONDS)) {
                System.out.println("Car " + id + " pulls into a parking space");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Car " + id + "frees up parking space");
                semaphore.release();
            } else {
                System.out.println("Car " + id + " left for another parking lot. No parking place");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

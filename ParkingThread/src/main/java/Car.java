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
            if (semaphore.availablePermits() == 0) {
                System.out.println("Car " + id + " waiting for a free parking space");
                TimeUnit.SECONDS.sleep(20);
                System.out.println("Car " + id + " left for another parking lot");
            } else {
                semaphore.acquire();
                System.out.println("Car " + id + " pulls into a parking space");
                TimeUnit.SECONDS.sleep(30);
                System.out.println("Car " + id + " frees up parking space");
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

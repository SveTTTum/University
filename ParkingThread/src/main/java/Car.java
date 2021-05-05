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
                System.out.println("Машина " + id + " ожидает свободное место на парковке");
                TimeUnit.SECONDS.sleep(20);
                System.out.println("Машина " + id + " уехала на другую парковку");
            } else {
                semaphore.acquire();
                System.out.println("Машина " + id + " заезжает на машиноместо");
                TimeUnit.SECONDS.sleep(30);
                System.out.println("Машина " + id + " освобождает машиноместо");
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

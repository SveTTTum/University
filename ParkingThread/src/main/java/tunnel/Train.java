package tunnel;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Train extends Thread {
    private final String trainName;
    private final int id;
    private final Semaphore semaphore;

    public Train(int id, String trainName, Semaphore semaphore) {
        this.id = id;
        this.trainName = trainName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Поезд " + id + " " + this.trainName + " зашел в тоннель");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Поезд " + id + " " + this.trainName + " вышел из тоннеля");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

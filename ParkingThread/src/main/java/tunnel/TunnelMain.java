package tunnel;

import java.util.concurrent.Semaphore;

public class TunnelMain {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2,true);
        for (int i = 0; i < 10; i++) {
            Train routeMinskMoscow = new Train(i,"Minsk-Moscow", semaphore);
            routeMinskMoscow.start();
        }
        for (int j = 0; j < 10; j++) {
            Train routeMoscowMinsk = new Train(j, "Moscow-Minsk", semaphore);
            routeMoscowMinsk.start();
        }
    }
}

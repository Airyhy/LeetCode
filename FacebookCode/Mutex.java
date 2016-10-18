import java.util.concurrent.Semaphore;

/**
 * Created by Christina on 2/24/16.
 */
public class Mutex {
    static Semaphore lock = new Semaphore(1);
}
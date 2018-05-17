import java.util.UUID;

/**
 * Created by andyx on 17/5/18.
 */
public class InsertDataThread extends Thread{
    private boolean keepRunning = true;
    private final SharedResource dictionary;

    public InsertDataThread(SharedResource dictionary, String threadName) {
        this.dictionary = dictionary;
        this.setName(threadName);
    }

    @Override
    public void run() {
        while (keepRunning){
            dictionary.set("KEY" + dictionary.getKeys().length, getNewRandomValue());
            //Update every 5 seconds
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWriter() {
        this.keepRunning = false;
        this.interrupt();
    }

    private String getNewRandomValue() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}

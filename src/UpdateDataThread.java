import java.util.UUID;

/**
 * Created by andyx on 17/5/18.
 */
public class UpdateDataThread extends Thread{
    private boolean keepRunning = true;
    private final SharedResource dictionary;

    public UpdateDataThread(SharedResource dictionary, String threadName) {
        this.dictionary = dictionary;
        this.setName(threadName);
    }

    @Override
    public void run() {
        while (keepRunning){
            String[] keys = dictionary.getKeys();
            for(String key : keys) {
                String newValue = getNewRandomValue();
                dictionary.set(key,newValue);
            }
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

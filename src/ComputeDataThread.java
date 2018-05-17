/**
 * Created by andyx on 17/5/18.
 */
public class ComputeDataThread extends Thread{
    private boolean keepRunning = true;
    private final SharedResource dictionary;

    public ComputeDataThread(SharedResource dictionary, String name) {
        this.dictionary = dictionary;
        this.setName(name);
    }

    @Override
    public void run() {
        while (keepRunning) {
            String [] keys = dictionary.getKeys();
            for (String key : keys) {
                String value = dictionary.get(key);
                //DOING SOMETHING WITH THE DATA
                System.out.println(getName() + " Key:" + key + " Value:" + value);
            }
            //update every seconds
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopReader() {
        this.keepRunning = false;
        this.interrupt();
    }
}

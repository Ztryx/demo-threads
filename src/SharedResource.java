import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by andyx on 17/5/18.
 */
public class SharedResource {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<String,String> dictionary = new HashMap<>();

    public void set(String key, String value) {
        readWriteLock.writeLock().lock();
        try {
            dictionary.put(key, value);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String get(String key) {
        readWriteLock.readLock().lock();
        try{
            return dictionary.get(key);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public String[] getKeys() {
        readWriteLock.readLock().lock();
        try {
            return (String[]) dictionary.keySet().toArray(new String[dictionary.size()]);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

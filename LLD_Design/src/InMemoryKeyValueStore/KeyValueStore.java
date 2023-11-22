package InMemoryKeyValueStore;

import java.util.HashMap;

public class KeyValueStore {
    HashMap<String, Integer> keyValueStore;
    Integer capacity;

    //
    public KeyValueStore(Integer capacity) {
        this.capacity = capacity;
        this.keyValueStore = new HashMap<>(capacity);
    }

    synchronized void putElement(String str, Integer value) throws IllegalAccessException {
        if(keyValueStore.containsKey(str) || keyValueStore.size()<capacity) {
            keyValueStore.put(str, value);
        } else {
            throw new IllegalAccessException("The capacity is reached");
        }
    }

    Integer getValue(String str) throws IllegalAccessException {
        if(keyValueStore.containsKey(str)) {
            return keyValueStore.get(str);
        } else {
            throw new IllegalAccessException("The value is not found");
        }
    }

    void removeElement(String str) throws IllegalAccessException {
        if(keyValueStore.containsKey(str)) {
            keyValueStore.remove(str);
        } else {
            throw new IllegalAccessException("The value is not found");
        }
    }
}

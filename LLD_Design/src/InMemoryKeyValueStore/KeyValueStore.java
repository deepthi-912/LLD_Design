package InMemoryKeyValueStore;

import java.util.HashMap;

public class KeyValueStore {
    HashMap<String, Integer> keyValueStore;

    synchronized void putElement(String str, Integer value) {
        keyValueStore.put(str, value);
    }

    Integer getValue(String str) {
        if(keyValueStore.containsKey(str)) {
            return keyValueStore.get(str);
        } else {
            System.out.println("Not found");
            return -1;
        }
    }

    void removeElement(String str) {
        if(keyValueStore.containsKey(str)) {
            keyValueStore.remove(str);
        } else {
            System.out.println("The element is not found!");
        }
    }

}

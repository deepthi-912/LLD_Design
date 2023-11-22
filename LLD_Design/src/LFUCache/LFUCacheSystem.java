package LFUCache;

import java.util.HashMap;

public class LFUCacheSystem {
    public static void main(String[] main) throws IllegalAccessException {
        HashMap<Integer, Integer> map = new HashMap<>();
        LFU lfuCache = new LFU(2, map);
        lfuCache.put(1, 3);
        lfuCache.put(3, 2);
        System.out.println(lfuCache.getValue(3));
        lfuCache.put(2,5);
        lfuCache.put(1,5);
        System.out.println(lfuCache.getValue(1));
        lfuCache.put(4,6);
        lfuCache.remove(3);
        System.out.println(lfuCache.getValue(3));
    }
}

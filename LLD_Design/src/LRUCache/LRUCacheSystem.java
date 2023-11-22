package LRUCache;

import java.util.HashMap;

public class LRUCacheSystem {
    public static void main(String [] args) throws IllegalAccessException {
        HashMap<Integer, Integer> lruCache = new HashMap<>();
        Cache cache = new Cache(lruCache, 2);
        cache.put(3, 2);
        System.out.println(cache.getValue(3));
        cache.put(2, 3);
        cache.put(1, 4);
        System.out.println(cache.getValue(1));
        cache.put(4, 5);
        System.out.println(cache.getValue(1));
        System.out.println(cache.getValue(4));
    }
}

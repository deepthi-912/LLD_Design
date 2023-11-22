package LRUCache;

import java.util.*;

public class Cache {
    private Map<Integer, Integer> lruCache = new HashMap<Integer, Integer>();

    //count number of times it is accessed
    private HashMap<Integer, Integer> accessCount = new HashMap<Integer, Integer>();
    List<Map.Entry<Integer, Integer>> sortedAccessCountMap;
    private Integer capacity;

    static Integer time = 0;

    // Put all elements from the unsorted map to the sorted map

    public Cache(Map<Integer, Integer> lruCache, Integer capacity) {
        this.lruCache = lruCache;
        this.capacity = capacity;
        for(Map.Entry<Integer, Integer> entry : this.lruCache.entrySet()) {
            accessCount.put(entry.getKey(), 0);
        }
    }

    Integer getValue(Integer key) throws IllegalAccessException {
        //if key is found
        time++;
        if(this.getLruCache().containsKey(key)) {
            this.accessCount.put(key, time);
            sortAccessCount(this.accessCount);
            return lruCache.get(key);
        } else {
            throw  new IllegalAccessException("Illegal access of the key");
        }
    }

    private void sortAccessCount(HashMap<Integer, Integer> accessCount) {
        sortedAccessCountMap = new ArrayList<>(accessCount.entrySet());
        Collections.sort(sortedAccessCountMap, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }

    void put(Integer key, Integer value) throws IllegalAccessException {
        time++;
        // for example if size is zero
        if(this.getCapacity() == 0) {
            throw new IllegalAccessException("Capacity is zero for the cache");
        }
        else if(this.getCapacity()> this.getLruCache().size()) {
            this.getLruCache().put(key, value);
//            System.out.println(key + " " + value);
            this.accessCount.put(key, time);
        } else {
            Integer evictKey = this.sortedAccessCountMap.iterator().next().getKey();
            this.sortedAccessCountMap.remove(evictKey);
            this.accessCount.remove(evictKey);
            this.getLruCache().remove(evictKey);
            this.getLruCache().put(key, value);
//            System.out.println(key + " " + value);
            this.accessCount.put(key, time);
        }
        sortAccessCount(this.accessCount);
    }

    public Map<Integer, Integer> getLruCache() {
        return lruCache;
    }

    public void setLruCache(Map<Integer, Integer> lruCache) {
        this.lruCache = lruCache;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

package LFUCache;

import java.util.*;

public class LFU {
    Integer capacity;
    HashMap<Integer, Integer> lfuCache = new HashMap<>();
    HashMap<Integer, Integer> lfuAccessCount = new HashMap<>();
    List<Map.Entry<Integer, Integer>> sortedLfuAccessList;
    public LFU(Integer capacity, HashMap<Integer, Integer> lfuCache) {
        this.capacity = capacity;
        this.lfuCache = lfuCache;
    }

    Integer getValue(Integer key) throws IllegalAccessException {
        if(this.getLfuCache().containsKey(key)) {
            Integer count = this.lfuAccessCount.get(key);
            this.lfuAccessCount.put(key, count+1);
            // sort values
            sortByValues(lfuAccessCount);
            return this.lfuCache.get(key);
        } else {
            throw new IllegalAccessException("No such key is present");
        }
    }

    void put(Integer key, Integer value) throws IllegalAccessException {
        if(this.getCapacity()==0) {
            throw new IllegalAccessException("Capacity is zero");
        } else if(this.getCapacity()> this.getLfuCache().size()) {
            this.lfuAccessCount.put(key, this.lfuAccessCount.getOrDefault(key, 0)+1);
            this.lfuCache.put(key, value);
        } else {
            Integer evictKey = this.sortedLfuAccessList.iterator().next().getKey();
            this.lfuAccessCount.remove(evictKey);
            this.lfuCache.remove(evictKey);
            this.lfuAccessCount.put(key, this.lfuAccessCount.getOrDefault(key, 0)+1);
            this.lfuCache.put(key, value);
        }
        sortByValues(lfuAccessCount);
    }

    void remove(Integer key) throws IllegalAccessException {
        if(this.getLfuCache().containsKey(key)) {
            this.lfuAccessCount.remove(key);
            this.getLfuCache().remove(key);
        } else {
            throw new IllegalAccessException("No such key is present");
        }
        sortByValues(lfuAccessCount);
    }

    void sortByValues(HashMap<Integer, Integer> lfuAccessCount) {
        sortedLfuAccessList = new ArrayList<>(lfuAccessCount.entrySet());
        Collections.sort(sortedLfuAccessList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public HashMap<Integer, Integer> getLfuCache() {
        return lfuCache;
    }

    public void setLfuCache(HashMap<Integer, Integer> lfuCache) {
        this.lfuCache = lfuCache;
    }

    public HashMap<Integer, Integer> getLfuAccessCount() {
        return lfuAccessCount;
    }

    public void setLfuAccessCount(HashMap<Integer, Integer> lfuAccessCount) {
        this.lfuAccessCount = lfuAccessCount;
    }

    public List<Map.Entry<Integer, Integer>> getSortedLfuAccessList() {
        return sortedLfuAccessList;
    }

    public void setSortedLfuAccessList(List<Map.Entry<Integer, Integer>> sortedLfuAccessList) {
        this.sortedLfuAccessList = sortedLfuAccessList;
    }
}

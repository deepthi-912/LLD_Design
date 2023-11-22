package VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum LocationStatus {
    FILLED, EMPTY, BLOCKED;
}
class Item {
    String item;
    Integer quantity;
    Double profit;
    Double price;

    public Item(String item, Integer quantity, Double profit, Double price) {
        this.item = item;
        this.quantity = quantity;
        this.profit = profit;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
class ItemInstance {
    String itemId;
    String item;
    Location location;

    public ItemInstance(String itemId, String item, Location location) {
        this.itemId = itemId;
        this.item = item;
        this.location = location;
    }
}
class Location {
    Integer row;
    Integer column;
    LocationStatus locationStatus;

    public Location(Integer row, Integer column, LocationStatus locationStatus) {
        this.row = row;
        this.column = column;
        this.locationStatus = locationStatus;
    }
}

public class VendingMachineSystem {
    HashMap<Location, ItemInstance> itemInstanceHashMap = new HashMap<>();
    HashMap<String, Item> itemsMap = new HashMap<>();
    List<Location> locationList;
    Double availableMoney;
    static Double netProfit;
    Double getItem(ItemInstance item, Double money) {
        Double change = money - itemsMap.get(item.item).price;
        if(itemsMap.get(item.item).quantity>0 && availableMoney>=change) {
            itemsMap.get(item).quantity-=1;
            item.location.locationStatus = LocationStatus.EMPTY;
            itemInstanceHashMap.remove(item.location);
            availableMoney-=change;
            netProfit += itemsMap.get(item.item).profit;
            return change;
        } else if(itemsMap.get(item.item) == null || itemsMap.get(item.item).quantity<=0) {
            System.out.println("Item is not present");
        } else if (money>=change) {
            System.out.println("Sorry, change is not available. Try inserting exact price money");
        }
        return money;
    }
    void addItem(Item item) {
        if(spaceAvailable(item.quantity, locationList)) {
            itemsMap.put(item.item, item);
            //update locations where it is placed
            // add each item instances into item instance map
        } else {
            System.out.println("Space is not available for all items");
        }
    }
    boolean spaceAvailable(Integer quantity, List<Location> locations) {
        Integer count = 0;
        for(int i=0;i<locations.size();i++) {
            if(locations.get(i).locationStatus == LocationStatus.EMPTY) {
                count++;
            }
        }
        if(count>=quantity) {
            return true;
        }
        return false;
    }

    Location firstSpaceAvailable(Integer row, Integer col) {
        Integer count = 0;
        for(int i=0;i<this.locationList.size();i++) {
            if(this.locationList.get(i).locationStatus == LocationStatus.EMPTY) {
                return locationList.get(i);
            }
        }
        return null;
    }
    public void VendingMachine(Double money, Integer rows, Integer columns) {
        this.availableMoney = money;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                Location location = new Location(i, j, LocationStatus.EMPTY);
                this.locationList.add(location);
            }
        }
    }

    public Double getNetProfit() {
        return netProfit;
    }
    List<ItemInstance> getInventory() {
        List<ItemInstance> instanceList = new ArrayList<>();
        for(Map.Entry<Location, ItemInstance> entry : itemInstanceHashMap.entrySet()) {
            instanceList.add(entry.getValue());
        }
        return instanceList;
    }
    public static void main(String[] args) {

    }
}

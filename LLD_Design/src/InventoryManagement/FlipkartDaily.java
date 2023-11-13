package InventoryManagement;

import java.util.*;

class Item {
    String brandName;
    String category;
    Double price;

    public Item(String brandName, String category, Double price) {
        this.brandName = brandName;
        this.category = category;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
class Inventory {
    String inventoryName;
    String inventoryBrand;
    Integer quantity;

    public Inventory(String inventoryName, String inventoryBrand, Integer quantity) {
        this.inventoryName = inventoryName;
        this.inventoryBrand = inventoryBrand;
        this.quantity = quantity;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryBrand() {
        return inventoryBrand;
    }

    public void setInventoryBrand(String inventoryBrand) {
        this.inventoryBrand = inventoryBrand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
class SearchBrandService {
    String brandKey;
    static List<Inventory> getItemsByBrand(List<String> searchItems, HashMap<String, Inventory> inventory, List<Inventory> inventories) {
        for(int i=0;i<searchItems.size();i++) {
            if(inventory.containsKey(searchItems.get(i))) {
                inventories.add(inventory.get(searchItems.get(i)));
            }
        }
        ArrangeValues.arrangeInventory(inventories);
        return inventories;
    }
}
class SearchCategoryService {
    static List<Inventory> getItemsByBrand(List<String> searchItems, HashMap<String, Inventory> inventory,  List<Inventory> inventories) {
        for(int i=0;i<searchItems.size();i++) {
            for(Map.Entry<String, Inventory> entry : inventory.entrySet()) {
                if(entry.getValue().getInventoryBrand().equals(searchItems.get(i))) {
                    inventories.add(inventory.get(searchItems.get(i)));
                }
            }
        }
        ArrangeValues.arrangeInventory(inventories);
        return inventories;
    }
}
class SearchPriceService {
    Double minPrice;
    Double maxPrice;
    static List<Inventory> getItemsByPrice(Integer minPrice, Integer maxPrice, HashMap<String, Inventory> inventory, HashMap<String, Item> itemsMap, List<Inventory> inventories) {
        for(Map.Entry<String, Item> entry : itemsMap.entrySet()) {
            if(entry.getValue().getPrice()>=minPrice && entry.getValue().getPrice()<=maxPrice && inventory.get(entry.getKey()).getQuantity()>0) {
                inventories.add(inventory.get(entry.getKey()));
            }
        }
        ArrangeValues.arrangeInventory(inventories);
        return inventories;
    }
}
class ArrangeValues {
    static void arrangeInventory(List<Inventory> inventoryList) {
        Collections.sort(inventoryList, Comparator.comparingDouble(Inventory::getQuantity));
    }
    static void arrangeInventoryDesc(List<Inventory> inventoryList) {
        Collections.sort(inventoryList, Comparator.comparingDouble(Inventory::getQuantity).reversed());
    }
}

class Isearch {

    List<HashMap<String, String>> searchItemsList = new ArrayList<>();
    HashMap<String, Inventory> inventoryMap = new HashMap<>();
    List<Inventory> getInputs(List<HashMap<String, String>> searchItemsList) {
        List<Inventory> inventoryList = new ArrayList<>();
        for(int i=0;i<searchItemsList.size();i++) {
            for(Map.Entry<String, String> entry: searchItemsList.get(i).entrySet()) {
                if(entry.getKey().equals("category")) {
                    List<String> categoryList = List.of(entry.getValue().split(","));
                    SearchCategoryService.getItemsByBrand(categoryList, inventoryMap, inventoryList);
                } else if(entry.getKey().equals("Order_By")) {
                   //
                } else if(entry.getKey().equals("price")) {
                    //
                }
            }
        }
        return inventoryList;
    }
}
class SearchService {

}
public class FlipkartDaily {
    HashMap<String, Item> items = new HashMap<>();
    HashMap<String, Inventory> inventoryMap = new HashMap<>();
    void addItem(String itemName, String category, Double price) {
        if(!items.containsKey(itemName)) {
            Item item = new Item(itemName, category, price);
            items.put(itemName, item);
        }
    }
    void addInventory(String itemName, String category, Integer quantity) {
        if(!items.containsKey(itemName)) {
            Inventory item = new Inventory(itemName, category, quantity);
            inventoryMap.put(itemName, item);
        }
    }
}

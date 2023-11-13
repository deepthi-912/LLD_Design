package PropertyManagement;

import java.util.*;

enum PropertyType {
    APARTMENT, TOWNHOUSE, SINGLE_FAMILY;
}
enum PropertyStatus {
    SOLD, SHORTLISTED, UNAVAILABLE, AVAILABLE;
}
class User {
    String userId;
    String name;
    String email;
    String phoneNum;
    String address;
    String password;

    public User(String userId, String name, String email, String phoneNum, String address, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
        this.password = password;
    }
}
class Address {
    String street;
    String apartmentNum;
    String state;
    String country;
    String pincode;
}
class RegisterUserService {
    static User registerNewUser(String userId, String name, String email, String phoneNum, String address, String password) {
        User user = new User(userId, name, email, phoneNum, address, password);
        return user;
    }
}
class Property {
    String propertyId;
    String propertyName;
    String address;
    PropertyType propertyType;
    Integer roomNumber;
    String listedByUser;
    Date listedDate;
    PropertyStatus propertyStatus;
    Date soldDate;
    Double propertyPrice;

    public Property(String propertyId, String propertyName, String address, PropertyType propertyType, Integer roomNumber, String listedByUser, Date listedDate, PropertyStatus propertyStatus, Date soldDate, Double propertyPrice) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.address = address;
        this.propertyType = propertyType;
        this.roomNumber = roomNumber;
        this.listedByUser = listedByUser;
        this.listedDate = listedDate;
        this.propertyStatus = propertyStatus;
        this.soldDate = soldDate;
        this.propertyPrice = propertyPrice;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getListedByUser() {
        return listedByUser;
    }

    public void setListedByUser(String listedByUser) {
        this.listedByUser = listedByUser;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    public PropertyStatus getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(PropertyStatus propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }
}
class Shortlist {
    String propertyId;
    String userId;

    public Shortlist(String propertyId, String userId) {
        this.propertyId = propertyId;
        this.userId = userId;
    }
}
class SearchService {
    static List<Property> searchPropertiesByRooms(Integer roomNum, HashMap<String, Property> lisOfProperties) {
        List<Property> propertyList = new ArrayList<>();
        for(Map.Entry<String, Property> entry : lisOfProperties.entrySet()) {
            Property propertyEntry = entry.getValue();
            if(propertyEntry.getRoomNumber()==roomNum) {
                propertyList.add(propertyEntry);
            }
        }
        return propertyList;
    }

    static List<Property> searchPropertiesByAddress(String landmark, HashMap<String, Property> lisOfProperties) {
        List<Property> propertyList = null;
        for(Map.Entry<String, Property> entry : lisOfProperties.entrySet()) {
            Property propertyEntry = entry.getValue();
            if(propertyEntry.getAddress().equals(landmark)) {
                propertyList.add(propertyEntry);
            }
        }
        return propertyList;
    }
    static List<Property> searchPropertiesByRange(Double minPrice, Double maxPrice, HashMap<String, Property> lisOfProperties) {
        List<Property> propertyList = new ArrayList<>();
        for(Map.Entry<String, Property> entry : lisOfProperties.entrySet()) {
            Property propertyEntry = entry.getValue();
            if(propertyEntry.getPropertyPrice() >= minPrice && entry.getValue().getPropertyPrice()<=maxPrice) {
                propertyList.add(propertyEntry);
            }
        }
        return propertyList;
    }

}
public class PropertyManagementSystem {
    static HashMap<String, Property> lisOfProperties = new HashMap<>();
    static List<Shortlist> usersShortlists = new ArrayList<>();
    static void addProperty(String propertyId, Property property) {
        lisOfProperties.put(propertyId, property);
    }
    static void shortListProperty(String propertyId, String userId) {
        Shortlist shortlist = new Shortlist(propertyId, userId);
        usersShortlists.add(shortlist);
    }
    void changePropertyStatus(String propertyId, String userId, PropertyStatus propertyStatus) {
        if(userId.equals(lisOfProperties.get(propertyId).getListedByUser())) {
            lisOfProperties.get(propertyId).setPropertyStatus(PropertyStatus.SOLD);
        }
    }
    public static void main(String[] main) {
        User seller = RegisterUserService.registerNewUser("123", "Deepthi", "chdeep@gmail.com", "9290266691", "4010 W Housing Dr", "sfgsf");
        Date date = new Date();
        Property property = new Property("1", "Deeps property",  "5010 W Housing Dr",  PropertyType.APARTMENT,  3,  "123",  date,  PropertyStatus.AVAILABLE,  null, 120000.0);
        addProperty("1", property);
        User user = RegisterUserService.registerNewUser("1234", "Pavs", "chdeepss@gmail.com", "9290264691", "401 W Housing Dr", "sfgf");
        shortListProperty("1", "1234");
        SearchService.searchPropertiesByRange(12220.0, 123333.0, lisOfProperties);
        List<Property> propertyList = SearchService.searchPropertiesByRooms(3, lisOfProperties);
        for(int i=0;i<propertyList.size();i++) {
            System.out.println(propertyList.get(i).propertyName + " price -- " + propertyList.get(i).getPropertyPrice());
        }
    }
}

package InMemoryKeyValueStore;

public class KeyValuePairSystem {
    public static void main(String []args) throws IllegalAccessException {
        KeyValueStore keyValuePair = new KeyValueStore(3);
        keyValuePair.putElement("s1", 1);
        keyValuePair.putElement("s2", 2);
        keyValuePair.putElement("s3", 5);
        System.out.println(keyValuePair.getValue("s3"));
        System.out.println(keyValuePair.getValue("s2"));
        System.out.println(keyValuePair.getValue("s1"));
        keyValuePair.putElement("s2", 5);
        System.out.println(keyValuePair.getValue("s2"));
        keyValuePair.removeElement("s1");
        keyValuePair.removeElement("s2");
        keyValuePair.getValue("s2");
    }
}

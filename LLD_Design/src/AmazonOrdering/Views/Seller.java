package AmazonOrdering.Views;

import java.util.ArrayList;
import java.util.List;

class Seller extends User {
    String userId;
    List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        this.productList.add(product);
    }
}

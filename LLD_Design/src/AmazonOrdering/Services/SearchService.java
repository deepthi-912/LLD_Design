package AmazonOrdering.Services;

import AmazonOrdering.Views.Product;

import java.util.HashMap;
import java.util.List;

class SearchService {
    HashMap<String, List<Product>> searchByCategory = new HashMap<>();
    HashMap<String, List<Product>> searchByName = new HashMap<>();

    List<Product> getProductsByCategory(String productCategory) {
        return this.searchByCategory.get(productCategory);
    }

    List<Product> getProductsByName(String productName) {
        return this.searchByCategory.get(productName);
    }

}

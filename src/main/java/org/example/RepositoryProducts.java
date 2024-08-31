package org.example;

import java.util.ArrayList;
import java.util.List;

public  class RepositoryProducts {
    public static  final List<Product> products = new ArrayList<>();
    public static List<Product> getProducts() {
        return products;
    }
    public static void addProduct(Product product) {
        products.add(product);
    }
}

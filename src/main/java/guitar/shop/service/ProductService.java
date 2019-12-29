package guitar.shop.service;

import guitar.shop.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProduct();
}

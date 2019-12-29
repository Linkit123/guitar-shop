package guitar.shop.dao;

import guitar.shop.model.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    List<Product> getAllProduct();
}

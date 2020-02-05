package guitar.shop.service.Impl;

import guitar.shop.dao.ProductDAO;
import guitar.shop.model.Product;
import guitar.shop.service.ProductService;
import guitar.shop.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public void addProduct(Product product) {
        String id= "";
        if(product.getId() == null) {
            id = ProductUtils.generateCustomerId(8);
        }else {
            id = product.getId();
        }
        product.setId(id);
        productDAO.addProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }
}
package guitar.shop.service.Impl;

import guitar.shop.DTO.ProductDTO;
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
        if(product.getProductId() == null) {
            id = ProductUtils.generateCustomerId(8);
        }else {
            id = product.getProductId();
        }
        product.setProductId(id);
        productDAO.addProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }

    private Product convertToModel(ProductDTO productDTO) {
        Product product = new Product();
        try {
            product.setAmount((String) productDTO.getAmount());
            product.setColor((String) productDTO.getColor());
            product.setDiscount((String) productDTO.getDiscount());
            product.setImage((String) productDTO.getImage());
            product.setName((String) productDTO.getName());
            product.setPrice((Integer) productDTO.getPrice());
            product.setUpdatedDate((String) productDTO.getUpdatedDate());
            product.setWeight((Integer) productDTO.getWeight());
        } catch (Exception e) {

        }
        return product;
    }
}
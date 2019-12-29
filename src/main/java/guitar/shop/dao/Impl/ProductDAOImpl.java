package guitar.shop.dao.Impl;

import guitar.shop.dao.ProductDAO;
import guitar.shop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            productList = session.createQuery("FROM Product", Product.class).getResultList();
        }
        catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        finally {
            session.close();
        }
        return productList;
    }

}

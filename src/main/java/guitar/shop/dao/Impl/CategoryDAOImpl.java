package guitar.shop.dao.Impl;

import guitar.shop.dao.CategoryDAO;
import guitar.shop.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        Session session = sessionFactory.getCurrentSession();
        List<Category> categoryList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            categoryList = session.createQuery("FROM Category", Category.class).getResultList();
        }
        catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        finally {
            session.close();
        }
        return categoryList;
    }
}

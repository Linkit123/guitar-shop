package guitar.shop.dao.Impl;

import guitar.shop.dao.SupplierDAO;
import guitar.shop.model.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Repository
public class SupplierDAOImpl implements SupplierDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSupplier(Supplier supplier) {
        Session session = sessionFactory.getCurrentSession();
        session.save(supplier);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        Session session = sessionFactory.getCurrentSession();
        List<Supplier> supplierList = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            supplierList = session.createQuery("FROM Supplier", Supplier.class).getResultList();
        }
        catch(Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        finally {
            session.close();
        }
        return supplierList;
    }
}

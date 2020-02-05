package guitar.shop.service.Impl;

import guitar.shop.dao.SupplierDAO;
import guitar.shop.model.Supplier;
import guitar.shop.service.SupplierService;
import guitar.shop.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierDAO supplierDAO;

    @Override
    public void addSupplier(Supplier supplier) {
        String id= "";
        if(supplier.getId() == null) {
            id = ProductUtils.generateCustomerId(8);
        }else {
            id = supplier.getId();
        }
        supplier.setId(id);
        supplierDAO.addSupplier(supplier);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierDAO.getAllSupplier();
    }
}
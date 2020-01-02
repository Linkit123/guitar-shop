package guitar.shop.dao;

import guitar.shop.model.Supplier;

import java.util.List;

public interface SupplierDAO {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSupplier();
}

package guitar.shop.service;

import guitar.shop.model.Supplier;

import java.util.List;

public interface SupplierService {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSupplier();
}

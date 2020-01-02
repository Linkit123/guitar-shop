package guitar.shop.controller;

import guitar.shop.model.Supplier;
import guitar.shop.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/supplier", produces = MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    private static final Logger LOGGER  = LoggerFactory.getLogger(SupplierController.class);
    private static final String CODE_ERROR  = "ERROR";
    private static final String CODE_CREATED  = "CREATED";
    private static final String CODE_EXISTED = "EXISTED";
    private static final String CODE_SUCCESS = "SUCCESS";
    private static final String NOT_FOUND = "NOT_FOUND";

    @GetMapping(value = "/_search")
    public ResponseEntity<List<Supplier>> getAllCustomer(){
        List<Supplier> supplierList = new ArrayList<>();
        try {
            supplierList = supplierService.getAllSupplier();
            if (supplierList.isEmpty()) {
                return new ResponseEntity<>(supplierList, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(supplierList, HttpStatus.FOUND);
        }catch (Exception e ){
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(supplierList, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/_create")
    public ResponseEntity<Object> addCustomer(@RequestBody Supplier supplier){
        HashMap<String, Object> productResponse = new HashMap<>();
        try {
            supplierService.addSupplier(supplier);
            productResponse.put("status", CODE_CREATED);
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}

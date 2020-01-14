package guitar.shop.controller;

import guitar.shop.model.Product;
import guitar.shop.service.ProductService;
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
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
public class ProductController {

    @Autowired
    ProductService productService;

    private static final Logger LOGGER  = LoggerFactory.getLogger(ProductController.class);
    private static final String CODE_ERROR  = "ERROR";
    private static final String CODE_CREATED  = "CREATED";
    private static final String CODE_EXISTED = "EXISTED";
    private static final String CODE_SUCCESS = "SUCCESS";
    private static final String NOT_FOUND = "NOT_FOUND";

    @GetMapping(value = "/_search")
    public ResponseEntity<List<Product>> getAllCustomer(){
        List<Product> customer = new ArrayList<>();
        try {
            customer = productService.getAllProduct();
            if (customer.isEmpty()) {
                return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customer, HttpStatus.FOUND);
        }catch (Exception e ){
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/_create")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        HashMap<String, Object> productResponse = new HashMap<>();
        try {
            productService.addProduct(product);
            productResponse.put("status", CODE_CREATED);
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}

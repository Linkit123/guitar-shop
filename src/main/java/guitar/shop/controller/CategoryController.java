package guitar.shop.controller;

import guitar.shop.model.Category;
import guitar.shop.service.CategoryService;
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
@RequestMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    private static final Logger LOGGER  = LoggerFactory.getLogger(CategoryController.class);
    private static final String CODE_ERROR  = "ERROR";
    private static final String CODE_CREATED  = "CREATED";
    private static final String CODE_EXISTED = "EXISTED";
    private static final String CODE_SUCCESS = "SUCCESS";
    private static final String NOT_FOUND = "NOT_FOUND";

    @GetMapping(value = "/_search")
    public ResponseEntity<List<Category>> getAllCustomer(){
        List<Category> categories = new ArrayList<>();
        try {
            categories = categoryService.getAllCategory();
            if (categories.isEmpty()) {
                return new ResponseEntity<>(categories, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(categories, HttpStatus.FOUND);
        }catch (Exception e ){
            LOGGER.error(e.getMessage(), e);
            return new ResponseEntity<>(categories, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/_create")
    public ResponseEntity<Object> addCustomer(@RequestBody Category category){
        HashMap<String, Object> productResponse = new HashMap<>();
        try {
            categoryService.addCategory(category);
            productResponse.put("status", CODE_CREATED);
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}

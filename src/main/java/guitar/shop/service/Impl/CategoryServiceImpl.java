package guitar.shop.service.Impl;

import guitar.shop.dao.CategoryDAO;
import guitar.shop.model.Category;
import guitar.shop.service.CategoryService;
import guitar.shop.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public void addCategory(Category category) {
        String id= "";
        if(category.getCategoryId() == null) {
            id = ProductUtils.generateCustomerId(8);
        }else {
            id = category.getCategoryId();
        }
        category.setCategoryId(id);
        categoryDAO.addCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDAO.getAllCategory();
    }
}
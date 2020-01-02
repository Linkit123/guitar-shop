package guitar.shop.dao;

import guitar.shop.model.Category;

import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category);
    List<Category> getAllCategory();
}

package guitar.shop.service;

import guitar.shop.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);
    List<Category> getAllCategory();
}

package store.populators;

import Categories.Category;
import Categories.CategoryEnum;
import Categories.Product;

import java.util.List;

public interface IPopulator {
    List<Category> getCategories();

    List<Product> getProductsForCategory(CategoryEnum category);

}

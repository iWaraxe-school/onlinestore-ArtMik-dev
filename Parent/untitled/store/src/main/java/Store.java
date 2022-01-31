

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
public class Store  {

    public RandomStorePopulator populator = new RandomStorePopulator();
    public List<Category> categories;

    public Store() {

        try {
            categories = populator.getCategoriesShop();
        }catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void viewStore() {
        for (Category category: categories) {
            System.out.println(StringUtils.join(category.getName(), " "));
            for (Product product: category.getProducts()) {
                System.out.println(StringUtils.join(product.toString()));
            }
        }

    }

}

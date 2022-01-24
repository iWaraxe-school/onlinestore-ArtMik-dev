

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
public class Store {

    RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public Store() throws InstantiationException, IllegalAccessException {
        this.categories = randomStorePopulator.getCategories();
    }

    public void printStoreData() {
        for (Category category: categories){
            System.out.println("\n" + "--------------------------------------------");
            System.out.println("\n" + "CATEGORY NAME: " + category.getName());
            System.out.println("\n" + "PRODUCTS: " + category.getProducts());

        }
    }


 /*   public List<Product> getAllProducts() {
        List<Product> allProductsFromAllCategories = new ArrayList<>();
        for (Category category: categories){
            for(Product product: category.getProducts()){
                allProductsFromAllCategories.add(product);
            }
        }
        return allProductsFromAllCategories;
    }*/
}


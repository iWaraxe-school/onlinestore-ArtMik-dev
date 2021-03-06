package Categories;

import java.util.Collection;
import java.util.List;

public class Category {

    private String name;
    private List<Product> products;

    public Category(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Collection<? extends Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

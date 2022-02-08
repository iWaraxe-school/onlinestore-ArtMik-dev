import com.github.javafaker.Faker;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RandomStorePopulator {

    Reflections reflections = new Reflections();
    Set<Class<? extends Category>> subCategories = reflections.getSubTypesOf(Category.class);
    Faker faker = new Faker();

    public List<Product> products = new ArrayList<>();
    public List<Category> categories = new ArrayList<>();

    public Product FakeProduct(String fakeName) {
        Product newProduct = new Product(fakeName, faker.number().numberBetween(1, 70), (int) faker.number().randomDouble(2, 3, 1));
        return newProduct;
    }

    public List<Category> getCategories() throws IllegalAccessException, InstantiationException {
        for (Class<? extends Category> subCategory : subCategories) {
            Category category = subCategory.newInstance();
            int ProductNumber = faker.number().numberBetween(1, 5);
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < ProductNumber; i++) {
                switch (category.getName()) {
                    case "Fruit":
                        products.add(FakeProduct(faker.food().fruit()));
                        break;
                    case "Hobbit":
                        products.add(FakeProduct(faker.hobbit().character()));
                        break;
                    case "Finance":
                        products.add(FakeProduct(faker.finance().bic()));
                        break;
                }
                category.setProducts(products);
            }
            categories.add(category);
        }
        return categories;
    }
}







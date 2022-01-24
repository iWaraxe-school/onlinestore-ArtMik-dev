import com.github.javafaker.Faker;
import com.github.javafaker.Finance;
import com.github.javafaker.Food;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static javax.xml.xpath.XPathFactory.newInstance;

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


   /* Random random = new Random();


    public Food getFaker() {
        return faker.food();
    }

    public int randomNumber(int number) {

        return random.nextInt(number - 1) + 1;
    }

    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Fruit("Fruit", getProduct(new Fruit())));
        //categories.add(new Finance("Finance", getProduct(new Finance())));
        return categories;
    }
    public List<Product> getProduct(Category category) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (category instanceof Fruit) {
                products.add(new Product(getFaker().fruit(), randomNumber(20), randomNumber(20)));
            }
        }
        return products;
    }

}
*/




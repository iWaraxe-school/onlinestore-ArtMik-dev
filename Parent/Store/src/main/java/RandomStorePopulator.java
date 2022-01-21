import com.github.javafaker.Faker;
import com.github.javafaker.Finance;
import com.github.javafaker.Food;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomStorePopulator {
    Faker faker = new Faker();
    Random random = new Random();


    public Food getFaker() {
        return faker.food();
    }

    public int randomNumber(int number) {

        return random.nextInt(number - 1) + 1;
    }

    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Fruit("Fruit", getProduct(new Fruit())));
        categories.add(new Finance("Finance", getProduct(new Finance())));
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





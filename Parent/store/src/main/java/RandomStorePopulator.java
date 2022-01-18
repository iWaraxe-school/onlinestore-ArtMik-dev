import com.github.javafaker.Faker;
import com.github.javafaker.Food;
//import

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStorePopulator {
    Faker fake = new Faker();
    Random random = new Random();

    public Food getFaker() {
        return fake.food();
    }


    public int randomNumber(int number) {
        return random.nextInt(number - 1) + 1;
    }

    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Spice("Spice", getProduct(new Spice())));
        categories.add(new Sushi("Sushi", getProduct(new Sushi())));
        return categories;
    }

    public List<Product> getProduct(Category category) {
        List<Product> products = new ArrayList<>();
        {
            if (category instanceof Spice) {
                products.add(new Product(getFaker().spice(), randomNumber(30), randomNumber(30)));
            } else if (category instanceof Sushi) {
                products.add(new Product(getFaker().spice(), randomNumber(30), randomNumber(30)));
            }
            return products;
        }
    }
}


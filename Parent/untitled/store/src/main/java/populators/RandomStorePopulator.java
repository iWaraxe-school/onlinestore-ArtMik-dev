package populators;

import Categories.Category;
import Categories.CategoryEnum;
import Categories.Product;
import com.github.javafaker.Faker;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomStorePopulator implements IPopulator {

    private Faker faker = new Faker();

    @Override
    public List<Category> getCategories() {

        List<Category>  categories = new ArrayList<>();

        Reflections reflections = new Reflections("Categories", new SubTypesScanner());

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {
            try {
                categories.add(type.getConstructor().newInstance());

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

        return categories;
    }

    @Override
    public List<Product> getProductsForCategory(CategoryEnum category){

        List<Product> resultList = new ArrayList<>();
        Random random = new Random();
        int productCount = random.nextInt(3);

        resultList.addAll(generateProductList(category, productCount));

        return resultList;
    }

    private List<Product> generateProductList(CategoryEnum category, int count) {
        List<Product> resultList = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            resultList.add(new Product(generateFakeProductName(category), getPrice(), getRate()));
        }

        return resultList;
    }

    private String generateFakeProductName(CategoryEnum category) {

        switch (category) {
            case Finance:
                return faker.finance().bic();
            case Hobbit:
                return faker.hobbit().character();
            case Fruit:
                return faker.food().fruit();
            default:
                return null;
        }
    }

    private int getPrice() {

        return faker.number().numberBetween(1, 100);
    }

    private int getRate() {

        return faker.number().numberBetween(1, 5);
    }
}







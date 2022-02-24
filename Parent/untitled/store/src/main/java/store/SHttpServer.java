package store;

import Categories.Category;
import Categories.CategoryEnum;
import Categories.Product;
import com.sun.net.httpserver.HttpServer;
import store.populators.DBPopulator;
import store.populators.IPopulator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SHttpServer {
    public static final int PORT = 8080;
    public static final String URL = String.format("http://localhost:%s", PORT);
    public static final String CATEGORIES_URL = String.format("%s/categories", URL);
    public static final String PRODUCTS_URL = String.format("%s/productsForCategory", URL);
    public static final String CART_URL = String.format("%s/cart", URL);


    public IPopulator populator = new DBPopulator();
    public List<Category> categoryList = new ArrayList<>();
    public static List<Product> cartProductList = new ArrayList<>();

    public SHttpServer() {
        run();
    }

    public void run() {

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

            List<Category> allCategories = (new DBPopulator()).getCategories();
            for (Category category : allCategories) {
                server.createContext(String.format("/productsForCategory/%s", category.getName()), new GetProductsHandler(CategoryEnum.valueOf(category.getName()), this));
            }

            server.createContext("/categories", new GetCategoriesHandler(this));
            server.createContext("/cart", new GetHandlerCart(this));

            System.out.println(PORT);
            server.setExecutor(null);
            server.start();

        } catch (IOException e) {
            System.out.println(PORT);
        }
    }

    public List<Category> getCategories() {

        if (categoryList != null) {
            categoryList = populator.getCategories();
        }

        return categoryList;
    }

    public List<Product> getProductsForCategory(CategoryEnum categoryName) {

        List<Product> products = populator.getProductsForCategory(categoryName);


        Category category = categoryList.stream().filter(x -> x.getName().equals(categoryName.name())).findFirst().get();
        category.setProducts(products);

        return products;
    }


    public Product addProductToCart(String productName) {
        Product product = getSelectedProduct(productName);
        cartProductList.add(product);

        return product;
    }

    private Product getSelectedProduct(String productName) {
        Optional<Product> orderedProduct =  getAllProducts().stream().filter(x -> x.name.equals(productName)).findFirst();

        Product product = orderedProduct.isPresent() ? orderedProduct.get() : null;

        return product;
    }

    private List<Product> getAllProducts() {

        List<Product> allProducts = new ArrayList<>();

        for (Category category : this.categoryList) {
            allProducts.addAll(category.getProducts());
        }

        return allProducts;
    }
    public List<Product> getProductsCart() {
        return cartProductList;
    }
}

